

public class Product {
    //instance variables 
    private String title;
    private String author;
    private String category; 
    private double price;
    private int qty;
    
    //product conrstructor 
    public Product(String t, String a, String c, double p, int q){
        this.title = t;
        this.category = c; 
        this.author = a;
        this.price = p;
        this.qty = q;
    }


    //returns tthr product and its details 
    public String getProduct(){
       return  getTitle() + "," + " - " + " (" + getCategory() + ")" + " - " + getPrice() + " - " + getQty();
    }

    //get title of product 
    public String getTitle(){
        return this.title;
    }

    // set title of product 
    public void setTitle(String t){
        this.title = t;
    }

    // get author of the product 
    public String getAuthor(){
        return this.author;
    }


    //set author of the product 
    public void setAuthor(String a){
        this.author = a; 
    }

    // get price of a product 
    public double getPrice(){
        return this.price;
    }

    //set price of a product 
    public void setPrice(double p){
        this.price = p;
    }
    
    // get quantity of a product 
    public int getQty(){
        return this.qty;
    }

    //subtract quantity of a product 
    public int subtractQty(){
        return this.qty - 1; 
    }

    //set quantity of a product 
    public void setQty(int q){
        this.qty = q;
    }
    
    //get the category of a product 
    public String getCategory(){
        return this.category;
    }

    //set the quantity of a product 
    public void setCategory(String c){
        this.category = c; 
    }

}
