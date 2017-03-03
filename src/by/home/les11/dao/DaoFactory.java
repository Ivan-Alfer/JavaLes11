package by.home.les11.dao;

import by.home.les11.dao.exception.DaoException;
import by.home.les11.dbdao.DBMarkDao;
import by.home.les11.dbdao.DBStudentDao;
import by.home.les11.dbdao.DBSubjectDao;
import by.home.les11.domain.Student;
import by.home.les11.domain.Subject;

public class DaoFactory {

	private static final DaoFactory INSTANSE = new DaoFactory();


	private DaoFactory(){
		
	}

	public static DaoFactory getInstance() {
		return INSTANSE;
	}
	
	public BaseDao<Student> getStudentDao() throws DaoException {
		return new DBStudentDao();
	}

	public BaseDao<Subject> getSubjectDao() throws DaoException {
		return new DBSubjectDao();
	}

	public MarkDao getMarkDao() throws DaoException {
		return new DBMarkDao();
	}

}
