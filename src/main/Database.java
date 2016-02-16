package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import main.AdminRepository;

public class Database {

	private static File UserFile;
	private static File AdminFile;
	private static File AdFile;
	private static UserRepository users;
	private static AdminRepository admins;
	private static AdRepository advs;

	public static String LoggedUser = "";

	public static UserRepository getUsers() {
		return users;
	}

	public static AdminRepository getAdmins() {
		return admins;
	}

	public static AdRepository getAdvs() {
		return advs;
	}

	public static void initialise() {
		UserFile = new File("UserFile.xml");
		AdminFile = new File("AdminFile.xml");
		AdFile = new File("AdFile.xml");
		users = new UserRepository();
		admins = new AdminRepository();
		advs = new AdRepository();
	}

	public static void load() throws JAXBException {

		JAXBContext Ucontext = JAXBContext.newInstance(UserRepository.class);
		JAXBContext Acontext = JAXBContext.newInstance(AdminRepository.class);
		JAXBContext Adcontext = JAXBContext.newInstance(AdRepository.class);

		Unmarshaller Uum = Ucontext.createUnmarshaller();
		Unmarshaller Aum = Acontext.createUnmarshaller();
		Unmarshaller Adum = Adcontext.createUnmarshaller();

		users = (UserRepository) Uum.unmarshal(UserFile);
		admins = (AdminRepository) Aum.unmarshal(AdminFile);
		advs = (AdRepository) Adum.unmarshal(AdFile);

	}

	public static void save() throws JAXBException {
		saveUsers();
		saveAds();
		saveAdmins();
	}

	public static void saveUsers() throws JAXBException {

		JAXBContext Ucontext = JAXBContext.newInstance(UserRepository.class);
		Marshaller Um = Ucontext.createMarshaller();
		Um.marshal(users, UserFile);
	}

	public static void saveAds() throws JAXBException {

		JAXBContext Adcontext = JAXBContext.newInstance(AdRepository.class);
		Marshaller Adm = Adcontext.createMarshaller();
		Adm.marshal(advs, AdFile);
	}

	public static void saveAdmins() throws JAXBException {

		JAXBContext Acontext  = JAXBContext.newInstance(AdminRepository.class);
		Marshaller Am = Acontext.createMarshaller();
		Am.marshal(admins, AdminFile);

	}

}
