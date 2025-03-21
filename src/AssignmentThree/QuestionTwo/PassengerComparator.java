package AssignmentThree.QuestionTwo;

// import statements
import java.sql.Timestamp;
import java.util.Comparator;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public class PassengerComparator implements Comparator<Passenger>
{
    /**
     * Comparator that compares two passenger objects based on the criteria as mentioned by the assignment
     * @param p1 the first object to be compared.
     * @param p2 the second object to be compared.
     * @return compared integer
     */
    public int compare(Passenger p1, Passenger p2)
    {
        if (p1.getFare().getFareCode() < p2.getFare().getFareCode())
        {
            return -1;
        } // end of if
        else if (p1.getFare().getFareCode() == p2.getFare().getFareCode())
        {
            if (p1.getFlyerStatus().getStatusCode() < p2.getFlyerStatus().getStatusCode())
            {
                return -1;
            } // end of if
            else if (p1.getFlyerStatus().getStatusCode() == p2.getFlyerStatus().getStatusCode())
            {
                if (Timestamp.valueOf(p1.getTimestamp()).after(Timestamp.valueOf(p2.getTimestamp())))
                {
                    return -1;
                }
                else if (Timestamp.valueOf(p1.getTimestamp()).before(Timestamp.valueOf(p2.getTimestamp())))
                {
                    return 1;
                }
                else if (Timestamp.valueOf(p1.getTimestamp()).equals(Timestamp.valueOf(p2.getTimestamp())))
                {
                    return 0;
                } // end of else if

            } // end of else if

        } // end of else-if

        return 1;
    } // end of compare

} // end of PassengerComparator
