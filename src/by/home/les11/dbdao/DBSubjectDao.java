package by.home.les11.dbdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Subject;

public class DBSubjectDao extends DBBaseDao<Subject> {

	public DBSubjectDao() throws DaoException {
	}

	@Override
	protected String getAllSelectQuery() {
		return "select id, subject_name from subject;";
	}

	@Override
	protected Subject parseSelectResultSet(ResultSet rs) throws DaoException {
		Subject subject = new Subject();
		try {
			int sqlId = rs.getInt("Id");
			String sqlSubjectName = rs.getString("SUBJECT_NAME");

			subject.setId(sqlId);
			subject.setSubjectName(sqlSubjectName);
		} catch (SQLException e) {
			throw new DaoException();
		}
		

		return subject;
	}

	@Override
	protected String getInserQuery() {
		return "insert into subject (subject_name) values (?);";
	}


	@Override
	protected void populatePrepareStatementForInsertItem(Subject item, PreparedStatement ps) throws DaoException  {
		try {
			ps.setString(1, item.getSubjectName());
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	@Override
	protected String getDeleteQuery() {
		return "delete from subject where id=?";
	}

	@Override
	protected String getUpdateQuery() {
		return "update subject set subject_name =? where id=?";
	}

	@Override
	protected void populatePrepareStatementForUpdateItem(PreparedStatement ps, Subject item) throws DaoException {
		try {
			ps.setString(1, item.getSubjectName());
			ps.setInt(2, item.getId());
		} catch (SQLException e) {
			throw new DaoException();
		}
	}
}
