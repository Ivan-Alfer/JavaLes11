package by.home.les11.command.student.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.exception.CommandException;
import by.home.les11.command.impl.BaseCommand;
import by.home.les11.domain.Student;
import by.home.les11.service.BaseService;
import by.home.les11.service.ServiceFactory;
import by.home.les11.service.exception.ServiceException;

public class AddNewStudent extends BaseCommand{

	private static final String FIRST_NAME = "first name";
	private static final String LAST_NAME = "last name";
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		Student student = new Student(firstName, lastName);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BaseService<Student> studentService = serviceFactory.getStudentService();
		
		try {
			studentService.addItem(student);
		} catch (ServiceException e) {
			throw new CommandException();
		}
		
		try {
			response.sendRedirect("/all_students");
		} catch (IOException e) {
			throw new CommandException();
		}
	}
}
