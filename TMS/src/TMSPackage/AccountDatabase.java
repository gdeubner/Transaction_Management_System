/**
 * 
 */
package TMSPackage;
import java.text.DecimalFormat;
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
        size = 0;
        accounts = new Account[initialDBSize];
    }

    /**
     * This method find a certain account and returns the index of the found account
     * upon success, searching based on account holder and account type. -1 returned
     * on failure.
     * 
     * @param account - the account to be searched for in accounts.
     * @return - returns index of account.
     */
    private int find(Account account) {
        for (int i = 0; i < size; i++) {
            if (account.getHolder().equals(accounts[i].getHolder())) {
                if (account.getAccountType() == accounts[i].getAccountType()) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
     * This method searches for and returns a given account.
     * @param account - a account wrapper Account class, containing only the desired account name and type.
     * @return returns the sought after account. Returns null on failure.
     */
    private Account getAccount(Account account) {
        for (int i = 0; i < size; i++) {
            if (account.getHolder().equals(accounts[i].getHolder())) {
                if (account.getAccountType() == accounts[i].getAccountType()) {
                    return accounts[i];
                }
            }
        }
        return null;
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
        accounts = newAccounts;
    }

    /**
     * This method return false if account exists, adds account to database and grows if necessary.
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
            accounts[size++] = account;
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
            Account targetAccount = getAccount(account);
            targetAccount.credit(amount);
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
            Account targetAccount = getAccount(account);
            if (amount > targetAccount.getBalance()) {
                return 1; //insufficient funds
            }
            else {
                targetAccount.withdraw(amount);
                if(targetAccount instanceof MoneyMarket)
                    ((MoneyMarket) targetAccount).incrementWithdrawal();
                return 0; //withdrawal successful
            }
        }
    }   

    /**
     * This method employs select sort to sort the Accounts by date opened
     */
    private void sortByDateOpen() { 
        int length = size;
        for (int i = 0; i < length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < length; j++) {
                //System.out.println(" i:" + i + " j:" + j + " min_index:" + min_idx);
                if (accounts[j].getDateOpen().compareTo( accounts[min_idx].getDateOpen()) < 0)
                    min_idx = j;
                }  
            Account temp = accounts[min_idx];
            accounts[min_idx] = accounts[i];
            accounts[i] = temp;
        }
    } 
    
    /**
     *This method employs select sort to sort the Accounts by last name
     */
    private void sortByLastName() {
        int length = size;
        for (int i = 0; i < length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < length; j++)
                if (accounts[j].getHolder().getLName().compareTo(accounts[min_idx].getHolder().getLName()) < 0)
                    min_idx = j;
            Account temp = accounts[min_idx];
            accounts[min_idx] = accounts[i];
            accounts[i] = temp;
        }
    }

    /**
     * This is a helper method that prints out the necessary information in the dateOpen and lastName print
     * methods. It is called in each of the methods to reduce redundancy.
     */
    public void printHelper() {
        DecimalFormat decimalFormat;
        decimalFormat = new DecimalFormat(",000.00");
        for (int i = 0; i < size; i++) {              
            System.out.println(accounts[i].toString());
            System.out.println("-interest: $ " + decimalFormat.format(accounts[i].monthlyInterest()));
            System.out.println("-fee: $ " + decimalFormat.format(accounts[i].monthlyFee()));
            double newBalance = accounts[i].getBalance() + accounts[i].monthlyInterest() - accounts[i].monthlyFee();
            System.out.println("-new balance: $ " + decimalFormat.format(newBalance) + "\n");
        }
    }

    /**
     * This method prints out the accounts from earliest date opened to most recent.
     */
    public void printByDateOpen() {
        if (size == 0)
            System.out.println("Database is empty!");
        else {
            sortByDateOpen();
            System.out.println("--Printing statements by date opened--\n");
            printHelper();
            System.out.println("--end of printing--\n");
        }
    }

    /**
     * This method prints out the accounts based on last name of holder in
     * alphabetical order.
     */
    public void printByLastName() {
        if (size == 0)
            System.out.println("Database is empty!");
        else {
            sortByLastName();
            System.out.println("--Printing statements by last name--\n");
            printHelper();
            System.out.println("--end of printing--\n");
        }
    }

    /**
     * This method prints out a list of made accounts, including the account type,
     * holder, balance, date opened, and unique feature.
     */
    public void printAccounts() {
        if (size == 0)
            System.out.println("Database is empty!");
        else {
            System.out.println("--Listing accounts in the database--");
            for (int i = 0; i < size; i++) {
                System.out.println(accounts[i].toString());
            }
            System.out.println("--end of listing--\n");
        }
    }
}
