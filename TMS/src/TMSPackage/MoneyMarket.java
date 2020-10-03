/**
 * 
 */
package TMSPackage;

/**
 * @author gdeub
 *
 */
public class MoneyMarket extends Account{
    private int withdrawals;

    /**
     * 
     * @param holder
     * @param balance
     * @param dateOpen
     */
    public MoneyMarket(Profile holder, double balance, Date dateOpen) {
        super(holder, balance, dateOpen);
        withdrawals = 0;
    }

    /**
     * 
     */
    @Override
    public double monthlyInterest() {
        return 0.0065/Month.TOTALMONTHS;
    }

    /**
     * 
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
}
