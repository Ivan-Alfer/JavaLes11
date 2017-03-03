package by.home.les11.command.student.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.exception.CommandException;
import by.home.les11.command.impl.BaseCommand;
import by.home.les11.domain.Mark;
import by.home.les11.service.MarkService;
import by.home.les11.service.ServiceFactory;
import by.home.les11.service.exception.ServiceException;

public class ShowAllAboutStudent extends BaseCommand {

	private static final String ID = "id";
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		//String id = null;????
		String sId = request.getParameter(ID);
		Integer studentId = Integer.valueOf(sId);

		List<Mark> marks;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();

		try {
			marks = markService.getAllAboutStudent(studentId);
		} catch (ServiceException e) {
			throw new CommandException();
		}
		
		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_about_student.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}

	}

}
