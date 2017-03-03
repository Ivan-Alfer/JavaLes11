package by.home.les11.service;

import java.util.List;

import by.home.les11.service.exception.ServiceException;

public interface BaseService<T> {

	public List<T> getItems() throws ServiceException;
	
	public void addItem(T item) throws ServiceException;
	
	public void updateItem(T item) throws ServiceException;
	
	public void deleteItem(int id) throws ServiceException;
}
