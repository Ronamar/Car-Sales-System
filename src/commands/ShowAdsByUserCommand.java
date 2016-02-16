package commands;

import java.util.Map;
import java.util.Scanner;

import main.Ad;
import main.Database;

public class ShowAdsByUserCommand implements Command {

	@Override
	public int start(Scanner sc) {
		
		Map<String, Ad> Entities = Database.getAdvs().getEntities();

		for(String adID : Database.getUsers().getByID(Database.LoggedUser).getAds()) {
			System.out.println(Entities.get(adID).toString() + "\n\n");			
		}
		
		return 0;
	}

	@Override
	public String getName() {
		return "Show my ads";
	}

	

}
