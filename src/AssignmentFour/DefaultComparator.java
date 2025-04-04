package AssignmentFour;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<PostalCode>
{
    public int compare(PostalCode ObjectOne, PostalCode ObjectTwo)
    {
        return ObjectOne.getCode().compareTo(ObjectTwo.getCode());
    } // end of compareTo()
} // end of class
