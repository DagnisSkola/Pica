package pica;

public class Pica {
    // attributes
    static double topping, size, totCost;
    static String telNr;
    static boolean deliver;
    static int pasNr;

    // constructor
    public Pica(double topping, double size, String telNr, boolean deliver, int pasNr, double totCost) {
        this.topping = topping;
        this.size = size;
        this.telNr = telNr;
        this.deliver = deliver;
        this.pasNr = pasNr;
        this.totCost = totCost;
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
    
    public static int getPasNr() {
    	return pasNr;
    }
    
    public static double getTotCost() {
    	return totCost;
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
        return "Order "+pasNr+". Total. "+String.format("%.2f",(getTotCost()))+"€ Tel. "+getTelNr();
    }
}