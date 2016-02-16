package commands;

import java.util.Map;
import java.util.Scanner;

import main.Ad;
import main.Database;

public class FilterByBrandCommand implements Command {

	@Override
	public int start(Scanner sc) {
		
		String brand = sc.next();

		Map<String, Ad> Entities = Database.getAdvs().getEntities();

		for (String CurAd : Entities.keySet()) {
			if (Entities.get(CurAd).getBrand().equals(brand))
				System.out.println(Entities.get(CurAd).toString() + "\n\n");
		}

		
		return 0;
	}

	@Override
	public String getName() {
		return "Search by brand";
	}

	

}
