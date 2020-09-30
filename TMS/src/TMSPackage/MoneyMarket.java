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
    
    public MoneyMarket(Profile holder, double balance, Date dateOpen, int withdrawals) {
        super(holder, balance, dateOpen);
        this.withdrawals = withdrawals;
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
