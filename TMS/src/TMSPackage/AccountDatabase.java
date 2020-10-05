/**
 * 
 */
package TMSPackage;

/**
 * This class contains an array of account objects and methods for different account operations
 * like finding an account, making a deposit/withdrawal, sorting the accounts by dateOpen
 * or lastName, or printing the account list.  
 * @author Sandeep Alankar, Graham Deubner
 */
public class AccountDatabase {
    private Account[] accounts;
    private int size;


    
    public AccountDatabase() {
        int initialDBSize = 5;
        size = 4;
        accounts = new Account[initialDBSize];
    }


    /**
     * Parameterized constructor that defines features of account database of Account objects.
     * 
     * @param accounts array of Account objects
     * @param size of database array
     */
    public AccountDatabase(Account[] accounts, int size) {
        this.accounts = accounts;
        this.size = size;
    }

    /**
     * This method find a certain account and returns the index of the found account upon
     * success, searching based on account holder and account type. -1 returned on failure.
     * 
     * @param account - the account to be searched for in accounts.
     * @return - returns index of account.
     */
    private int find(Account account) { 
        boolean isChecking = account instanceof Checking;
        boolean isSavings = account instanceof Savings;
        boolean isMoneyMarket = account instanceof MoneyMarket;

        for (int i = 0; i < size; i++) {
            if (accounts[i] != null) {
                boolean checkHolder = account.getHolder().equals(accounts[i].getHolder());
                if ((checkHolder && (accounts[i] instanceof Checking == isChecking))
                        || (checkHolder && (accounts[i] instanceof Savings == isSavings))
                        || (checkHolder && (accounts[i] instanceof MoneyMarket == isMoneyMarket))) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * This method grows the capacity of the account database by 5 if the current
     * database is already full.
     */
    private void grow() { 
        int accountGrow = 5;
        Account[] newAccounts = new Account[accounts.length + accountGrow];
        for (int i = 0; i < size; i++) {
            newAccounts[i] = accounts[i];
        }
        size +=accountGrow;
        accounts = newAccounts;
    }

    /**
     * This method return false if account exists, adds account to database and grows if necessary.
     * 
     * @return false if account is already in database, returns true if account can be added
     */
    public boolean add(Account account) {
        if (find(account) != -1) {
            return false;
        }
        else {
            
            if (accounts.length >= size) { 
                grow();
            }                
            return true;
        }
    }


    /**
     * This method removes the passed-in account from the database if it exists. 
     * The last item in the accounts array replaced the removed item with the index,
     * and the index of the last item is set to null.
     * 
     * @param account - account to be removed.
     * @return boolean - returns true on successful removal, returns false on failure
     */
    public boolean remove(Account account) { 
        int accountPosition = find(account);
        if (accountPosition == -1) {
            return false;
        } else {
            if (accountPosition == size - 1) {
                accounts[accountPosition] = null;
            }
            else {
                accounts[accountPosition] = accounts[size - 1];
                accounts[size - 1] = null;
            }
            size--;
            return true;
        }
    } 

    /**
     * This method deposits amount into the passed-in account, if it exists.
     * 
     * @param account - account to deposit in
     * @param amount - amount that will be deposited
     * @return boolean - true if deposit is successful, false on failure
     */
    public boolean deposit(Account account, double amount) { 
        if (find(account) == -1) {
            return false;
        }
        else {
            account.credit(amount);
            return true;
        }
    }    

    /**
     * This method withdraws amount from the passed-in account, if it exists.
     * 
     * @param account - account in which amount will be withdrawn
     * @param amount - amount of withdrawal
     * @return - returns 0 on successful withdrawal, 1 if balance is < amount, -1 if account
     * does not exist
     */
    public int withdrawal(Account account, double amount) {
        if (find(account) == -1) {
            return -1; //account doesn't exist
        }
        else {
            if (amount > account.getBalance()) {
                return 1; //insufficient funds
            }
            else {
                return 0; //withdrawal successful
            }
        }
    }   

    /**
     * 
     */
    private void sortByDateOpen() { 

    } 
    
    /**
     *
     */
    private void sortByLastName() { 

    } 

    /**
     * This is a helper method that prints out the necessary information in the dateOpen and lastName print
     * methods. It is called in each of the methods to reduce redundancy.
     */
    public void printHelper() {
        for (int i = 0; i < size; i++) {            
            accounts[i].toString();  
            System.out.println("-interest: $ " + accounts[i].monthlyInterest());
            System.out.println("-fee: $ " + accounts[i].monthlyFee());
            double newBalance = accounts[i].getBalance() + accounts[i].monthlyInterest() - accounts[i].monthlyFee();
            System.out.println("-new balance: $ " + newBalance);
        }
    }

    /**
     * This method prints out the accounts from earliest date opened to most recent.
     */
    public void printByDateOpen() { 
        printHelper();
    }

    /**
     * This method prints out the accounts based on last name of holder in alphabetical order.
     */
    public void printByLastName() { 
        printHelper();
    }

    /**
     * This method prints out a list of made accounts, including the account type, holder, balance, 
     * date opened, and unique feature.
     */
    public void printAccounts() { 
        for (int i = 0; i < size; i++) {
            accounts[i].toString();
            System.out.println();
        }
    }
}