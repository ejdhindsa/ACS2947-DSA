package AssignmentFour;

// import statements
import java.util.Comparator;

public class OrderByLongitude<E> implements Comparator<PostalCode>
{
    public int compare(PostalCode objectOne, PostalCode objectTwo)
    {
        return (int) objectOne.getLongitude() - (int )objectTwo.getLongitude();
    } // end of compare

} // end of class
