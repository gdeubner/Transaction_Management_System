/**
 * 
 */
package TMSPackage;

/**
 * @author gdeub
 *
 */
public class Checking extends Account{
    private boolean directDeposit;
    
    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
        super(holder, balance, dateOpen);
        this.directDeposit = directDeposit;
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
