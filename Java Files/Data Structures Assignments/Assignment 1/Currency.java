


public abstract class Currency {
    
    public abstract double toEarthDollars(double amount);
    public abstract double fromEarthDollars(double EarthDollars);
    
    double total;
    String name; 
    // methods for currency name and total funds
    public String currencyName() {return name;}
    public double totalAmount() {return total;} 

}
