package commands;

import java.util.Scanner;

import main.Ad;
import main.Database;

public class UpdateAdCommand implements Command {

	@Override
	public int start(Scanner sc) {
		
		System.out.println("Enter ad ID:");
		String ID=sc.next();
		String Input;
		
		if(Database.getAdvs().getEntities().containsKey(ID)) {
			System.out.println("Current specifiactions:");
			Ad CurAd=Database.getAdvs().getByID(ID);
			System.out.println(CurAd.toString()+"\n");
			System.out.println("Enter new value or press Enter to keep current value.\n");

			System.out.println("Enter brand:");
			CurAd.setBrand(sc.nextLine());
			System.out.println("Enter model:");
			CurAd.setModel(sc.nextLine());
			System.out.println("Enter transmission : 1-\"Manual\", 2-\"Automatic\":");
			Input=sc.nextLine();
			if(Input!="")
				CurAd.setManual((Integer.valueOf(Input) == 1 ? true : false));
			System.out.println("Enter engine:");
			CurAd.setEngine(sc.nextLine());
			System.out.println("Enter volume:");
			Input=sc.nextLine();
			if(Input!="")
				CurAd.setVolume(Integer.valueOf(Input));
			System.out.println("Enter hPower:");
			Input=sc.nextLine();
			if(Input!="")
				CurAd.sethPower(Integer.valueOf(Input));
			System.out.println("Enter year:");
			Input=sc.nextLine();
			if(Input!="")
				CurAd.setYear(Integer.valueOf(Input));
			System.out.println("Enter price:");
			Input=sc.nextLine();
			if(Input!="")
				CurAd.setPrice(Double.valueOf(Input));
			
			Database.getAdvs().insert(CurAd);
			
			System.out.println("\nAdvertisement successfully updated!\n");			
		}
		else {
			System.out.println("An advertisement with such ID does not exist!\n");
		}
		
		
		return 0;
	}

	@Override
	public String getName() {
		return "Update ad";
	}

	
}
