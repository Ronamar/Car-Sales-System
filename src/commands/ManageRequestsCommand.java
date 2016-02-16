package commands;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import main.Admin;
import main.Database;
import main.PendingAdmin;

public class ManageRequestsCommand implements Command {

	@Override
	public int start(Scanner sc) {

		Database.getAdmins().getByID(Database.LoggedUser);
		List<PendingAdmin> currentPendingRequests = Admin.getPendingRequests();
		List<PendingAdmin> newPendingRequests = new LinkedList<>();

		int choice;

		for (int i = 0; i < currentPendingRequests.size(); i++) {

			System.out.println(currentPendingRequests.get(i).toString());
			System.out.println("\n 1 - Approve request \n 2 - Delete request \n 3 - Skip\n");

			choice = sc.nextInt();

			switch (choice) {

				case 1: 
					Admin admin = new Admin(currentPendingRequests.get(i).getID(),currentPendingRequests.get(i).getPassword());
					Database.getAdmins().insert(admin);
					break;
	
				case 2: 
					//Empty case
						break;
				
	
				case 3: 
					newPendingRequests.add(currentPendingRequests.get(i));
					break;
	
				default: 
					System.out.println("Invalid choice!\n");
					break;
				
			}

		}

		Admin.setPendingRequests(newPendingRequests);

		return 0;
	}

	@Override
	public String getName() {

		return "Manage pending admin requests";
	}

}
