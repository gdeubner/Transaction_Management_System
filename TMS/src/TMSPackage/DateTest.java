/**
 * 
 */
package TMSPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * class for testing isValid in the date class.
 * @author Graham Deubner, Sandeep Alankar
 *
 */
class DateTest {
   
    /**
     * Test method for {@link TMSPackage.Date#isValid()}.
     */
    @Test
    void testIsValid() {
        assertTrue(new Date(1, 1, 1).isValid());
        assertTrue(new Date(12, 31, 3000).isValid());
        assertFalse(new Date(7, 32, 1).isValid());
        assertFalse(new Date(0, 1, 2020).isValid());
        assertFalse(new Date(1, -20, 2020).isValid());
        assertFalse(new Date(2, 29, 2022).isValid());
        assertTrue(new Date(2, 28, 2022).isValid());
        assertTrue(new Date(2, 29, 2000).isValid());
        assertFalse(new Date(2, 30, 2022).isValid());
        assertTrue(new Date(2, 29, 2000).isValid());
        assertFalse(new Date(2, 29, 1900).isValid());

    }

}
