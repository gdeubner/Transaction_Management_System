/**
 * 
 */
package TMSPackage;

/**
 * This class defines a checking account and its unique features.
 * It implements the abstract methods from Account, adding the checking account
 * options along with its monthly fee and interest rate. * 
 * @author Sandeep Alankar, Graham Deubner
 */
public class Checking extends Account {
    private boolean directDeposit;

    /**
     * Parameterized constructor that calls the constructor from the superclass
     * and adds a fourth parameter, directDeposit, which is unique to a checking account.
     * 
     * @param holder - name of person owning account
     * @param balance -  money amount in account
     * @param dateOpen -  date that account was opened
     * @param directDeposit - true if account has direct deposit, false otherwise
     */
    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
        super(holder, balance, dateOpen);
        this.directDeposit = directDeposit;
    }

    /**
     * This method returns the monthly interest rate that the holder pays, which is the 
     * annual interest rate divided by the total number of months in a year.
     * 
     * @return monthly interest rate
     */
    @Override
    public double monthlyInterest() {  
        double interestRate = 0.0005;
        double monthInterest = interestRate/Month.TOTALMONTHS;
        return monthInterest;
    }

    /**
     * This method returns the monthly fee that the holder pays, which is dependent
     * on directDeposit and the current acocunt balance.
     * 
     * @return monthly fee
     */
    @Override
    public double monthlyFee() {        
        if (directDeposit || super.getBalance() >= 1500) {
            return 0;
        } 
        else {
            return 25;
        }  
    }

    /*
     * This method returns the necessary output string for a direct deposit account.
     * 
     * @return direct deposit account if directDeposit is true, empty string otherwise
     */
    @Override
    public String getSpecialString() {
        if (directDeposit) {
            return "direct deposit account";
        }
        else {
            return "";
        }
    }
}
