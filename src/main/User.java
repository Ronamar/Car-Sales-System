package main;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.PROPERTY)

public class User extends Entity {

	
	private String password;
	private boolean admin;
	@XmlElement
	private List<String> ads = new ArrayList<>();

	public User() {

	}

	public User(String ID, String password) {
		this.ID = ID;

		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String toString() {
		return "User [username=" + ID + ", password=" + password + ", admin=" + admin + "]";
	}
	
	public void insertAdID(String ID) {
		ads.add(ID);
	}
	
	public List<String> getAds() {
		return ads;
	}

}
