package by.home.les11.dbdao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import by.home.les11.dao.MarkDao;
import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Mark;

public class DBMarkDao extends DBBaseDao<Mark> implements MarkDao {

	public DBMarkDao() throws DaoException {
		super();
	}

	private PreparedStatement ps;

	@Override
	protected String getAllSelectQuery() {
		return "SELECT mark.mark, student.id, student.first_name, student.last_name, subject.id, subject.subject_name FROM mark inner join student on student.id = mark.student_id inner join subject on subject.id = mark.subject_id";
	}

	@Override
	protected Mark parseSelectResultSet(ResultSet rs) throws DaoException {
		Mark mark = new Mark();
		try {
			mark.setMark(rs.getInt("MARK"));
			mark.setStudentId(rs.getInt("ID"));
			mark.setStudentFirstName(rs.getString("FIRST_NAME"));
			mark.setStudentLastName(rs.getString("LAST_NAME"));
			mark.setSubjectId(rs.getInt("ID"));
			mark.setSubjectName(rs.getString("SUBJECT_NAME"));
		} catch (SQLException e) {
			throw new DaoException();
		}
		return mark;
	}

	@Override
	protected String getInserQuery() {
		return "insert into mark (mark, student_id, subject_id) values (?,?,?);";
	}

	@Override
	protected void populatePrepareStatementForInsertItem(Mark item, PreparedStatement ps) throws DaoException {
		try {
			ps.setInt(1, item.getMark());
			ps.setInt(2, item.getStudentId());
			ps.setInt(3, item.getSubjectId());
		} catch (SQLException e) {
			throw new DaoException();
		}

	}

	@Override
	protected String getDeleteQuery() {
		return "delete from mark where id=?;";
	}

	@Override
	protected String getUpdateQuery() {
		return "update student set mark=? where id=?";
	}

	@Override
	protected void populatePrepareStatementForUpdateItem(PreparedStatement ps, Mark item) throws DaoException {
		try {
			ps.setInt(1, item.getMark());
			ps.setInt(2, item.getId());
		} catch (SQLException e) {
			throw new DaoException();
		}
	}

	@Override
	public List<Mark> getAllMarkStudent(int studentId) throws DaoException {
		List<Mark> marks = new ArrayList<Mark>();
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(getAllSelectQuery() + " where mark.student_id =?");
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Mark mark = parseSelectResultSet(rs);
				marks.add(mark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return marks;
	}

	@Override
	public List<Mark> getAllStudentOnTheSubject(int subjectId) throws DaoException {
		List<Mark> marks = new ArrayList<Mark>();
		ResultSet rs = null;
		Mark mark = null;
		try {
			ps = con.prepareStatement(getAllSelectQuery() + " where mark.subject_id =?");
			ps.setInt(1, subjectId);
			rs = ps.executeQuery();
			while (rs.next()) {
				mark = parseSelectResultSet(rs);
				marks.add(mark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return marks;
	}

	public void close() throws DaoException {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				throw new DaoException();
			}
		}
		try {
			super.close();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
