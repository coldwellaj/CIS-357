import java.text.NumberFormat;

/**
 * This file contains the SavingsAccount Class. The SavingsAccount class is
 * a sub class of the Account class. The SavingsAccount class provides the
 * properties and methods of a savings account.
 *
 * @author Alex Coldwell
 */
public class SavingsAccount extends Account
{
    // Constructors
    /** Constructs a default SavingsAccount object */
    public SavingsAccount()
    {
        
    }
    
    /**
     * Constructs a default SavingsAccount object with _id, and _balance value
     * 
     * @param _id - integer to set the id property
     * @param _balance - double to set the balance property
     */
    public SavingsAccount(int _id, double _balance)
    {
        id = _id;
        balance = _balance;
    }
    
    // Methods
    @Override
    public String toString()
    {
        String hold = "";
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(balance);
        
        hold = "Id: " + id +" Date Created: " + dateCreated +
                " Balance: " + moneyString + " Montly Interest Rate: "
                + String.format("%1$.2f",annualInterestRate/12) + "%" ;
        return hold;
    }
}
