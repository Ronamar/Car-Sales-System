package commands;

import java.util.Scanner;

import main.Database;

public class DeleteAccountCommand implements Command {

	@Override
	public int start(Scanner sc) {
		
		if(Database.getUsers().getEntities().containsKey(Database.LoggedUser)){
		Database.getUsers().delete(Database.LoggedUser);
		}else{
			Database.getAdmins().delete(Database.LoggedUser);
		}
		Database.LoggedUser="";
		
		return 1;
	}

	@Override
	public String getName() {
		return "Delete your account";
	}

	

}
