package commands;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import main.Database;
import main.Encryptor;
import main.PendingAdmin;
import main.User;
import main.Admin;

public class RegisterCommand implements Command {

	@Override
	public int start(Scanner sc) {

		System.out.println("1.Register as User");
		System.out.println("2.Register as Admin\n");
		String choice = sc.next();

		if (choice.equals("1")) {

			System.out.println("Enter username:");
			String Username = sc.next();
			if (Database.getUsers().getByID(Username) != null) {
				System.out.println("There already exists a user with such username!\n");

				return 0;
			} else {
				System.out.println("Enter password:");

				String Password = Encryptor.Encrypt(sc.next());

				User user = new User(Username, Password);

				Database.getUsers().insert(user);
				try {
					Database.saveUsers();
				} catch (JAXBException e) {
					e.printStackTrace();
				}
				System.out.println("Registration successfull!\n");
			}
		} else if (choice.equals("2")) {

			System.out.println("Enter username:");
			String username = sc.next();
			if (Database.getAdmins().getByID(username) != null) {
				System.out.println("There already exists an admin with such username!\n");

				return 0;
			} else {
				System.out.println("Enter password:");
				String password = Encryptor.Encrypt(sc.next());

				
				PendingAdmin admin = new PendingAdmin(username, password);

				Admin.insertRequest(admin);
				System.out.println("Your request has been submited!\n");
			}

		} else {
			System.out.println("Invalid choice\n");
		}

		return 0;
	}

	@Override
	public String getName() {
		return "Register";
	}

}
