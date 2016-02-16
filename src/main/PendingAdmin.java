package main;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class PendingAdmin extends Entity {

	private String password;

	public PendingAdmin(){
		
	}
	
	
	public PendingAdmin(String ID,String password) {
		this.ID = ID;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Username of requester: \t" + ID;
	}
	
	
	
}
