/**
 * 
 */
package TMSPackage;

/**
 * @author gdeub
 *
 */
public class Savings extends Account{
    private boolean isLoyal;

    /**
     * 
     * @param holder
     * @param balance
     * @param dateOpen
     * @param isLoyal
     */
    public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
        super(holder, balance, dateOpen);
        this.isLoyal = isLoyal;
    }

    /**
     * 
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
     * 
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
}
