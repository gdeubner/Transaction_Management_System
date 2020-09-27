/**
 * 
 */
package TMSPackage;

/**
 * @author Graham Deubner, Sandeep Alankar
 * This class represents a profile for an account holder. It stores a first and last name.
 * It contains getters for both names.
 *
 */
public class Profile {
    
    private String fname;
    private String lname;

    /**
     * constructor method which assigns fname and lname the names for the profile
     * @param fname - the first name for the profile
     * @param lname - the last name for the profile
     */
    public Profile(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    
    /**
     * Method that returns the the last name for the Profile
     * @return the last name in a String
     */
    public String getLName() {
        return lname;
    }
    
    /**
     * Method that returns the the first name for the Profile
     * @return the first name in a String
     */
    public String getFName() {
        return fname;
    }
}
