package commands;

import java.util.Map;
import java.util.Scanner;

import main.Ad;
import main.Database;

public class ShowAllCommand implements Command {

	@Override
	public int start(Scanner sc) {

		Map<String, Ad> Entities = Database.getAdvs().getEntities();

		for (String CurAd : Entities.keySet()) {
			System.out.println(Entities.get(CurAd).toString() + "\n\n");
		}

		return 0;
	}

	@Override
	public String getName() {
		return "Show all ads";
	}

	

}
