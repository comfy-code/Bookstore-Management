
public class Customer{
    //customer instance variables 
    private String name;
    private boolean memStatus;
    private double totalSpent;

    // Customer constructor 
    public Customer(String n, boolean ms, double ts){
        this.name = n;
        this.memStatus = ms;
        this.totalSpent = ts; 
    }

    //get name of customer
    public String getName(){
        return this.name;
    }

    // set name of customer
    public void setName(String n){
        this.name = n;
    }

    // get membership status of customer
    public boolean getStatus(){
        return this.memStatus;
    }

    // set the  membership status of the customer
    public void setStatus(boolean ms){
        this.memStatus = ms;
    }

    // get the total spent by the customer 
    public double totalSpent(){
        return this.totalSpent;
    }

    // set the total spent by the customer 
    public void setTotalSpent(double ts){
        this.totalSpent = ts; 
    }
}