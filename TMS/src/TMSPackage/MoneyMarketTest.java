/**
 * 
 */
package TMSPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Graham Deubner, Sandeep Alankar
 *
 */
class MoneyMarketTest {
    Account batAccount;
    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        Profile p = new Profile("Bruce", "Wane");
        Date d = new Date(7, 19, 1985);
        batAccount = new MoneyMarket(p, 10000000, d);
    }


    /**
     * Test method for {@link TMSPackage.MoneyMarket#monthlyInterest()}.
     */
    @Test
    void testMonthlyInterest() {
        assertEquals(batAccount.monthlyInterest(), 5.416666666666666E-4);
    }

    /**
     * Test method for {@link TMSPackage.MoneyMarket#monthlyFee()}.
     */
    @Test
    void testMonthlyFee() {
        assertEquals(batAccount.monthlyFee(),0);
        for(int i = 0; i < 7; i++)
            batAccount.withdraw(20000);
        assertEquals(batAccount.monthlyFee(),12);
    }

}
