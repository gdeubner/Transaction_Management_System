/**
 * 
 */
package TMSPackage;

/**
 * This class defines a savings account and its unique features.
 * It implements the abstract methods from Account, adding the savings account
 * options along with its monthly fee and interest rate. * 
 * @author Sandeep Alankar, Graham Deubner
 */
public class Savings extends Account{
    private boolean isLoyal;

    /**
     * Parameterized constructor that calls the constructor from the superclass
     * and adds a fourth parameter, isLoyal, which is unique to a savings account.
     * 
     * @param holder - name of person owning account
     * @param balance -  money amount in account
     * @param dateOpen -  date that account was opened
     * @param isLoyal - boolean that is true if customer is loyal, false otherwise
     */
    public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
        super(holder, balance, dateOpen);
        this.isLoyal = isLoyal;
    }

    /**
     * This method returns the monthly interest rate, which is different depending on whether
     * or not the customer is loyal or not.
     * 
     * @return monthly interest rate, which is annual interest date divided by num of months
     */
    @Override
    public double monthlyInterest() {
        double monthInterest = 0.0025; //annual interest rate of 0.25%
        double isLoyalInterest = 0.0035; //loyal customer interest rate of 0.35%
        if (isLoyal) {
            return isLoyalInterest/Month.TOTALMONTHS;
        }
        else {
            return monthInterest/Month.TOTALMONTHS;
        }
    }

    /**
     * This method returns the monthly fee, which depends on the current balance in the 
     * account.
     * 
     * @return monthly fee that holder pays
     */
    @Override
    public double monthlyFee() {
        if (super.getBalance() >= 300) {
            return 0;
        }
        else {
            return 5;
        }       
    }
    
    /*
     * This method checks if the customer is loyal, and if so, marks the acocunt as special savings.
     * 
     * @return special savings account if the holder is loyal, empty string otherwise
     */
    @Override
    public String getSpecialString() {
        if (isLoyal) {
            return "special Savings account";
        }
        else {
            return "";
        }
    }
}
