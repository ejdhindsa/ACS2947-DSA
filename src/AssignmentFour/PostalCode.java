package AssignmentFour;

public class PostalCode implements Comparable<PostalCode>
{
    // instance variables
    private String code;
    private String area;
    private String province;
    private double latitude;
    private double longitude;

    /**
     * Constructs a PostalCode with all specified attributes.
     * @param code the postal code (e.g., "A1B 2C3")
     * @param area the geographic area name
     * @param province the province or territory
     * @param latitude the latitude coordinate
     * @param longitude the longitude coordinate
     */
    public PostalCode(String code, String area, String province, double latitude, double longitude)
    {
        this.code = code;
        this.area = area;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;

    } // end of full-arg constructor

    /**
     * Constructs a PostalCode with default unknown values.
     */
    public PostalCode()
    {
        this("UNKNOWN", "UNKNOWN", "UNKNOWN", 0.0, 0.0);
    } // end of no-arg constructor

    // ------------------ ACCESS METHODS ------------------

    /**
     * @return the postal code
     */
    public String getCode() {
        return code;
    } // end of getCode()

    /**
     * @return the geographic area name
     */
    public String getArea() {
        return area;
    } // end of getArea()

    /**
     * @return the province or territory
     */
    public String getProvince() {
        return province;
    } // end of getProvince()

    /**
     * @return the latitude coordinate
     */
    public double getLatitude() {
        return latitude;
    } // end of getLatitude

    /**
     * @return the longitude coordinate
     */
    public double getLongitude() {
        return longitude;
    } // end of getLongitude

    // ----------------- UPDATE METHODS ----------------------

    /**
     * Sets the postal code.
     * @param code the new postal code
     */
    public void setCode(String code) {
        this.code = code;
    } // end of setCode()

    /**
     * Sets the geographic area name.
     * @param area the new area name
     */
    public void setArea(String area) {
        this.area = area;
    } // end of setArea()

    /**
     * Sets the province or territory.
     * @param province the new province
     */
    public void setProvince(String province) {
        this.province = province;
    } // end of setProvince()

    /**
     * Sets the latitude coordinate.
     * @param latitude the new latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    } // end of setLatitude

    /**
     * Sets the longitude coordinate.
     * @param longitude the new longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    } // end of setLatitude

    // ------------- UTILITY METHODS ----------------

    /**
     * Returns a string representation of the PostalCode.
     * @return a formatted string containing all postal code information
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append("PostalCode [code=").append(code).append(", area=").append(area)
                .append(", province=").append(province).append(", latitude=").append(latitude)
                .append(", longitude=").append(longitude).append("]");

        return builder.toString();

    } // end of toString()

    /**
     * Compares this postal code to another for ordering, which is the default ordering,
     * i.e. ordering in the ascending order of the postal code
     * @param other the other PostalCode to compare to
     * @return a negative, zero, or positive integer based on postal code comparison
     */
    @Override
    public int compareTo(PostalCode other)
    {
        return this.code.compareTo(other.getCode());
    } // end of compareTo()

} // end of Postal Code class
