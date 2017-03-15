import java.text.NumberFormat;
import java.util.Date;

/**
 * This file contains the Account Class. The Account class is the super class
 * for the CheckingAccount, and SavingsAccount Classes. The Account class
 * provides it's subclasses with the generic properties and methods of a basic
 * Account.
 *
 * @author Alex Coldwell;
 */
public class Account {
    // Properties
    int id;
    double balance;
    double annualInterestRate;
    Date dateCreated;
    
    // Constructors
    /** Constructs a default CheckingAccount object */
    public Account()
    {
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
    }
    
    /**
     * Constructs a default CheckingAccount object with _id, and _balance value
     * 
     * @param _id - integer to set the id property
     * @param _balance - double to set the balance property
     */
    public Account(int _id, double _balance){
        this.id = _id;
        this.balance = _balance;
        this.annualInterestRate = 0.0;
        this.dateCreated = new Date();
    }
    
    // Getters

    /**
     * Returns the id property of the object
     *
     * @return integer id
     */
    public int getId()
    {
        return this.id;
    }
    
   /**
     * Returns the balance property of the object
     *
     * @return double balance
     */
    public double getBalance()
    {
        return this.balance;
    }
    
    /**
     * Returns the annualInterstRate property of the object
     *
     * @return double annualInterestRate
     */
    public double getAnnualInterestRate()
    {
        return this.annualInterestRate;
    }
    
    /**
     * Returns the dateCreated property of the object
     *
     * @return Date dateCreated
     */
    public Date getDateCreate()
    {
        return this.dateCreated;
    }

    /**
     * getMonthlyInterestRate
     * 
     * Calculates the Monthly Interest Rate
     *
     * @return double Monthly Interest Rate
     */
    public double getMonthlyInterestRate()
    {
        double Monthly;
        Monthly = (this.annualInterestRate / 12);
        return Monthly;
    }

    /**
     * getMonthlyInterest
     *
     * Calculates the Monthly Interest
     * depending on the current balance
     * 
     * @return double Monthly Interest
     */
    public double getMonthlyInterest()
    {
        double Monthly;
        Monthly = (this.annualInterestRate / 12);
        Monthly = (Monthly/100);
        Monthly = (Monthly*this.balance);
        return Monthly;
    }
            
    // Setters
    /**
     * Sets the id property to integer _id
     *
     * @param _id - integer to set the id property
     */
    public void setId(int _id)
    {
        this.id = _id;
    }
    
    /**
     * Sets the balance property to double _balance
     *
     * @param _balance - double to set the balance property
     */
    public void setBalance(double _balance)
    {
        this.balance = _balance;
    }
    
    /**
     * Sets the annualInterestRate property to double _annualInterestRate
     *
     * @param _Rate - double to set the annualInterestRate
     * property
     */
    public void setAnnualInterestRate(double _Rate)
    {
        this.annualInterestRate = _Rate;
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
    public void withdraw(double _withdraw) throws InsufficientAmount
    {
        if ((balance - _withdraw) < 0)
        {
            throw new InsufficientAmount(_withdraw);
        }
        else
        {
           balance -= _withdraw; 
        }   
    }
    
    /**
     * deposit
     * 
     * adds _deposit to balance.
     *
     * @param _deposit: Amount to be deposited into the account.
     */
    public void deposit(double _deposit)
    {
        balance += _deposit;
    } 
}
