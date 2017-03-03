package by.home.les11.service;

import by.home.les11.domain.Student;
import by.home.les11.domain.Subject;
import by.home.les11.service.impl.MarkServiceImpl;
import by.home.les11.service.impl.StudentServiceImpl;
import by.home.les11.service.impl.SubjectServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory INSTANCE = new ServiceFactory();
	
	private ServiceFactory(){
	}
	
	public static ServiceFactory getInstance(){
		return INSTANCE;
	}

	public MarkService getMarkService(){
		return new MarkServiceImpl();
	}
	
	public BaseService<Student> getStudentService(){
		return new StudentServiceImpl();
	}
	
	public BaseService<Subject> getSubjectService(){
		return new SubjectServiceImpl();
	}
}
