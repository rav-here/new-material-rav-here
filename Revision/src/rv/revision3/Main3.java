package rv.revision3;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        
        // reverse number task for scope: public/private + getters/setters
        // instantiate reverseNumber object
        reverseNumber num = new reverseNumber();
        // scanner
        Scanner scan = new Scanner(System.in);
        // set value of eggs in this object
        System.out.println("What number do you want to reverse? ");
        // set value of number in this object
        int n = scan.nextInt();
        num.setNumber(n);
        // print out the reverse of this number using the public getReverse method, which uses the private calculateReverse method
        System.out.println("Reverse of number " + n + " is " + num.getReverse());
        
        
        
        // eggs task for public/private + getters/setters
        // instantiate numberOfEggs object
        numberOfEggs theEggs = new numberOfEggs();
        // set value of eggs in this object
        System.out.println("How many eggs do you have? ");
        int a = scan.nextInt();
        theEggs.setEggs(a);
        // print out the number of remaining eggs, gross' and dozens
        System.out.println("Number of eggs remaining after dozens and gross' = " + theEggs.getRemaining());
        System.out.println("Number of gross' in eggs = " + theEggs.getGross());
        System.out.println("Number of dozens in eggs = " + theEggs.getDozens());
        
        
        // height task for constructors
        // get height values for feet and inches (through input constructor and user input) 
        System.out.println("What is the first height feet value?");
        int h1f = scan.nextInt();
        System.out.println("What is the first height inches value?");
        int h1i = scan.nextInt();
        System.out.println("What is the second height feet value?");
        int h2f = scan.nextInt();
        System.out.println("What is the second height inches value?");
        int h2i = scan.nextInt();
        
        // calling the height class!
        // create null reference varibales for height class
        Height height1, height2;
        // instantiate objects for height class using the constructor to declare and initialise the objects
        height1 = new Height(h1f, h1i); // could change (take out paraemeters/inputs) and add *
        height2 = new Height(h2f, h2i);
        
        
//        height1.input(h1f, h1i); // * if Height did not have a constructor, its object instantiation would take no inputs and a method that took input would be used here
//        height2.input(h2f, h2i); 
        // print the heights separately 
        System.out.println("height 1 is " + height1.getFeet() + " feet and " + height1.getInches() + " inches.");
        System.out.println("height 2 is " + height2.getFeet() + " feet and " + height2.getInches() + " inches.");
        // make third height object equal to their combination/sum
        height1.sum(height1, height2);
        
    }
       
}


