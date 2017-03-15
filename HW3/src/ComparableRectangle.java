/**
 * This file contains the ComparableRectagle Class. The ComparableRectangle
 * class is a sub class of the GeomerticObject class. The ComparabRectangle
 * provides the properties and methods of a comparable Rectangle.
 *
 * @author Alex Coldwell
 */
public class ComparableRectangle extends GeometricObject {
    // Properties
    private double height;
    private double width;
    
    // Contructors
    /** Constructs a default Rectangle object */
    public ComparableRectangle() {
        super();
        this.height = 0.0;
        this.width = 0.0;
    }

    /**
     * Constructs a default Rectangle object with color, filled, height,
     * and width value
     * 
     * @param color - string to set the color property to
     * @param filled - boolean to set the filled property to
     * @param height - double to set the height property to 
     * @param width - double to set the width property to
     */
    public ComparableRectangle(String color, boolean filled,
            double height, double width) {
        super();
        this.height = height;
        this.width = width; 
    }
    
    /**
     * Constructs a default Rectangle object with height, and width value
     * 
     * @param height - double to set the height property 
     * @param width - double to set the width property
     */
    public ComparableRectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    
    // Gets

   /**
     * Returns the height property of the object
     *
     * @return double height
     */
    public double getHeight() {
        return this.height;
    }
    
    /**
     * Returns the width property of the object
     *
     * @return double width
     */
    public double getWidth() {
        return this.width;
    }
    
    // Sets
    /**
     * Sets the height property to double height
     *
     * @param height - double to set the height property
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     * Sets the width property to double width
     *
     * @param width - double to set the width property
     */
    public void setWidth(double width) {
        this.width = width;
    }
    
     // Methods
    @Override
    public String toString() {
        return super.toString() + String.format("%1$.2f",this.getArea());
    }
    
    @Override
    public double getArea() {
        double area;
        area = this.height * this.width;
        
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter;
        perimeter = (this.height * 2) + (this.width * 2); 
        
        return perimeter;
    }
}
