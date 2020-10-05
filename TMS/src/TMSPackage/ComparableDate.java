/**
 * 
 */
package TMSPackage;

/**
 * @author 
 *
 */
public class ComparableDate extends ComparableObject{
    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> T getCombarableObject(Account acc) {
        return (T)acc.getDateOpened();
    }
}
