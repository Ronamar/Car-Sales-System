package commands;

import java.util.Scanner;

import main.Admin;
import main.Database;
import main.Encryptor;
import main.User;

public class ChangePasswordCommand implements Command {

	@Override
	public int start(Scanner sc) {

		System.out.println("Enter old password:\n");

		String Password = Encryptor.Encrypt(sc.next());

		if (Database.getUsers().getEntities().containsKey(Database.LoggedUser)) {
			User CurUser = Database.getUsers().getByID(Database.LoggedUser);

			if (CurUser.getPassword().equals(Password)) {
				System.out.println("Enter new password:\n");

				Password = Encryptor.Encrypt(sc.next());
				CurUser.setPassword(Password);
				Database.getUsers().insert(CurUser);
				System.out.println("Password changed successfully.\n");
			} else {
				System.out.println("Wrong password!\n");
			}
		} else {
			Admin CurUser = Database.getAdmins().getByID(Database.LoggedUser);

			if (CurUser.getPassword().equals(Password)) {
				System.out.println("Enter new password:\n");
				Password = Encryptor.Encrypt(sc.next());
				CurUser.setPassword(Password);
				Database.getAdmins().insert(CurUser);
				System.out.println("Password changed successfully.\n");
			} else {
				System.out.println("Wrong password!\n");
			}
		}

		return 0;
	}

	@Override
	public String getName() {
		return "Change password";
	}

}
