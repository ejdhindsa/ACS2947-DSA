package Lab_Six;

import java.util.Comparator;

/**
 * Ekamjot Singh | 3167888 <br>
 * ACS-2947 Lab Six
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Six">GitHub</a>
 */
public class Month implements Comparable<Month>
{
    // instance variables
    public String monthName;
    public int monthNumber;
    public int days;
    public int workingDays;

    /**
     * Full-argument constructor that creates a month object with the literals as provided
     * in the constructor
     * @param monthName name of the month
     * @param monthNumber month of the year
     * @param days number of days in month
     * @param workingDays number of working days in month
     */
    public Month(String monthName, int monthNumber, int days, int workingDays)
    {
        this.monthName = monthName;
        this.monthNumber = monthNumber;
        this.days = days;
        this.workingDays = workingDays;

    } // end of full-arg constructor

    // ------------- ACCESS METHODS -------------------

    public int getDays() {
        return days;
    } // end of getDays

    public int getMonthNumber() {
        return monthNumber;
    } // end of getMonthNumber

    public int getWorkingDays() {
        return workingDays;
    } // end of get working days

    public String getMonthName() {
        return monthName;
    } // end of getMonthName

    public int freeDays()
    {
        return this.days - this.workingDays;
    } // end of freeDays()

    // ------------- UPDATE METHODS ---------------

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    } // end of setMonthName

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    } // end of setMonthNumber()

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    } // end of setWorkingDays()

    public void setDays(int days) {
        this.days = days;
    } // end of setDays()

    // --------- UTILITY METHODS -------------------

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(monthName).append(" ");
        builder.append(days).append(" ");
        builder.append(workingDays);

        return builder.toString();
    } // end of toString

    /**
     * The comparator defining the ordering of months in the class
     */
    private Comparator<Integer> comp;

    /**
     * Method for comparing two entries in accordance to the month number
     * @param m the second month
     * @return compared int
     */
    public int compareTo(Month m)
    {
        return Integer.valueOf(this.getMonthNumber()).compareTo(m.getMonthNumber());
    } // end of compare

} // end of Month
