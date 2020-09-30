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
    
    public Account(Profile holder, double balance, Date dateOpen) {
        this.holder = holder;
        this.balance = balance;
        this.dateOpen = dateOpen;
        
    }
    
    
    public void debit(double amount) { } //decrease the balance by amount
    public void credit(double amount) { } //increase the balance by amount
    public String toString() { 
        return null;
    }
    public abstract double monthlyInterest();
    public abstract double monthlyFee();
}
