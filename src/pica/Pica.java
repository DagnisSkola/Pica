package pica;

public class Pica {
	//attributes
	double toppings, size;
	String telNr;
	boolean deliver, received;
	
	//constructor
	public Pica(double toppings, double size, String telNr, boolean deliver, boolean received){
		this.toppings=toppings;
		this.size=size;
		this.telNr=telNr;
		this.deliver=deliver;
		this.received=received;
	}
	
	//Getter
	public String getTelNr() {
		return telNr;
	}
	
	public double getToppings() {
		return toppings;
	}
	
	public double getSize() {
		return size;
	}
	
	public boolean getDeliver(){
		return deliver;
	}
	
	public boolean getReceived() {
		return received;
	}
	
	//Setter
	public void setTelNr() {
		this.telNr = telNr;
	}
	
	public void setToppings() {
		this.toppings = toppings;
	}
	
	public void setSize() {
		this.size = size;
	}
	
	public void setDeliver() {
		this.deliver = deliver;
	}
	
	public void setReceived() {
		this.received = received;
	}
}
