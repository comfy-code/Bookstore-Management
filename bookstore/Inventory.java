
import java.util.ArrayList;

public class Inventory {
    //list holds the items in the store 
    private ArrayList<Product> store = new ArrayList<>();
    
    // inventory constructor 
    public Inventory(){
        Product pd1 = new Product("The Four Agreements", "Don Miguel Ruiz", "book", 10, 2);
        Product pd2 = new Product("The Amazing Power of Deliberate Intent", "Esther & Jerry Hicks","book", 25, 2);
        Product pd3 = new Product("Mycelium Running", "Paul Stamets", "book", 35, 4);
        
        store.add(pd1);
        store.add(pd2);
        store.add(pd3);
        
        Product pd4 = new Product("Astroworld", "Travis Scott", "cd", 12.99, 7);
        Product pd5 = new Product("The Melodic Blue", "Baby Keem", "cd",13.99, 3);
        Product pd6 = new Product("Do it for Demon", "SahBabii", "cd", 11.99, 2);
        
        store.add(pd4);
        store.add(pd5);
        store.add(pd6);         
        
        Product pd7 = new Product("Get Out","Jordan Peele", "cd", 9.99, 6);
        Product pd8 = new Product("Jumper", "Steven Gould", "cd", 5.99, 2);
        Product pd9 = new Product("The Alpinist","Peter RMortimer", "cd", 6.50, 1);
        
        store.add(pd7);
        store.add(pd8);
        store.add(pd9);
    };

    // get the items in the store 
    public void getStoreItems(){
        for (int i = 0; i < store.size(); i++){
            System.out.println("\n" +  "\t" + (i + 1) + "." + store.get(i).getProduct());
        }
    }

    //get the product within the store 
    public Product getProduct(int p){
        return store.get(p - 1);
    }

    //add a product to the store 
    public void addProduct(String t, String a, String c, double p, int q){
        Product newProduct = new Product(t, a, c, p, q);
        store.add(newProduct);
    }

    //remove a product from the store 
    public void removeProduct(int rp){
        store.remove(rp - 1);
    }
    
    // get the size of the store
    public int getSize(){
       return store.size();
    }



    
}