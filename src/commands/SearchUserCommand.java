package commands;

import java.util.Scanner;

import main.Database;

public class SearchUserCommand implements Command {

	@Override
	public int start(Scanner sc) {

		System.out.println("Enter username:");
		String username = sc.next();

		if (Database.getUsers().getEntities().containsKey(username)) {
			System.out.println(Database.getUsers().getByID(username).toString());
		} else {
			System.out.println("No such user!\n");
		}

		return 0;
	}

	@Override
	public String getName() {

		return "Search for a User";
	}

}
