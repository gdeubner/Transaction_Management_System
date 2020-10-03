/**
 * 
 */
package TMSPackage;

//Check if this import is okay!!!!!!!!!!!!!!!!!!!!!!!!!
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author gdeub
 *
 */
public class TransactionManager {
    
    private static AccountDatabase db;
    private static Scanner scan;
    
    public void run() {
        db = new AccountDatabase();
        scan = new Scanner(System.in);

        while (true) {
            String[] input = scan.nextLine().split("\\s");
            if (input[0].equals("OC") || input[0].equals("OS") || input[0].equals("OM")) {
                open(input);
            } else if(input[0].equals("CC") || input[0].equals("CS") || input[0].equals("CM")){
                close(input);
            } else if(input[0].equals("DC") || input[0].equals("DS") || input[0].equals("DM")){
                deposit(input);
            }else if(input[0].equals("WC") || input[0].equals("WS") || input[0].equals("WM")){
                withdraw(input);
            }else if(input[0].equals("PA") || input[0].equals("PD") || input[0].equals("PN")){
                print(input);
            }else if(input[0].equals("Q")){
                quit();
                break;
            } else {
                System.out.println("Command " + input[0] + " not supported!");
            }

        }
        // scan.close();
    }
    
    /**
     * Helper method ...
     * 
     * @param input            - user provided input from the command line
     * @param requiredInputNum - the number of parameters required for a GroceryItem
     * @param myScanner        - the Scanner object used to get user input
     * @return a String array containing the 3 required parameters forGroceryItem
     */
    private static String[] getInputs(String[] input, int requiredInputNum) {
        int inputTokenCounter = 0; // counter for parameters entered by user
        String[] commands = new String[requiredInputNum];
        while (inputTokenCounter < requiredInputNum) {
            for (String s : input) {
                commands[inputTokenCounter] = s;
                inputTokenCounter++;
            }
            if (inputTokenCounter < requiredInputNum)
                input = scan.nextLine().split("\\s");
        }
        return commands;
    }
    
    private static Date createDate(String date) {
        int numDateValues = 3; //for the 3 values that makes up a date 
        StringTokenizer tokenizer = new StringTokenizer(date, "/", false);
        int[] dateValues = new int[numDateValues];
        for(int i = 0; i < dateValues.length; i++) {
            try {
                dateValues[i] = Integer.parseInt(tokenizer.nextToken());
            } catch(NoSuchElementException exception) {
                System.out.println("Invlaid date entered. Too few values.");
                return null;
            }
        }
        return new Date(dateValues[0], dateValues[1], dateValues[2]);
    }
    
    private static double convertBalance(String strBalance) {
        double balance;
        try {
            balance = Double.parseDouble(strBalance);
        } catch (NumberFormatException exception){
            System.out.println("Invalid balance entered.");
            return -1;
        } catch (NullPointerException exception) {
            System.out.println("No balance entered.");
            return -1;
        }
        return balance;
    }
    
    private static boolean convertBoolean(String bool) throws RuntimeException {
        if(bool.equalsIgnoreCase("true"))
            return true;
        else if(bool.equalsIgnoreCase("false"))
            return false;
        else
            throw new RuntimeException();
    }
    
    //inputs: 0:command, 1:fname, 2:lname, 3:balance, 4:date, 5:specialValue
    private static Account createAccount(String[] inputs) {
        Account newAccount;
        Profile profile;
        double balance;
        Date date;
        boolean specialValue;  //directDeposit for Checking class or isLoyal for Savings class
        profile = new Profile(inputs[1], inputs[2]);
        balance = convertBalance(inputs[3]);
        date = createDate(inputs[4]);
        specialValue = convertBoolean(inputs[5]);
        if(inputs[0].equals("OC")) {
            newAccount = new Checking(profile, balance, date, specialValue);
        } else if(inputs[0].equals("OS")) {
            newAccount = new Savings(profile, balance, date, specialValue);
        } else if(inputs[0].equals("OM")) {
            newAccount =new MoneyMarket(profile, balance, date);
        } else {
            System.out.println("Account type error.");
            return null;
        }
        return newAccount;
    }

    // OC John Doe 300 1/1/2020 false //open a checking account with $300, non-direct deposit
    // OS John Doe 500.5 1/1/2020 true //open a savings account with $500.50, loyal customer
    // OM John Doe 1234.567 1/1/2020 //open a money market account with $1,234.57
    private static void open(String[] input) {
        Account newAccount = null;
        int checkingSavingInputNum = 6;
        int MoneyMarkInputNum = 5;
        switch (input[0]) {
        case "OC":
            input = getInputs(input, checkingSavingInputNum);
            newAccount = createAccount(input);
            break;
        case "OS":
            input = getInputs(input, checkingSavingInputNum);
            newAccount = createAccount(input);
            break;
        case "OM":
            input = getInputs(input, MoneyMarkInputNum);
            newAccount = createAccount(input);
            break;
        }
        if(newAccount != null) {
            if(db.add(newAccount))
                System.out.println("Account opened and added to the database.");
            else
                System.out.println("Account is already in the database.");
        } else {
            System.out.println("Error: New account not added");
        }
    }

    private static void close(String[] input) {

    }

    private static void deposit(String[] input) {

    }
    
    private static void withdraw(String[] input) {
        
    }
    
    private static void print(String[] input) {
        
    }
    
    private static void quit() {
        System.out.println("Transaction processing complete.");
    }
    
    
    public static void main(String[] args) {
        //System.out.println(createDate("9/30/2020").toString());
        
        
    }
    
}
