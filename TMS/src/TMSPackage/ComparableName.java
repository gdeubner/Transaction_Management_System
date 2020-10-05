/**
 * 
 */
package TMSPackage;

/**
 * @author gdeub
 *
 */
public class ComparableName extends ComparableObject{
    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> T getCombarableObject(Account acc) {
        return (T)acc.getHolder().getLName();
    }
}