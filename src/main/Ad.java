package main;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Ad extends Entity {

	
	protected String brand;
	protected String model;
	protected boolean manual;
	protected String engine;
	protected String creator;
	protected int volume;
	protected int hPower;
	protected int year;
	protected double price;
	
	public Ad(){
		
		
	}

	public Ad(String ID,String brand, String model, boolean manual, String engine, String creator,
			int volume, int hPower, int year, double price) {

		this.ID = ID;
		this.brand = brand;
		this.model = model;
		this.manual = manual;
		this.engine = engine;
		this.creator = creator;
		this.volume = volume;
		this.hPower = hPower;
		this.year = year;
		this.price = price;
	}

	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		if(brand!="")
			this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if(model!="")
			this.model = model;
	}

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		if(engine!="")
			this.engine = engine;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		if(creator!="")
			this.creator = creator;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int gethPower() {
		return hPower;
	}

	public void sethPower(int hPower) {
		this.hPower = hPower;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ID=" + ID + 
				"\n\t  brand=" + brand + 
				"\n\t, model=" + model + 
				"\n\t, manual=" + manual + 
				"\n\t, engine=" + engine + 
				"\n\t, volume=" + volume + 
				"\n\t, hPower=" + hPower + 
				"\n\t, year=" + year + 
				"\n\t, price=" + price+ 
				"\n\t, Posted by=" + creator;
	}
	
}
