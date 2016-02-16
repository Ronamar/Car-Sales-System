package commands;

import java.util.Scanner;

import main.Ad;
import main.Database;

public class CreateAdCommand implements Command {

	@Override
	public int start(Scanner sc) {
		
		Ad newAd = new Ad();

		newAd.setCreator(Database.LoggedUser);
		newAd.setID(String.valueOf(Database.getAdvs().getEntities().size() + 1));

		System.out.println("Enter brand:");
		newAd.setBrand(sc.next());
		System.out.println("Enter model:");
		newAd.setModel(sc.next());
		System.out.println("Enter transmission : 1-\"Manual\", 2-\"Automatic\":");
		newAd.setManual((sc.nextInt() == 1 ? true : false));
		System.out.println("Enter engine:");
		newAd.setEngine(sc.next());
		System.out.println("Enter volume:");
		newAd.setVolume(sc.nextInt());
		System.out.println("Enter hPower:");
		newAd.sethPower(sc.nextInt());
		System.out.println("Enter year:");
		newAd.setYear(sc.nextInt());
		System.out.println("Enter price:");
		newAd.setPrice(sc.nextDouble());

		Database.getAdvs().insert(newAd);

		Database.getUsers().getByID(Database.LoggedUser).insertAdID(newAd.getID());

		System.out.println("Advertisement successfully created!\n");

		
		return 0;
	}

	@Override
	public String getName() {
		return "Create ad";
	}

	
}
