package by.home.les11.service.impl;

import by.home.les11.dao.BaseDao;
import by.home.les11.dao.exception.DaoException;
import by.home.les11.domain.Subject;

public class SubjectServiceImpl extends BaseServiceImpl<Subject> {

	@Override
	protected BaseDao<Subject> getDao() throws DaoException {
		return daoFactory.getSubjectDao();
	}


}
