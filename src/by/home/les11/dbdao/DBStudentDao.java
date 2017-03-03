package by.home.les11.dbdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Student;

public class DBStudentDao extends DBBaseDao<Student> {
	
	
	
	public DBStudentDao() throws DaoException{
	}

	@Override
	protected String getAllSelectQuery() {
		return "select id, first_name, last_name from student;";
	}

	@Override
	protected Student parseSelectResultSet(ResultSet rs) throws DaoException {
		Student student = new Student();
		try {
			int sqlId = rs.getInt("Id");
			String sqlFirstName = rs.getString("FIRST_NAME");
			String sqlLastName = rs.getString("LAST_NAME");

			student.setId(sqlId);
			student.setFirstName(sqlFirstName);
			student.setLastName(sqlLastName);
		} catch (SQLException e) {
			throw new DaoException();
		}
		return student;
	}

	@Override
	protected String getInserQuery() {
		return "insert into student (first_name, last_name) values (?,?);";
	}

	@Override
	protected void populatePrepareStatementForInsertItem(Student student, PreparedStatement ps) throws DaoException {
		try {
			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	@Override
	protected String getDeleteQuery() {
		return "delete from student where id=?";
	}

	@Override
	protected String getUpdateQuery() {
		return "update student set first_name =?, last_name=? where id=?";
	}

	@Override
	protected void populatePrepareStatementForUpdateItem(PreparedStatement ps, Student item) throws DaoException {
		try {
			ps.setString(1, item.getFirstName());
			ps.setString(2, item.getLastName());
			ps.setInt(3, item.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		}
	}
}
