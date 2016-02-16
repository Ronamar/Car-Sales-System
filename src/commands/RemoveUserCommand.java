package commands;

import java.util.Scanner;

import main.Database;

public class RemoveUserCommand implements Command {

	@Override
	public int start(Scanner sc) {
		
		System.out.println("Enter the username of the user to be deleted:");
		String username = sc.next();
		
		if(Database.getUsers().getEntities().containsKey(username)){
			Database.getUsers().delete(username);
		}else{
			System.out.println("No such user!\n");
		}
		
		
		
		return 0;
	}

	@Override
	public String getName() {

		return "Delete a User";
	}

}
