/**
 * This file contains the GeometricObject Class. The GeometricObject class is
 * an abstract super class for the ComparibleCircle, ComparibleTriangle, and
 * the ComparibleRectangle Classes. The GeometricObject implements the
 * Comparable interface and provides it's subclasses with the generic
 * properties and methods of a basic geometric shape.
 *
 * @author Alex Coldwell;
 */
public abstract class GeometricObject implements Comparable<GeometricObject>{
    
    // Properties
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    // Constructors

    /** Constructs a default Geometric object */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Constructs a default Geometric object with color and filled value
     * 
     * @param color - string to set the color property to
     * @param filled - boolean to set the filled property to
     */
    protected GeometricObject(String color, boolean filled) {
        this.dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    
    // Gets
    /**
     * Returns the color property of the Geometric object
     *
     * @return this.color
     */
    public String getColor(){
        return this.color;
    }
    
    /**
     * Returns the filled property of the Geometric object
     *
     * @return this.filled
     */
    public boolean isFilled(){
        return this.filled;
    }
    
    /**
     * Returns the dateCreated property of the Geometric object
     *
     * @return this.dateCreated
     */
    public java.util.Date getDateCreated(){
        return this.dateCreated;
    }
    
    // Sets
    /**
     * Sets the color property of the Geometric object
     *
     * @param color - string to set the color property to
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * Sets the filled property of the Geometric object
     *
     * @param filled - boolean to set the filled property to
     */
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    // Methods
    @Override
    public String toString(){
        return "Created on " + dateCreated + "\nColor"
                + " and filled: " + filled + " ";
    }
    
    /**
     * Returns the Area of the Geometric object
     *
     * @return double area
     */
    public abstract double getArea();
    
    /**
     * Returns the perimeter of the Geometric object
     *
     * @return double perimeter
     */
    public abstract double getPerimeter();
    
    /**
     * Compares the area of one object to another and returns if the first is
     * less than, greater than, or equal to the second
     *
     * @param o GeometricObject being compared to this
     * @return
     */
    @Override
    public int compareTo(GeometricObject o) {
        if (this.getArea() > o.getArea())
            return 1;
        else if (this.getArea() < o.getArea())
            return -1;
        else
            return 0;
    }
    
}
