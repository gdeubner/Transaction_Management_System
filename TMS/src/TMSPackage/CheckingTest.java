/**
 * 
 */
package TMSPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author gdeub
 *
 */
class CheckingTest {
    Account superAccount;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        Profile p = new Profile("Clark", "Kent");
        Date d = new Date(4, 17, 1962);
        superAccount = new Checking(p, 200000, d, false);
    }


    /**
     * Test method for {@link TMSPackage.Checking#monthlyInterest()}.
     */
    @Test
    void testMonthlyInterest() {
        assertEquals(superAccount.monthlyInterest(), 4.1666666666666665E-5);
    }

    /**
     * Test method for {@link TMSPackage.Checking#monthlyFee()}.
     */
    @Test
    void testMonthlyFee() {
        assertEquals(superAccount.monthlyFee(), 0);
        superAccount.withdraw(199000);
        assertEquals(superAccount.monthlyFee(), 25);

    }

}
