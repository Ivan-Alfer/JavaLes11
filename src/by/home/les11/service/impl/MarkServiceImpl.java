package by.home.les11.service.impl;

import java.util.List;

import by.home.les11.dao.BaseDao;
import by.home.les11.dao.MarkDao;
import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Mark;
import by.home.les11.service.MarkService;
import by.home.les11.service.exception.ServiceException;


public class MarkServiceImpl extends BaseServiceImpl<Mark> implements MarkService{
	
	@Override
	public List<Mark> getAllStudentsMarks() throws ServiceException {
		return super.getItems();
	}

	@Override
	public List<Mark> getAllAboutStudent(int studentId) throws ServiceException {
		List<Mark> marks;
		try {
			MarkDao markDao = daoFactory.getMarkDao();
			marks = markDao.getAllMarkStudent(studentId);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return marks;
	}

	@Override
	public List<Mark> getAllStudentOnTheSubject(int subjectId) throws ServiceException {
		List<Mark> marks;
		try {
			MarkDao markDao = daoFactory.getMarkDao();
			marks = markDao.getAllStudentOnTheSubject(subjectId);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return marks;
	}

/*	public List<Mark> addMark(Mark mark) throws ServiceException{
		super.addItem(mark);
		return getAllStudentOnTheSubject(mark.getSubjectId());
	}*/

	@Override
	protected BaseDao<Mark> getDao() throws DaoException {
		return daoFactory.getMarkDao();
	}
	
	
}
