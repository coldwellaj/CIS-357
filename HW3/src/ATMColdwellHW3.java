/**
 * This file contains the ATMColdwellHW3 class. This class contains
 * the main method to test the Account, CheckingAccount, and the
 * SavingsAccount classes by running three static methods.
 *
 * @author Alex Coldwell
 */
public class ATMColdwellHW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Testing Account class...");
        testAccount();
        
        System.out.println("Testing ATM...");
        testATM();
        
        System.out.println("Testing Extra Accounts...");
        testExtraAccounts();
    }
    
    /** testAccount()
     * 
     * Tests instances of the Account class.
     *
     */
    public static void testAccount()
    {
        try {
            Account account1 = new Account(1122, 20000);
            account1.setAnnualInterestRate(4.5);
            account1.withdraw(2500);
            account1.deposit(3000);
            
            Account account2 = new Account(1123, 2000);
            account2.setAnnualInterestRate(4.5);
            account2.withdraw(2500);
            account2.deposit(3000);
            
            System.out.println(account1);
            System.out.println(account2);
        }
        catch (InsufficientAmount ex)
        {
            System.out.println("Insufficientfund!!!");
        }
        catch (Exception ex)
        {
            System.out.println("Exception Thromn");
        }
    }
    
    /** testAtm
     * 
     * Simulates transactions performed at an ATM
     *
     */
    public static void testATM()
    {
        Account[] anArray = new Account[10];
        for (int i = 0; i<10; i++)
        {
            anArray[i] = new Account();
        }
        for (int i = 0; i<10; i++)
        {
            anArray[i].setId(i + 1);
            anArray[i].setBalance(100);
        }

        
        try
        {
            System.out.println("The balance is: " + anArray[3].getBalance());
            anArray[3].withdraw(3);
            System.out.println("The balance is: " + anArray[3].getBalance());
            anArray[3].deposit(10);
            System.out.println("The balance is: " + anArray[3].getBalance());
        }
        catch (InsufficientAmount ex)
        {
            System.out.println("Insufficientfund!!!");
        }
        
                
    }
    
    /** testExtraAccounts
     * 
     * Tests instances of the CheckingAccount, and SavingsAccount classes.
     *
     */
    public static void testExtraAccounts()
    {
        try
        {
        SavingsAccount account1 = new SavingsAccount(1123, 20000);
        account1.setAnnualInterestRate(5.5);
        CheckingAccount account2 = new CheckingAccount(1124, 1000);
        account2.setAnnualInterestRate(5.0);
        account2.setOverdraftLimit(500);
        account2.withdraw(1100);
        account2.deposit(300);
        
        System.out.println(account1);
        System.out.println(account2);
        }
        catch (InsufficientAmount ex)
        {
            System.out.println("Insufficient Fund!!!");
        }
        catch (Exception ex)
        {
            System.out.println("Exception Thromn");
        }
        
        
        
    }
}

