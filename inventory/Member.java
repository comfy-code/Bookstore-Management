

import java.util.ArrayList;

public class Member {
    // array list holds list of customers and their information 
    ArrayList<Customer> people = new ArrayList<>();

    // constructor 
    public Member(){
        Customer cst1 = new Customer("Steve", true, 20);
        Customer cst2 = new Customer("Brittany", false, 10);

        people.add(cst1);
        people.add(cst2);
    }

    //display current members method 
    public void getMembers(){
        for(int i = 0; i < people.size(); i++){
            System.out.println("\n" + "\t" + (i + 1) + "." +  people.get(i).getName());
        }
        System.out.println("\n" + "\t" + (people.size() + 1) + "." + " Register as a new member. ");
    }

    //returns a member name based on the recieved parameter 
    public String getMemberName(int x){
        return people.get(x).getName().toLowerCase();
    }

    //returns customers details 
    public Customer getMember(int x){
        return people.get(x);
    }

    //adds new member to the list of customers
    public void addMember(String n, boolean ms, double ts){
        Customer newCustomer = new Customer(n, ms, ts);
        people.add(newCustomer);
    }

    // returns the total number of people in the people array list 
    public int getSize(){
        return people.size();
    }

}
