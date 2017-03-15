/** 
 * This file contains the InsufficientAmount class. This class extends the
 * Exception class. This class is to be thrown when the amount to withdraw
 * will cause an overdraft in the account. Prints error.
 *
 * @author Alex Coldwell
 */
public class InsufficientAmount extends Exception
{
    private double Amount;

  /** InsufficientAmount
   * 
   *  Construct an exception
   * 
   *  @param Amount: amount to be withdrawn 
   */
  public InsufficientAmount(double Amount) {
    super("Insufficient Ammount " + Amount);
    this.Amount = Amount;
  }

  /** getAmount
   * 
   * 
   *  Return the Amount
   *  @return Amount  
   */
  public double getAmount() {
    return Amount;
  }
}
