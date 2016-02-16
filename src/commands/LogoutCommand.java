package commands;

import java.util.Scanner;

import main.Database;

public class LogoutCommand implements Command {

	@Override
	public int start(Scanner sc) {
		Database.LoggedUser = "";
		return 1;
	}

	@Override
	public String getName() {
		
		return "Logout";
	}

}
