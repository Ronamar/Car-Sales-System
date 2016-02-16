package main;



public abstract class Entity {

	protected String ID;
	
	public void setID(String ID){
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}
	
	
	public boolean equals(Entity other){
		
		return ID.equals(other.getID());
		
	}
	
	
}
