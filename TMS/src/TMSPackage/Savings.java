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
    
    public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
        super(holder, balance, dateOpen);
        this.isLoyal = isLoyal;
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
