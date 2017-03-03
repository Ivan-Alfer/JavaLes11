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

public class UpdateStudent extends BaseCommand{

	private static final String ID = "id";
	private static final String FIRST_NAME = "first name";
	private static final String LAST_NAME = "last name";
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		Student student = new Student();
		String sId = request.getParameter(ID);
		student.setId(Integer.valueOf(sId));
		student.setFirstName(request.getParameter(FIRST_NAME));
		student.setLastName(request.getParameter(LAST_NAME));
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BaseService<Student> studentService = serviceFactory.getStudentService();

		try {
			studentService.updateItem(student);
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
