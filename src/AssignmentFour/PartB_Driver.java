package AssignmentFour;

// import statements
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

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
        System.out.println("Total number of entries" + postalMap.size());
        System.out.println("Number of collisions" + postalMap.getCollisions());

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
        } // end of for

        // printing the postalCode based on the input by the user
        System.out.println("Display by code (C) or Longitude (L) (any other key to quit)");
        Scanner kb = new Scanner(System.in);
        String userInput = kb.next();

        if (userInput.equals("C"))
        {
            QuickSort.quickSortInPlace(codes, compareByCode, 0, codes.length - 1 );

            // printing postalCodes
            System.out.println(Arrays.toString(codes));
        } // end of if
        else if (userInput.equals("L"))
        {
            QuickSort.quickSortInPlace(codes, compareByLongitude, 0, codes.length - 1);

            // printing postalCodes
            System.out.println(Arrays.toString(codes));
        } // end of else if
        else
        {
            System.out.println("Quitting program");
        } // end of else

    } // end of main

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
            String code = parts[0];
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
