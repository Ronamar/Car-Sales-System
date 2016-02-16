package menus;

import java.util.Map;
import java.util.Scanner;

import commands.BackCommand;

public class Menu implements MenuListItem {

	private Map<String, MenuListItem> choices;
	private String name;
	private Scanner sc;
	public Menu(String name, Map<String, MenuListItem> choices) {
		this.name = name;
		this.choices = choices;
	}
	
	public int start(){
		return 0;
	}

	private boolean execute(String choice) {
		
		if (choices.containsKey(choice)) {
			if (choices.get(choice).getClass() == BackCommand.class)
				return false;
	
			if (choices.get(choice).start(sc) == 1)
				return false;
		} else {
			System.out.println("Invalid choice!");
		}
		
		return true;
	}

	private void showChoices() {

		System.out.println(name + ":");
		for (int i = 1; i <= choices.size(); i++) {

			System.out.println(i + " - " + choices.get(String.valueOf(i)).getName());
		}
		System.out.println("");
		
	}

	public int start(Scanner sc) {
		this.sc = sc;
		String choice;
		do {
			showChoices();
			
			choice = sc.next();
			System.out.println("");
			
		} while (execute(choice));

		

		return 0;
	}

	public String getName() {

		return name;
	}

}
