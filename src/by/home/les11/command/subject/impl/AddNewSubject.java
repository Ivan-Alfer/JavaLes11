package by.home.les11.command.subject.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.exception.CommandException;
import by.home.les11.command.impl.BaseCommand;
import by.home.les11.domain.Subject;
import by.home.les11.service.BaseService;
import by.home.les11.service.ServiceFactory;
import by.home.les11.service.exception.ServiceException;

public class AddNewSubject extends BaseCommand{

	private static final String SUBJECT_NAME = "subject";
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String subjectName = request.getParameter(SUBJECT_NAME);
		Subject subject = new Subject(subjectName);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BaseService<Subject> subjectService = serviceFactory.getSubjectService();
		
		try {
			subjectService.addItem(subject);
		} catch (ServiceException e) {
			throw new CommandException();
		}
		
		try {
			response.sendRedirect("/all_subjects");
		} catch (IOException e) {
			throw new CommandException();
		}
	}
}
