/**
 * 
 */
package TMSPackage;

/**
 * This class defines a MoneyMarket account and its unique features.
 * It implements the abstract methods from Account, adding the MoneyMarket account
 * options along with its monthly fee and interest rate. * 
 * @author Sandeep Alankar, Graham Deubner
 */
public class MoneyMarket extends Account{   

    private int withdrawals;

    /**
     * Parameterized constructor that calls the constructor from the superclass
     * and adds a fourth parameter, withdrawals, which is unique to a MoneyMarket account.
     * 
     * @param holder - name of person owning account
     * @param balance -  money amount in account
     * @param dateOpen -  date that account was opened
     */
    public MoneyMarket(Profile holder, double balance, Date dateOpen) {
        super(holder, balance, dateOpen);
        withdrawals = 0;
    }

    /**
     * This method returns the monthly interest rate, which is the MoneyMarket annual interest
     * rate divided by the total number of months in a year.
     * 
     * @return monthly interest rate
     */
    @Override
    public double monthlyInterest() {
        double interestRate = 0.0065;
        return interestRate/Month.TOTALMONTHS;
    }

    /**
     * This method returns the monthly fee that the customer pays on their MoneyMarket
     * account, which is dependent on the total number of withdrawals and the current balance.
     * 
     * @return monthly fee that holder must pay
     */
    @Override
    public double monthlyFee() {
        if (super.getBalance() >= 2500 && withdrawals <= 6) {
            return 0;
        }  
        else {
            return 12;
        }
    }
    
    /*
     * This method returns the number of withdrawals the holder has made on the account.
     * 
     * @return number of withdrawals followed by either "withdrawal" or "withdrawals" 
     */
    @Override
    public String getSpecialString() {
        if (withdrawals == 1) {
            return withdrawals + " withdrawal";
        }
        else {
            return withdrawals + " withdrawals";
        }
    }
}
