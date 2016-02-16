package commands;

import java.util.Scanner;

import main.Database;

public class RemoveAdCommand implements Command {

	@Override
	public int start(Scanner sc) {

		System.out.println("Enter ad ID:");
		String ID = sc.next();

		if (Database.getAdvs().getEntities().containsKey(ID)) {

			if (Database.getAdvs().getByID(ID).getCreator().equals(Database.LoggedUser)
					|| Database.getAdmins().getEntities().containsKey(Database.LoggedUser)) {
				
				Database.getAdvs().delete(ID);
				System.out.println("Advertisement successfully removed!\n");
			}else{
				System.out.println("You do not have permission to remove this advertisment!\n");
			}
		} else {
			System.out.println("An advertisement with such ID does not exist!\n");
		}

		return 0;
	}

	@Override
	public String getName() {
		return "Remove ad";
	}

}
