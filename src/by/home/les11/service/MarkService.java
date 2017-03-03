package by.home.les11.service;

import java.util.List;

import by.home.les11.domain.Mark;
import by.home.les11.service.exception.ServiceException;

public interface MarkService extends BaseService<Mark>{

	public List<Mark> getAllStudentsMarks() throws ServiceException;
	
	public List<Mark> getAllAboutStudent(int studentId) throws ServiceException;
	
	public List<Mark> getAllStudentOnTheSubject(int subjectId) throws ServiceException;
	
	//public List<Mark> addMark(Mark mark) throws ServiceException;
}
