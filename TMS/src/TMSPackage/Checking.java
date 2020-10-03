/**
 * 
 */
package TMSPackage;

/**
 * @author gdeub
 *
 */
public class Checking extends Account {
    private boolean directDeposit;

    public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
        super(holder, balance, dateOpen);
        this.directDeposit = directDeposit;
    }
    
    /**
     * 
     */
    @Override
    public double monthlyInterest() {  
        double monthInterest = 0.0005/12;
        return monthInterest;
    }

    /**
     * 
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
}
