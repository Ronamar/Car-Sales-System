package commands;

import java.util.Map;
import java.util.Scanner;

import main.Ad;
import main.Database;

public class FilterByPriceCommand implements Command {

	@Override
	public int start(Scanner sc) {
		
		double price = sc.nextDouble();

		Map<String, Ad> Entities = Database.getAdvs().getEntities();

		for (String CurAd : Entities.keySet()) {
			if (Entities.get(CurAd).getPrice()==price)
				System.out.println(Entities.get(CurAd).toString() + "\n\n");
		}

		
		return 0;
	}

	@Override
	public String getName() {
		return "Search by price";
	}



}
