package pica;

public class Pica {
    // attributes
    static double topping;
	static double size;
    static String telNr;
    static boolean deliver;

    // constructor
    public Pica(double topping, double size, String telNr, boolean deliver) {
        this.topping = topping;
        this.size = size;
        this.telNr = telNr;
        this.deliver = deliver;
    }

    // Getters
    public static String getTelNr() {
        return telNr;
    }

    public static double getTopping() {
        return topping;
    }

    public static double getSize() {
        return size;
    }

    public static boolean getDeliver() {
        return deliver;
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
        return "Tel. "+getTelNr();
    }
}