package by.home.les11.dao;

import java.util.List;

import by.home.les11.dao.exception.DaoException;

public interface BaseDao<T> extends AutoCloseable {
	public List<T> getItems() throws DaoException;
	
	public void addItem(T item) throws DaoException;
	
	public void deleteItem(int id) throws DaoException;
	
	public void updateItem(T item) throws DaoException; 

}
