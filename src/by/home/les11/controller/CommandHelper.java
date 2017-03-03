package by.home.les11.controller;

import java.util.HashMap;
import java.util.Map;

import by.home.les11.command.Command;
import by.home.les11.command.impl.GoToMainPage;
import by.home.les11.command.impl.ShowAll;
import by.home.les11.command.mark.impl.AddMark;
import by.home.les11.command.mark.impl.GoToAddMark;
import by.home.les11.command.student.impl.AddNewStudent;
import by.home.les11.command.student.impl.DeleteStudent;
import by.home.les11.command.student.impl.GoToUpdateStudent;
import by.home.les11.command.student.impl.ShowAllAboutStudent;
import by.home.les11.command.student.impl.ShowAllStudents;
import by.home.les11.command.student.impl.UpdateStudent;
import by.home.les11.command.subject.impl.AddNewSubject;
import by.home.les11.command.subject.impl.AllStudentOnTheSubject;
import by.home.les11.command.subject.impl.DeleteSubject;
import by.home.les11.command.subject.impl.GoToUpdateSubject;
import by.home.les11.command.subject.impl.ShowAllSubjects;
import by.home.les11.command.subject.impl.UpdateSubject;

public class CommandHelper {

	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandHelper() {
		commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
		commands.put(CommandName.SHOW_ALL_STUDENTS, new ShowAllStudents());
		commands.put(CommandName.SHOW_ALL_SUBJECTS, new ShowAllSubjects());
		commands.put(CommandName.SHOW_ALL, new ShowAll());
		commands.put(CommandName.SHOW_ALL_ABOUT_STUDENT, new ShowAllAboutStudent());
		commands.put(CommandName.ADD_NEW_STUDENT, new AddNewStudent());
		commands.put(CommandName.ADD_NEW_SUBJECT, new AddNewSubject());
		commands.put(CommandName.GO_TO_UPDATE_STUDENT, new GoToUpdateStudent());
		commands.put(CommandName.UPDATE_STUDENT, new UpdateStudent());
		commands.put(CommandName.DELETE_STUDENT, new DeleteStudent());
		commands.put(CommandName.GO_TO_UPDATE_SUBJECT, new GoToUpdateSubject());
		commands.put(CommandName.UPDATE_SUBJECT, new UpdateSubject());
		commands.put(CommandName.DELETE_SUBJECT, new DeleteSubject());
		commands.put(CommandName.ALL_STUDENT_ON_THE_SUBJECT, new AllStudentOnTheSubject());
		commands.put(CommandName.GO_TO_ADD_MARK, new GoToAddMark());
		commands.put(CommandName.ADD_MARK, new AddMark());

	}

	protected Command getCommand(String name) {
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;
	}
}
