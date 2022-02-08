public interface Exchangeable {
    double MM = 1.30; 
    double SS = .87; 
    double ED = 1.00; 
    double NN = 2.00;

    void exchange(Exchangeable other, double amount);

    double fromEarthDollars(double earthDollar);

    void updatedTotal(double total);
}