/**
 * 
 */
package TMSPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing the monthlyInterest and monhlyFee methods in the MoneyMarket class.
 * @author Graham Deubner, Sandeep Alankar
 */
class MoneyMarketTest {
    Account batAccount;
    /**
     * This method does the setup necessary for the tests in this class.
     * @throws java.lang.Exception - this exception was auto-generated
     */
    @BeforeEach
    void setUp() throws Exception {
        Profile p = new Profile("Bruce", "Wane");
        Date d = new Date(7, 19, 1985);
        batAccount = new MoneyMarket(p, 10000000, d);
    }


    /**
     * Test method for {@link TMSPackage.MoneyMarket#monthlyInterest()} testing monthlInterest().
     */
    @Test
    void testMonthlyInterest() {
        assertEquals(batAccount.monthlyInterest(), 5416.666666666666);
    }

    /**
     * Test method for {@link TMSPackage.MoneyMarket#monthlyFee()} testing monthlyFee().
     */
    @Test
    void testMonthlyFee() {
        assertEquals(batAccount.monthlyFee(),0);
        for(int i = 0; i < 7; i++)
            batAccount.withdraw(20000);
        assertEquals(batAccount.monthlyFee(),12);
    }

}
