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
    
    public MoneyMarket(Profile holder, double balance, Date dateOpen) {
        super(holder, balance, dateOpen);
        withdrawals = 0;
    }

    @Override
    public double monthlyInterest() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double monthlyFee() {
        // TODO Auto-generated method stub
        return 0;
    }
}
