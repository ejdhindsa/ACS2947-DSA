package AssignmentThree.QuestionTwo;

import java.util.Random;

public enum Fare
{
    // instantiating enum values
    FULL("Full", 1),
    DISC("Disc", 2),
    BUDDY("Buddy", 3);

    // instance variables
    private String fareName;
    private int fareCode;

    private Fare(String fareName, int fareCode)
    {
        this.fareName = fareName;
        this.fareCode = fareCode;

    } // end of full-arg constructor

    // ------- ACCESS METHODS ---------

    public int getFareCode() {
        return fareCode;
    } // end of getFareCode()

    public String getFareName() {
        return fareName;
    } // end of getFareName()

    // -------- UTILITY METHOD ----------

    /**
     * Public utility method that returns a random fare type
     * @return random fare type
     */
    public static Fare randomValue()
    {
        Random rnd = new Random();                  // creating a new random for getting a random value
        Fare[] values = Fare.values();              // array to hold all the fair values

        return values[rnd.nextInt(values.length)];

    } // end of randomValue()

    @Override
    public String toString(){
        return fareName;
    } // end of toString()

} // end of Fare
