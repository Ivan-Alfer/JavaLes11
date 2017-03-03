package by.home.les11.dao;

import java.util.List;

import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Mark;

public interface MarkDao extends BaseDao<Mark>{
	
	public List<Mark> getAllMarkStudent(int studentId) throws DaoException;

	List<Mark> getAllStudentOnTheSubject(int subjectId) throws DaoException;
	
}
