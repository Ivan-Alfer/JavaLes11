package by.home.les11.command.mark.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.exception.CommandException;
import by.home.les11.command.impl.BaseCommand;
import by.home.les11.domain.Student;
import by.home.les11.service.BaseService;
import by.home.les11.service.ServiceFactory;
import by.home.les11.service.exception.ServiceException;

public class GoToAddMark extends BaseCommand{
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		
		List<Student> students;
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BaseService<Student> studentService = serviceFactory.getStudentService();
		try {
			students = studentService.getItems();
		} catch (ServiceException e) {
			throw new CommandException();
		}
		request.setAttribute("students", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/add_mark.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}
		
	}

}
