package AssignmentThree.QuestionTwo;

import java.util.Scanner;

public class PartB_Driver
{
    public static void main (String[] args)
    {
        // creating a comparator for the priority queue
        PassengerComparator comparator = new PassengerComparator();

        // creating a HeapPriorityQueue to hold all the passengers
        HeapPriorityQueue<Passenger, String> airlineQueue = new HeapPriorityQueue<>(comparator);

        // public method that populates the arrayQueue
        int numberOfEntries = 10;
        populatePriorityQueue(airlineQueue, numberOfEntries);


        // public method to remove fliers from the arrayQueue
        int numberOfRemovals = 5;
        removeFromPriorityQueue(airlineQueue, numberOfRemovals);

        // adding five more passengers to the queue
        populatePriorityQueue(airlineQueue, 5);

        // removing all the passengers from the queue
        removeFromPriorityQueue(airlineQueue, airlineQueue.size());

    } // end of main

    /**
     * Public static method that removes the said number of fliers from the HeapPriorityQueue
     * @param airlineQueue queue from which fliers are to be removed
     * @param numberOfRemovals number of fliers to be removed
     */
    public static void removeFromPriorityQueue(HeapPriorityQueue<Passenger, String> airlineQueue, int numberOfRemovals)
    {
        int count = numberOfRemovals;

        while(count > 0)
        {
            // getting the passenger at the top of the priority queue
            Passenger passenger = airlineQueue.min().getKey();
            System.out.println(passenger + " gets seatead.");

            // removing the passenger from the priorityQueue
            airlineQueue.removeMin();

            // printing the current list
            System.out.println("Standby list: " + airlineQueue);
            System.out.println();

            count--;                // decreasing count by one
        } // end of while

    } // end of removeFromPriorityQueue()

    /**
     * Public method that adds passengers to the HeapPriorityQueue
     * @param airlineQueue the queue to which passengers are to be added
     * @param numberOfEntries number of passengers to be added
     */
    public static void populatePriorityQueue(HeapPriorityQueue<Passenger, String> airlineQueue, int numberOfEntries)
    {
        // variables required to fill the queue
        int count = numberOfEntries;
        Scanner kb = new Scanner(System.in);
        String passportNumber;

        // starting a while loop that runs ten times so that 10 passengers can be added to the list
        while (count > 0)
        {
            System.out.print("Enter passport no of new passenger: ");
            passportNumber = kb.next();

            Passenger newPassenger = new Passenger(passportNumber);
            System.out.println("Adding Passenger: " + newPassenger);
            airlineQueue.insert(newPassenger, passportNumber);

            System.out.println("Standby list: " + airlineQueue);
            System.out.println();

            count--;                // decreasing count by one
        } // end of while

    } // end of populatePriorityQueue

} // end of class
