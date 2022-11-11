package rv.revision3;

public class numberOfEggs {
    
    // variables for input/output values
    private int eggs;
    private int gross = 0;
    private int dozens = 0;
    private int remaining;

    // set the variable eggs, make it modifiable
    public void setEggs(int eggs) {
        this.eggs = eggs;
    }
    // get the varibale eggs using howManyEggs method, make it readable for other classes
    public int getRemaining() {
        howManyEggs();
        return remaining;
    }
    // get the variable dozens using howManyEggs method, make it readable for other classes
    public int getDozens() {
        howManyEggs();
        return dozens;
    }
    // get the varibale gross using howManyEggs method, make it readable for other classes
    public int getGross() {
        howManyEggs();
        return gross;
    }
    // make private method howManyEggs, unaccessible to other classes
    private void howManyEggs() {
        // while the number of eggs is greater than or equal to 12
        while (eggs >= 12) {
            // if the number of eggs is greater than 144 (a gross0
            if (eggs >= 144) {
                gross += 1; // add to gross count
                eggs -= 144; // take gross value away from the number of eggs 
            }
            // otherwise (eggs<144)
            else {
                dozens += 1; // add to dozens count
                eggs -= 12; // take dozen value away from the number of eggs
            }
        }
        // set the final number of eggs to equal remaining variable 
        remaining = eggs;
     
    }
    
}