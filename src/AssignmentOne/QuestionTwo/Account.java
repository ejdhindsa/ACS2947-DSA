package AssignmentOne.QuestionTwo;

/**
 * ACS-2927 | Assignment One <br>
 * Account class based on the requirements of the assignment PDF that handles buying
 * and selling of the shares.
 * The account class also gives a brief description of the current account using methods
 * such as getTotalValue() ad getTotalShares()
 *
 * @author Ekamjot Singh | 3167888
 * @version 1.0
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Assignment_One">GitHub</a>
 */

public class Account
{
    // instance variables of account class
    private ArrayQueue<Integer> shares;             // ArrayQueue of shares
    private double totalValue;                      // total value of the shares
    private int totalShares;                        // total number of shares

    /**
     * Constructor of the Account() class that instantiates the shares ArrayQueue when called
     * and also sets the initial value and number of shares as zero.
     */
    public Account()
    {
        shares = new ArrayQueue<>();        // instantiate the ArrayQueue
        totalValue = 0.0;                   // set the total value of shares to 0
        totalShares = 0;                    // set the total number of shares to 0
    } // end of constructor

    // ---------- Access Methods -----------

    /**
     * Public method that returns the total value of the shares as a double to the user
     * @return total value of the shares
     */
    public double getTotalValue()
    {
        return totalValue;
    } // end of getTotalValue()

    /**
     * Public method that returns the total number of the shares as an int to the user
     * @return total number of shares
     */
    public int getTotalShares()
    {
        return totalShares;
    } // end of getTotalShared()

    // ------------ Utility Methods ------------

    /**
     * Public method that handles the buying of the shares by the user.
     * It takes the number of shares to be bought and the value of those shares and then
     * enqueues the shares into the ArrayQueue.
     * Along with that, this method also updates the total value of the shares as well as
     * the total number of shares currently in the account
     * @param shareQuantity number of shares of bought
     * @param sharePrice price at which shares are bought
     */
    public void buyShares(int shareQuantity, int sharePrice)
    {
        // using a for loop to enqueue the ArrayQueue
        for (int i = 0; i < shareQuantity; i++)
        {
            shares.enqueue(sharePrice);             // enqueue the price of shares
            totalValue += sharePrice;               // increase the total value by share price for each share
            totalShares++;                          // increase the number of shares by one

        } // end of for loop

    } // end of buyShares()

    /**
     * Public method that handles the selling of the shares by the user.
     * It takes the number of shares to be sold and the value of the shares and then
     * dequeues them from the ArrayQueue.
     * The method also updates the total value of the shares and the total number of shares
     * current in the account.
     * It also provides the user with the amount of capital that has changed
     * @param shareQuantity number of shares to be sold
     * @param sharePrice price of each share
     * @return the amount of capital changed as a double
     * @throws IllegalArgumentException if the user tries to sell more shares than what they own
     */
    public double sellShares(int shareQuantity, int sharePrice) throws IllegalArgumentException
    {
        // throwing an IllegalStateException as the user tries to sell more shares than they own
        if (shareQuantity > this.totalShares)
            throw new IllegalArgumentException("You cannot sell more shares than you currently own!\n" +
                    "Trying to sell " + shareQuantity + " shares when you only have "
                    +  this.shares + " shares.");

        double currentValue = 0;
        double capitalChanged = 0;

        // using a for loop to dequeue the shares and update current value
        for(int i = 0; i < shareQuantity; i++)
        {
            currentValue += shares.dequeue();
        } // end of for

        // the amount of capital gained, it is found by the mathematical formula:
        // Profit / Loss = Selling Price - Cost Price
        capitalChanged = (sharePrice * shareQuantity) - currentValue;

        totalValue = totalValue - currentValue;             // updating the total value of the shares
        totalShares = totalShares - shareQuantity;          // updating the number of shares still in the account

        return capitalChanged;

    } // end of sellShares

    /**
     * Overridden toString method that returns the basic details of the account to the user
     * @return String information of the account class
     */
    @Override
    public String toString()
    {
        // creating a StringBuilder
        StringBuilder sb = new StringBuilder();

        // appending in the string builder
        sb.append("Total Shares: ");
        sb.append(this.totalShares);
        sb.append("\n");
        sb.append("Total Value: ");
        sb.append(this.totalValue);

        return sb.toString();

    } // end of toString

} // end of class
