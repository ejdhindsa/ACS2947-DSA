package AssignmentThree.QuestionTwo;

// import statements
import java.util.Date;
import java.sql.Timestamp;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public class Passenger implements Comparable<Passenger>
{
    // instance variables
    private String passportNumber;
    private Fare fare;
    private FlyerStatus flyerStatus;
    private String timestamp;

    public Passenger(String passportNumber)
    {
        this.passportNumber = passportNumber;
        this.fare = Fare.randomValue();
        this.flyerStatus = FlyerStatus.randomValue();
        this.timestamp = new Timestamp(new Date().getTime()).toString();
    } // end of full argument constructor

    // ------------------ ACCESS METHODS -----------------

    public String getPassportNumber() {
        return passportNumber;
    } // end of getPassportNumber()

    public Fare getFare() {
        return fare;
    } // end of getFare()

    public FlyerStatus getFlyerStatus() {
        return flyerStatus;
    } // end of getFlyerStatus()

    public String getTimestamp() {
        return timestamp;
    } // end of getTimestamp()


    // ----------------- UPDATE METHODS ------------------

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    } // end of setPassportNumber()

    // ---------------- UTILITY METHODS -----------------

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Passenger ");
        sb.append("( Passport: ").append(passportNumber);
        sb.append(", Fare: ").append(fare);
        sb.append(", FlyerStatus: ").append(flyerStatus);
        sb.append(", Timestamp: ").append(timestamp);
        sb.append(" )");

        return sb.toString();

    } // end of toString()

    /**
     * Method for comparing two entries of a passenger in accordance to their passport number
     * @param other the object to be compared.
     * @return compared int
     */
    public int compareTo(Passenger other)
    {
        return this.passportNumber.compareTo(other.passportNumber);
    } // end of compareTo

} // end of Passenger
