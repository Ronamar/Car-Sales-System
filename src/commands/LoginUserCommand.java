package commands;

import java.util.Map;
import java.util.Scanner;

import main.Database;
import main.Encryptor;
import menus.MenuListItem;

public class LoginUserCommand implements Command {

	private final String USER_MENU = "1";
	private final String ADMIN_MENU = "2";
	private Map<String, MenuListItem> actions;

	public LoginUserCommand(Map<String, MenuListItem> actions) {
		this.actions = actions;
	}
	
	public int start(Scanner sc) {
		
			
		String username;
		String password;

		System.out.println("Enter username:");
		username = sc.next();
		System.out.println("\nEnter password:");
		password = Encryptor.Encrypt(sc.next());
		
		if (Database.getUsers().getEntities().containsKey(username)) {
			if (Database
					.getUsers()
					.getEntities()
					.get(username)
					.getPassword().equals(password)) {
				System.out.println("Login Succesful.\n");
				Database.LoggedUser=username;
				actions.get(USER_MENU)
						.start(sc);
			}
			else {
				System.out.println("Wrong username or password.\n");				
			}
		}else if (Database.getAdmins().getEntities().containsKey(username)) {
			if (Database
					.getAdmins()
					.getEntities()
					.get(username)
					.getPassword().equals(password)) {
				System.out.println("Login Succesful.\n");
				Database.LoggedUser=username;
				actions.get(ADMIN_MENU).start(sc);
			}
			else {
				System.out.println("Wrong username or password.\n");				
			}
		}
		
		return 0;
	}

	public String getName() {
		
		return "Login";
	}

	

}
