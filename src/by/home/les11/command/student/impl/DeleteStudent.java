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

public class DeleteStudent extends BaseCommand{

	private static final String ID = "id";
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String sId = request.getParameter(ID);
		Integer id = Integer.valueOf(sId);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BaseService<Student> studentService = serviceFactory.getStudentService();
		
		try {
			studentService.deleteItem(id);
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
