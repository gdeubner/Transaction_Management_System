/**
 * 
 */
package TMSPackage;

/**
 * @author gdeub
 *
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
    public Date getDateOpened() {
        return dateOpen;
    }
    
    /**
     * Decreases the balance by amount.
     * @param amount 
     */
    public void debit(double amount) { 
        balance -= amount;
    } 

    /**
     * Increases the balance by amount.
     * @param amount
     */
    public void credit(double amount) { 
        balance += amount;
    } 

    /**
     * 
     */
    public String toString() {
        return null;
    }

    /**
     * 
     */
    public abstract double monthlyInterest();    

    /**
     * 
     */
    public abstract double monthlyFee();

    public abstract String getSpecialString();
}
