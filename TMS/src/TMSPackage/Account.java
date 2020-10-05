/**
 * 
 */
package TMSPackage;

/**
 * This class defines the basic features of an account, regardless of what type it is.
 * It contains getter methods to access its private instance variables, and two abstract
 * methods that are implemented in each of its child classes. * 
 * @author Sandeep Alankar, Graham Deubner
 */
public abstract class Account {    
    private Profile holder;
    private double balance;
    private Date dateOpen;

    /**
     * Parameterized constructor that initializes instance variables, allows 
     * use in other classes.
     * @param holder
     * @param balance, money amount in account
     * @param dateOpen
     */
    public Account (Profile holder, double balance, Date dateOpen) {
        this.holder = holder;
        this.balance = balance;
        this.dateOpen = dateOpen;
    }

    /**
     * Getter method that returns holder.
     * 
     * @return holder of account
     */
    public Profile getHolder() {
        return holder;
    }

    /**
     * Getter method that returns balance.
     * 
     * @return balance of account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter method that returns dateOpen.
     * 
     * @return dateOpen, date that account was opened
     */
    public Date getDateOpen() {
        return dateOpen;
    }

    /**
     * Decreases the balance by amount.
     * 
     * @param amount 
     */
    public void debit(double amount) { 
        balance -= amount;
    } 

    /**
     * Increases the balance by amount.
     * 
     * @param amount
     */
    public void credit(double amount) { 
        balance += amount;
    } 

    /**
     * returns holder, balance, and dateOpen separated by *. This method is called in each of the account
     * subclasses.
     * 
     * @return String representation of holder, balance, and dateOpen
     */
    public String toString() {
        return holder + "* $" + balance + "*" + dateOpen;
    }

    /**
     * Empty abstract method that is implemented in each of child classes.
     */
    public abstract double monthlyInterest();    

    /**
     * Empty abstract method that is implemented in each of child classes.
     */
    public abstract double monthlyFee();   

    /**
     * Empty abstract method that is implemeneted in subclasses and returns appropriate strings.
     */

    public abstract String getSpecialString();       

}
