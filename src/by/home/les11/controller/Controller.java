package by.home.les11.controller;


import java.io.UnsupportedEncodingException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.home.les11.command.Command;

public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private final CommandHelper commandHelper = new CommandHelper();
	private static final String COMMAND = "command";
	
	public Controller(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String nameCommand = request.getParameter(COMMAND);
		if(nameCommand == null || nameCommand.length() == 0){
			nameCommand = getInitParameter(COMMAND);
		}
		
		Command command = commandHelper.getCommand(nameCommand);
		command.execute(request, response);
	}
}
