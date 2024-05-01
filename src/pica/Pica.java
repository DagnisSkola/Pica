	package pica;
	
	public class Pica {
	    // attributes
	    static double Ttopping, Tsize, TtotCost;
	    static String TtelNr;
	    static boolean Tdeliver;
	    static int TpasNr;
	    
	    double topping, size, totCost;
		String telNr;
		boolean deliver;
		int pasNr;
	
	    // constructor
		public Pica(double topping, double size, String telNr, boolean deliver, int pasNr, double totCost) {
		    this.topping = topping;
		    this.size = size;
		    this.telNr = telNr;
		    this.deliver = deliver;
		    this.pasNr = pasNr;
		    this.totCost = totCost;
		    
		    Ttopping = topping;
		    Tsize = size;
		    TtelNr = telNr;
		    Tdeliver = deliver;
		    TpasNr = pasNr;
		    TtotCost = totCost;
		}
	
	    // Getters
	    public String getTelNr() {
	        return telNr;
	    }
	
	    public double getTopping() {
	        return topping;
	    }
	
	    public double getSize() {
	        return size;
	    }
	
	    public boolean getDeliver() {
	        return deliver;
	    }
	
	    public int getPasNr() {
	        return pasNr;
	    }
	
	    public double getTTotCost() {
	        return totCost;
	    }
	    
	    public static String getTTelNr() {
	        return TtelNr;
	    }
	
	    public static double getTTopping() {
	        return Ttopping;
	    }
	
	    public static double getTSize() {
	        return Tsize;
	    }
	
	    public static boolean getTDeliver() {
	        return Tdeliver;
	    }
	    
	    public static int getTPasNr() {
	    	return TpasNr;
	    }
	    
	    public static double getTotCost() {
	    	return TtotCost;
	    }
	    
	    // Setters
	    public void setTelNr(String telNr) {
	        this.telNr = telNr;
	    }
	
	    public void setToppings(double topping) {
	        this.topping = topping;
	    }
	
	    public void setSize(double size) {
	        this.size = size;
	    }
	
	    public void setDeliver(boolean deliver) {
	        this.deliver = deliver;
	    }
	    
	    public String displayDetails() {
	    	String del="";
	    	if(getDeliver()==true) {
	    		del="With delivery";
	    	}else {
	    		del="No delivery";
	    	}
	        return "Order "+pasNr+", Total. "+String.format("%.2f",(getTTotCost()))+"€, Tel. "+getTelNr()+", "+del;
	    }
	}