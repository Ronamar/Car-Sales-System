package commands;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import main.Database;

public class ExitCommand implements Command{

	@Override
	public int start(Scanner sc) {
		try {
			
			Database.save();
			
		} catch (JAXBException e) {
			
			e.printStackTrace();
			
		}
		System.exit(0);;
		return 0;
		
	}

	
	public String getName() {
		return "Exit";
	}


	
	
}
