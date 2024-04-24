package pica;

public class Pica {
	//attributes
	double topping, size;
	String telNr;
	boolean deliver;
	
	//constructor
	public Pica(double topping, double size, String telNr, boolean deliver){
		this.topping=topping;
		this.size=size;
		this.telNr=telNr;
		this.deliver=deliver;
	}
	
	//Getter
	public String getTelNr() {
		return telNr;
	}
	
	public double getToppings() {
		return topping;
	}
	
	public double getSize() {
		return size;
	}
	
	public boolean getDeliver(){
		return deliver;
	}
	
	
	//Setter
	public void setTelNr() {
		this.telNr = telNr;
	}
	
	public void setToppings() {
		this.topping = topping;
	}
	
	public void setSize() {
		this.size = size;
	}
	
	public void setDeliver() {
		this.deliver = deliver;
	}
	
}
