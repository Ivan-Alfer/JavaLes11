package by.home.les11.service.impl;

import by.home.les11.dao.BaseDao;
import by.home.les11.dao.DaoFactory;
import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Student;

public class StudentServiceImpl extends BaseServiceImpl<Student> {

	private DaoFactory daoFactory = DaoFactory.getInstance();
	
	@Override
	protected BaseDao<Student> getDao() throws DaoException {
		return daoFactory.getStudentDao();
	}

}
