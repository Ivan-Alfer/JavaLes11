package by.home.les11.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.home.les11.command.exception.CommandException;

public class GoToMainPage extends BaseCommand{

	@Override
	protected void executeRaw(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		try {
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException();
		}
		
	}

}
