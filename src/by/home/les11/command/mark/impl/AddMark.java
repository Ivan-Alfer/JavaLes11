package by.home.les11.command.mark.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.exception.CommandException;
import by.home.les11.command.impl.BaseCommand;
import by.home.les11.domain.Mark;
import by.home.les11.service.MarkService;
import by.home.les11.service.ServiceFactory;
import by.home.les11.service.exception.ServiceException;

public class AddMark extends BaseCommand{

	private static final String STUDENT_ID = "studentId";
	private static final String SUBJECT_ID = "subjectId";
	private static final String MARK = "mark";
	
	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		Mark mark = new Mark();
		String studId=request.getParameter(STUDENT_ID);
		String subId = request.getParameter(SUBJECT_ID);
		String sMark = request.getParameter(MARK);
		
		mark.setSubjectId(Integer.valueOf(subId));
		mark.setStudentId(Integer.valueOf(studId));
		mark.setMark(Integer.valueOf(sMark));
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MarkService markService = serviceFactory.getMarkService();

		try {
			markService.addItem(mark);;
		} catch (ServiceException e) {
			throw new CommandException();
		}
		
		try {
			response.sendRedirect("/all_student_on_the_subject?id="+subId);
		} catch (IOException e) {
			throw new CommandException();
		}
	}
}
