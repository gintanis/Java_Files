

 public class Begin {
    public static void main(String[] args) {
       
        
        Mars mars = new Mars();
        mars.totalFunds = 100.00; 
        Neptune neptune = new Neptune();
        neptune.totalFunds = 100.00; 
        Saturn saturn = new Saturn();
   
        
        mars.exchange(saturn, 25.0);
        neptune.exchange(saturn, 10.0);
        saturn.exchange(mars, 122.0);
        saturn.exchange(mars, 121.0);
     }

}