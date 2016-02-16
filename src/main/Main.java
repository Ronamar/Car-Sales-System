package main;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import factory.MenuFactory;

public class Main {

	public static void main(String[] args) {
		System.out.println("Starting...\n");
		Database.initialise();
		System.out.println("Loading Database...\n");
		try {
			Database.load();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		MenuFactory.getMenu("MainMenu").start(sc);
		sc.close();
	}
	
}
