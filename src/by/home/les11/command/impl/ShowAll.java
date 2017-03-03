package by.home.les11.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.exception.CommandException;
import by.home.les11.domain.Mark;
import by.home.les11.service.MarkService;
import by.home.les11.service.ServiceFactory;
import by.home.les11.service.exception.ServiceException;

public class ShowAll extends BaseCommand{

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		List<Mark> marks;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markDao = serviceFactory.getMarkService();
		
		try {
			marks = markDao.getAllStudentsMarks();
		} catch (ServiceException e) {
			throw new CommandException();
		}
		
		request.setAttribute("marks", marks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}
	}

}
