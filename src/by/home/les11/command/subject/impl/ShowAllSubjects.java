package by.home.les11.command.subject.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.exception.CommandException;
import by.home.les11.command.impl.BaseCommand;
import by.home.les11.domain.Subject;
import by.home.les11.service.BaseService;
import by.home.les11.service.ServiceFactory;
import by.home.les11.service.exception.ServiceException;

public class ShowAllSubjects extends BaseCommand{

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		List<Subject> subjects;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BaseService<Subject> subjectService = serviceFactory.getSubjectService();
		
		try {
			subjects = subjectService.getItems();
		} catch (ServiceException e) {
			throw new CommandException();
		}
		
		request.setAttribute("subjects", subjects);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/all_subjects.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}
		
	}

}
