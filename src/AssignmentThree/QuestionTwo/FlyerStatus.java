package AssignmentThree.QuestionTwo;

import java.util.Random;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public enum FlyerStatus
{
    // instantiating enum values
    GOLD("Gold", 1),
    SILVER("Silver", 2),
    BRONZE("Bronze", 3),
    NONE("None", 4);

    // instance variables
    private String statusName;
    private int statusCode;

    // private constructor
    private FlyerStatus(String statusName, int statusCode)
    {
        this.statusName = statusName;
        this.statusCode = statusCode;

    } // end of full arg constructor

    // --------- ACCESS METHOD -----------

    public String getStatusName() {
        return statusName;
    } // end of getStatusName()

    public int getStatusCode() {
        return statusCode;
    } // end of getStatusCode

    // ----------- UTILITY METHODS --------------

    /**
     * Public utility method that returns a random flyer status
     * @return random flyer status
     */
    public static FlyerStatus randomValue()
    {
        Random rnd  = new Random();
        FlyerStatus[] values = FlyerStatus.values();

        return values[rnd.nextInt(values.length)];

    } // end of randomValue()

    @Override
    public String toString() {
        return statusName;
    } // end of toString()

} // end of FlyerStatus
