package by.home.les11.service.impl;

import java.util.List;

import by.home.les11.dao.BaseDao;
import by.home.les11.dao.DaoFactory;
import by.home.les11.dao.exception.DaoException;
import by.home.les11.service.BaseService;
import by.home.les11.service.exception.ServiceException;


public abstract class BaseServiceImpl<T> implements BaseService<T>{

	protected DaoFactory daoFactory = DaoFactory.getInstance();
	
	protected abstract BaseDao<T> getDao() throws DaoException;
	
	public List<T> getItems() throws ServiceException {
		List<T> items;
		try {
			BaseDao<T> itemDao = getDao();
			items = itemDao.getItems();
		} catch (DaoException e) {
			throw new ServiceException();
		}
		return items;
	}
	
	public void addItem(T item) throws ServiceException{
		try {
			BaseDao<T> itemDao = getDao();
			itemDao.addItem(item);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}
	
	public void updateItem(T item) throws ServiceException{
		try {
			BaseDao<T> itemDao = getDao();
			itemDao.updateItem(item);
			} catch (DaoException e) {
				throw new ServiceException();
			}
	}
	
	public void deleteItem (int id) throws ServiceException{
		try {
			BaseDao<T> itemDao = getDao();
			itemDao.deleteItem(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

}
