package commands;

import java.util.Scanner;

public class BackCommand implements Command{

	

	
	public String getName() {
		
		return "Back";
	}


	@Override
	public int start(Scanner sc) {
		
		return 0;
	}

}
