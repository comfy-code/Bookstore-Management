

import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in); // new scanner object 
    static boolean shop = true;
    public static void main(String[] args){

        Inventory store = new Inventory(); // inventory object 
        Member people = new Member(); // member object 
        Test  test = new Test();


        while(shop){

            // greet user 
            System.out.println("\nWelcome to the Bookstore!");
            System.out.println("\nSelect one of the following options to begin: ");
            System.out.println("1. Make a purchase");
            System.out.println("2. Donate a book, cd, or dvd to the store. ");
            System.out.println("3. Change Membership Status.");
            System.out.println("4. Exit. ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            // input validation for shop options
            while(choice != 1 && choice != 2 && choice != 3 && choice != 4){
                System.out.println("You must enter 1 to make a purchase, 2 to add an item to the store, 3 to change your status and a 4 to exit, try agian.");
                choice = sc.nextInt();
                sc.nextLine();
            }
    
            switch(choice){
                case 1: 
                    boolean bool = true; // continue shopping boolean, controls do while loop
                    double total = 0; // holds users shopping total
                    boolean bool2 = false; //controls users membership status 
                    int choice1;
    
                    // do while loop, allows user to continue shopping 
                    do{
                    //prompt user to purchase item(s)
                    System.out.println("\nSelect an item to purchase: ");
                    store.getStoreItems(); // display store products 
                    choice1 = sc.nextInt();

                    while( !(choice1 <= store.getSize()) || choice1 > store.getSize() ){
                        System.out.println("\nThat option is not available. Please select a numbered option available.");
                        store.getStoreItems();
                        choice1 = sc.nextInt();
                        sc.nextLine();
                    }
    
                    total = store.getProduct(choice1).getPrice() + total; 
                    System.out.println("\nYour total will be " + total);   
                          
                    System.out.println("\nAre you done Shopping?");
                    System.out.println("1. Yes");
                    System.out.println("2. NO");
                    int choice2 = sc.nextInt();
                    if(choice2 == 1) bool = false;
    
                    store.getProduct(choice1).setQty( store.getProduct(choice1).getQty() - 1); // take 1 of the product out of invenotry 
                    // System.out.println( store.getProduct(choice1).getQty());
                    if (store.getProduct(choice1).getQty() == 0) store.removeProduct(choice1);  // remove product if out of stock 
                }
                    while(bool); 
    
                    // shopping prompt 2, gets users details and adds to the member database
                    System.out.println("\nPlease select which member is checking out: ");
                    people.getMembers();
                    int choice3 = sc.nextInt();
                    while(choice3 < 1 || choice3 > (people.getSize() + 1)){
                        System.out.println("\nThat choice is not available. Please choose a numbered option available: ");
                        people.getMembers();
                        choice3 = sc.nextInt();
                        sc.nextLine();
                    }
                    if(choice3 >= 1 && choice3 <= people.getSize()){ 
                       System.out.println("\nThank for your purchase " + people.getMemberName(choice3 - 1) + ". Your total was " + total);
                       total += people.getMember(choice3 - 1).totalSpent();
                       people.getMember(choice3 - 1).setTotalSpent(total);
                    }
                    if( choice3 == people.getSize() + 1){
                    System.out.println("\nLets get you registered.");
                    System.out.println("Would you like to register as a free tier user or a premium user?");
                    System.out.println("\t1. FREE user ");
                    System.out.println("\t2. PREMIUM user");
                    int choice4 = sc.nextInt();
                    while( choice4 != 1 && choice4 != 2){
                        System.out.println("You must input a 1, to be a free user or 2, to be a premium user. Try again.");
                        choice4 = sc.nextInt();
                        sc.nextLine();
                    }
                    if(choice4 == 1 ){
                        bool2 = false; 
                    } else if(choice4 == 2){
                        bool2 = true;
                    }
                    System.out.println("\nPlease enter your name:");
                    String choice5 = sc.next();
                    
                    if(choice4 == 2){
                        total += 15;
                        System.out.println("\nThank you for choosing to be a premium member. Your monthly payment will be $15.00 and will be due on the first of every month.");
                    }
                    System.out.println("\nYour total comes to " + total);
                    System.out.println( "Congrats on your purchase " + choice5);
    
                    people.addMember(choice5, bool2, total); // adds member to database
    
                    people.getMembers();
    
                }
                    test.StayInStore();
                    break;
                case 2: 
                    // prompt the user for the details of the item they want to add to the store
                    System.out.println("\nWhat is the name of the product you want to add to the store?");
                    String title = sc.nextLine();
    
                    System.out.println("\nWho is the author of the item?");
                    String author = sc.nextLine();
    
                    System.out.println("\nWhat category does the item to belong to?");
                    System.out.println("1. Books");
                    System.out.println("2. CDs");
                    System.out.println("3. DVDs");
                    String category = "";
                    int choice6 = sc.nextInt();
                    while(choice6 != 1 && choice6 != 2 && choice6 != 3){
                        System.out.println("You must choose 1 for book, 2 for cd, or 3 for dvd. Try again.");
                        choice6 = sc.nextInt();
                    }
                    if (choice6 == 1) { category = "book";}
                    else if( choice6 == 2) { category = "cd";}
                    else if( choice6 == 3) { category = "dvd";}
    
                    System.out.println("\nHow much does this item cost?");
                    double price = sc.nextDouble();
    
                    System.out.println("\nHow many would you like to add to the store?");
                    int qty = sc.nextInt();
    
                    store.addProduct(title, author, category, price, qty); // adds users new product 
                    // store.getStoreItems();
    
                    // set length equal to the size of the store and let the user know their item was added successfully
                    int length = store.getSize();
                    System.out.println("\n Thank you! You have successfully added " + store.getProduct(length).getTitle()); 
                    test.StayInStore();
                    break;
                case 3: 
                    // boolean values
                    boolean isMember = false;
                    boolean memStatus = false; 
    
                    // Change membership status prompts 
                    System.out.println("\nEnter your name to change membership status?");
                    String name = sc.nextLine(); 
                    name = name.toLowerCase(); // change user input to lowercase 
                   
                    // for loop, loop through members to see if the entered name matches a member in the database 
                    for(int i = 0; i < people.getSize(); i++){
                     String name2 = people.getMemberName(i);
    
                        // if the member is in the database change their current status 
                        if(name.equalsIgnoreCase(name2) ){
                            isMember = true;
                            memStatus = people.getMember(i).getStatus();
                            System.out.println(memStatus);
    
                            if(isMember && memStatus){
                                System.out.println("\nWe found you in the database, your current membership status is premium.");
                                System.out.println("Congrats! You are now using the FREE membership.");
                            } else if(isMember && !memStatus){
                                System.out.println("\nWe found you in the database, your current membership status is FREE.");
                                System.out.println("Congrats! You are now using the Premium membership.");
                            }
                            people.getMember(i).setStatus(!memStatus); // changes member's current status to the opposite
                            
                        }
                        
                    }
                    System.out.println("\nYour name was not found in the databae. You must purchase an item to become a member.");
                    test.StayInStore();
                    break;
                case 4: 
                    shop = false; 
                    break;
                }
        }

    }

    public void StayInStore(){
         System.out.println("\nWould you like to stay in the bookstore? ");
             System.out.println("1. YES ");
             System.out.println("2. NO"); 
             int cnt = sc.nextInt(); 
             sc.nextLine();
             if( cnt == 1) shop = true;
             if( cnt == 2) shop = false; 
    }
}
