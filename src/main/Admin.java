package main;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import main.Entity;

@XmlAccessorType(XmlAccessType.FIELD)
public class Admin extends Entity {

	private String password;
	private boolean admin;
	@XmlElement
	private static List<PendingAdmin> pendingRequests = new LinkedList<PendingAdmin>();
	
	public Admin() {

	}
	
	public Admin(String username,String password){
		
		this.ID = username;
		this.password = password;
		admin = true;
		
	}
	
	public static void insertRequest(PendingAdmin admin){
		
		pendingRequests.add(admin);
		
	}
	
	public static List<PendingAdmin> getPendingRequests() {
		return pendingRequests;
	}

	public static void setPendingRequests(List<PendingAdmin> pendingRequests) {
		Admin.pendingRequests = pendingRequests;
	}

	public Admin(String ID, String password, boolean admin) {
		this.ID = ID;

		this.password = password;
		this.admin = admin;
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
		return "Admin [username=" + ID + ", password=" + password + ", admin=" + admin + "]";
	}

}
