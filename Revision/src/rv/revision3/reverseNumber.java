package rv.revision3;

public class reverseNumber {
    
    // private - cannot be accessed by other classes 
    // create variables for number and its reverse
    private int number = 12345;  // doesnt need to be set, can be changed when called/instantiated
    private int reverse = 0; 
    
    // public - can be accessed by other classes
    // set number variable - make it modifiable
    public void setNumber(int number) {
        this.number = number;
    }
    
    // public - can be accessed by other classes
    // get reverse method - make the calculate reverse method readable 
    public int getReverse() {
        calculateReverse();
        return reverse;
    }
    
    // private - cannot be accessed by other classes- but is used in get reverse which is public
    private void calculateReverse() {
    // while the number is non zero
    while(number !=0) { 
        // get the remainder after the number is divided by 10 (modulus of 10)
        // i.e. whats after the decimal -> 12345 % 10 = 5
        int remainder = number % 10;
        
        // times the reverse number by 10
        // the number reverse is equal to itself mutliplied by 10
        // first round-> 0 x 10 = 0
        reverse = reverse * 10;
        
        // add the remiander to the reverse
        // the number reverse is equal to itself multiplied by the number mod 10
        // first round -> 0 + 5 = 5
        reverse = reverse + remainder;
        
        // divide the current number by 10 (removing the last digit essentially)
        number = number / 10;
    }
}

}
