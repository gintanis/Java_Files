
 public class Mars extends Currency implements Exchangeable {

    String currencyName; 
    double totalFunds; 

    public Mars ()
    {
        this.currencyName = "Mars Money"; 
        this.totalFunds = 0; 

    }


    public void exchange(Exchangeable other, double amount) {
        while (totalFunds > 0  && amount <= totalFunds)
        {
           // convert into earth dollars
            double earth = this.toEarthDollars(amount); 
            double total = this.fromEarthDollars(earth);
            other.updatedTotal(total); 
            total -= amount; 
        }   
    }
    public void updatedTotal(double amount) {this.totalFunds += amount;  }
    public double toEarthDollars(double amount) { return amount / Exchangeable.MM; }
    public double fromEarthDollars(double EarthDollars) { return EarthDollars * Exchangeable.MM;   }


    
  

    
}