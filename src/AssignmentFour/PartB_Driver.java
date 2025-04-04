package AssignmentFour;

// import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ACS-2927 | Assignment Four <br>
 * Driver for PartB of the Assignment.
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentFour">GitHub</a>
 */
public class PartB_Driver
{
    public static void main(String[] args)
            throws FileNotFoundException
    {
        // creating an instance of linked chain map
        LinkedChainHashMap<String, PostalCode> postalMap = new LinkedChainHashMap<>();

        // using a method to populate the postalMap
        populatePostalMap(postalMap);

        // printing statements as required
        System.out.println("Total number of entries: " + postalMap.size());
        System.out.println("Number of collisions: " + postalMap.getCollisions());

        // creating comparators for sorting the postalCode
        DefaultComparator<PostalCode> compareByCode= new DefaultComparator<>();
        OrderByLongitude<PostalCode> compareByLongitude = new OrderByLongitude<>();

        // converting postalMap into an array
        PostalCode[] codes = new PostalCode[postalMap.size()];
        int count = 0;

        // iterating through all the postalCodes in the postalMap hash map
        for (PostalCode postalCode : postalMap.values())
        {
            codes[count] = postalCode;
            count++;
        } // end of for

        // printing the postalCode based on the input by the user
        System.out.println("Display by code (C) or Longitude (L) (any other key to quit)");
        Scanner kb = new Scanner(System.in);
        String userInput = kb.next();

        if (userInput.equals("C"))
        {
            QuickSort.quickSortInPlace(codes, compareByCode, 0, codes.length - 1 );

            // printing postalCodes
            for (PostalCode postalCode : codes)
            {
                System.out.println(postalCode);
            } // end of enhanced for
        } // end of if
        else if (userInput.equals("L"))
        {
            QuickSort.quickSortInPlace(codes, compareByLongitude, 0, codes.length - 1);

            // printing postalCodes
            for (PostalCode postalCode : codes)
            {
                System.out.println(postalCode);
            } // end of enhanced for
        } // end of else if
        else {
            System.out.println("Quitting program");
        } // end of else

    } // end of main

    /**
     * Public method that populates the PostalMap by reading in the file from Scanner and then splitting it
     * into an array and adding it to said variables.
     * Therefore, creating an instance of a PostalMap
     * @param postalMap hashmap that is to be populated with the file
     * @throws FileNotFoundException if the file is not found
     */
    public static void populatePostalMap(LinkedChainHashMap<String, PostalCode> postalMap)
            throws FileNotFoundException
    {
        // creating a scanner
        // using the absolute file path since IDEA was giving me trouble
        String filePath = "C:\\Users\\ejdhi\\OneDrive - University of Winnipeg" +
                "\\GitHub\\ACS2947-DSA\\ACS2947-DSA\\src\\AssignmentFour\\PartB.txt";
        Scanner in = new Scanner(new File(filePath));

        while (in.hasNextLine())
        {
            // getting the postal code for every line and splitting it
            String line = in.nextLine();
            String[] parts = line.split(",");

            // setting values
            String code = parts[0].toUpperCase();
            String area = parts[1];
            String province = parts[2];
            double latitude = Double.parseDouble(parts[3]);
            double longitude = Double.parseDouble(parts[4]);

            // creating a new PostalCode object and then adding it to the map
            PostalCode postalCode = new PostalCode(code, area, province, latitude, longitude);
            postalMap.put(code, postalCode);

        } // end of while

    } // end of populatePostalMap

} // end of class
