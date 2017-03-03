package by.home.les11.command.exception;

public class CommandException extends Exception{

	private static final long serialVersionUID = 1L;

	public CommandException(){
	}
	
	public CommandException(String massage){
		super(massage);
	}
}
