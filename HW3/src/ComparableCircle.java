/**
 * This file contains the ComparableCircle Class. The ComparableCircle class in
 * a sub class of the GeomerticObject class. The ComparableCircle provides the
 * properties and methods of a comparable circle.
 *
 * @author Alex Coldwell
 */
public class ComparableCircle extends GeometricObject{

    // Properties
    private double radius;
    
    // Constructors
    /** Constructs a default Circle object */
    public ComparableCircle() {
        super();
        this.radius = 0.0;
    }

    /**
     * Constructs a default Circle object with color, filled, and radius value
     * 
     * @param color - string to set the color property
     * @param filled - boolean to set the filled property
     * @param radius - double to set the radius property 
     */
    public ComparableCircle(String color, boolean filled, double radius) {
        super();
        this.radius = radius;
    }
    
    /**
     * Constructs a default Circle object with radius value
     * 
     * @param radius - double to set the radius property 
     */
    public ComparableCircle(double radius) {
        this.radius = radius;
    }
    
    // Gets
    /**
     * Returns the radius property of the object
     *
     * @return double radius
     */
    public double getRadius() {
        return this.radius;
    }
    
    /**
     * Returns the radius property of the object times 2 to get the diameter
     * 
     * @return double diameter
     */
    public double getDiameter() {
        return (this.radius * 2);
    }
    
    // Sets
    /**
     * Sets the radius property to double radius
     *
     * @param radius - double to set the radius property to
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // Methods
    @Override
    public String toString() {
        return super.toString() + String.format("%1$.2f",this.getArea());
    }
    
    @Override
    public double getArea() {
        double area;
        area = Math.pow(this.radius,2);
        area *= Math.PI;
        
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter;
        perimeter = (this.radius * 2) * Math.PI; 
        
        return perimeter;
    }    
}
