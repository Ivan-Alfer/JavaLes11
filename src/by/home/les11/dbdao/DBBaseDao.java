package by.home.les11.dbdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.home.les11.dao.BaseDao;
import by.home.les11.dao.exception.DaoException;
import by.home.les11.dbresourcemanager.DBResourceManager;

public abstract class DBBaseDao<T> implements BaseDao<T> {
	private Statement stmt;
	protected Connection con;
	private PreparedStatement psForInsert;
	private PreparedStatement psForDelete;
	private PreparedStatement psForUpdate;

	protected abstract String getAllSelectQuery();

	protected abstract String getInserQuery();

	protected abstract String getDeleteQuery();

	protected abstract String getUpdateQuery();

	protected abstract T parseSelectResultSet(ResultSet rs) throws DaoException;

	protected abstract void populatePrepareStatementForInsertItem(T item, PreparedStatement ps) throws DaoException;

	protected abstract void populatePrepareStatementForUpdateItem(PreparedStatement ps, T item) throws DaoException;

	public DBBaseDao() throws DaoException {
		try {
			takeConnection();
		} catch (DaoException e1) {
			e1.printStackTrace();
		}

		try {

			stmt = con.createStatement();

			psForInsert = con.prepareStatement(getInserQuery());

			psForDelete = con.prepareStatement(getDeleteQuery());

			psForUpdate = con.prepareStatement(getUpdateQuery());

		} catch (SQLException e) {
			throw new DaoException();
		}
	}
	
	private void takeConnection() throws DaoException {
		DBResourceManager dbResourseManager = DBResourceManager.getInstance();
		try {
			Class.forName(dbResourseManager.getValue(DBResourceManager.DB_DRIVER));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dbResourseManager.getValue(DBResourceManager.DB_URL), dbResourseManager.getValue(DBResourceManager.DB_USER), dbResourseManager.getValue(DBResourceManager.DB_PASSWORD));
		} catch (SQLException e) {
			throw new DaoException();
		}
	}	

	public List<T> getItems() throws DaoException {
		List<T> items = new ArrayList<T>();
		String query = getAllSelectQuery();
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				T item = parseSelectResultSet(rs);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DaoException();
				}
			}
		}
		return items;
	}

	public void addItem(T item) throws DaoException {
		try {
			if (item != null) {
				populatePrepareStatementForInsertItem(item, psForInsert);
			}
			psForInsert.execute();
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	public void deleteItem(int id) throws DaoException {
		try {
			if (id != 0) {
				psForDelete.setInt(1, id);
			}
			psForDelete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	public void updateItem(T item) throws DaoException {
		try {
			populatePrepareStatementForUpdateItem(psForUpdate, item);
			psForUpdate.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}

	public void close() throws DaoException {
		if (stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				throw new DaoException();
			}

		}

		if (psForInsert != null) {

			try {
				psForInsert.close();
			} catch (SQLException e) {
				throw new DaoException();
			}

		}
		if (psForUpdate != null) {
			try {
				psForUpdate.close();
			} catch (SQLException e) {
				throw new DaoException();
			}
		}
		if (psForDelete != null) {
			try {
				psForDelete.close();
			} catch (SQLException e) {
				throw new DaoException();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DaoException();
			}
		}
	}
}
