
import java.text.NumberFormat;

/**
 * This file contains the CheckingAccount Class. The CheckingAccount class is
 * a sub class of the Account class. The CheckingAccount class provides the
 * properties and methods of a checking account.
 *
 * @author Alex Coldwell
 */
public class CheckingAccount extends Account
{
    // Properties
    private int overdraftLimit;
    
    // Constructors
    /** Constructs a default CheckingAccount object */
    public CheckingAccount()
    {
        super();
        overdraftLimit = 0;
    }
    
    /**
     * Constructs a default CheckingAccount object with _id, and _balance value
     * 
     * @param _id - integer to set the id property
     * @param _balance - double to set the balance property
     */
    public CheckingAccount(int _id, double _balance)
    {
        id = _id;
        balance = _balance;
    }
    
    // gets
    /**
     * Returns the overdraftLimit property of the object
     *
     * @return integer overdraftLimit
     */
    public int getOverdraftLimit()
    {
        return overdraftLimit;
    }
    
    // sets
    /**
     * Sets the overdraftLimit property to integer _overdraftLimit
     *
     * @param _overdraftLimit - integer to set the overdraftLimit property
     */
    public void setOverdraftLimit(int _overdraftLimit)
    {
        overdraftLimit = _overdraftLimit;
    }
    
    // Methods
    /**
     * withdraw
     * 
     * subtracts _withdraw from balance if (balance - _withdraw) > 0
     * else throw exception. Exception is checked.
     *
     * @param _withdraw: Amount to be withdrawn from the account.
     * @throws InsufficientAmount
     */
    @Override
    public void withdraw(double _withdraw) throws InsufficientAmount
    {
        if ((balance - _withdraw) >= (overdraftLimit*-1))
        {
            balance -= _withdraw;
        }
        else
        {
            throw new InsufficientAmount(_withdraw); 
        }
                    
        
    }
    
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
