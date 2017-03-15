/**
 * This file contains the ComparableTriangle Class. The ComparableTriangle
 * class is a sub class of the GeomerticObject class. The ComparabTriangle
 * provides the properties and methods of a comparable Triangle.
 *
 * @author Alex Coldwell
 */
public class ComparableTriangle extends GeometricObject{

    // Propertes
    private double sideA;
    private double sideB;
    private double sideC;
    
     // Contructors
    /** Constructs a default Rectangle object */
    public ComparableTriangle() {
        super();
        this.sideA = 0.0;
        this.sideB = 0.0;
        this.sideC = 0.0;
    }

    /**
     * Constructs a default Triangle object with color, filled, sideA,
     * sideB, and sideC value
     * 
     * @param color - string to set the color property
     * @param filled - boolean to set the filled property
     * @param sideA - double to set the sideA property
     * @param sideB - double to set the sideB property
     * @param sideC - double to set the sideC property
     */
    public ComparableTriangle(String color, boolean filled,
            double sideA, double sideB, double sideC) {
        super();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    /**
     * Constructs a default Triangle object with sideA, sideB, and sideC value
     * 
     * @param sideA - double to set the sideA property 
     * @param sideB - double to set the sideB property
     * @param sideC - double to set the sideC property
     */
    public ComparableTriangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    // Gets
    /**
     * Returns the sideA property of the object
     *
     * @return double sideA
     */
    public double getSideA() {
        return this.sideA;
    }
    
    /**
     * Returns the sideB property of the object
     *
     * @return double sideB
     */
    public double getSideB() {
        return this.sideB;
    }
    
    /**
     * Returns the sideC property of the object
     *
     * @return double sideC
     */
    public double getSideC() {
        return this.sideC;
    }
    
    // Sets
     /**
     * Sets the sideA property to double sideA
     *
     * @param sideA - double to set the sideA property
     */
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    
     /**
     * Sets the sideB property to double sideB
     *
     * @param sideB - double to set the sideB property
     */
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    
     /**
     * Sets the sideC property to double sideC
     *
     * @param sideC - double to set the sideC property
     */
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    
    // Methods
    @Override
    public String toString() {
        return super.toString() + String.format("%1$.2f",this.getArea());
    }
    
    @Override
    public double getArea() {
        double area;
        double s;
        s = (sideA + sideB + sideC)/2;
        area = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
        return area;
    }

    @Override
    public double getPerimeter() {
        return (sideA + sideB + sideC);
    }
    
}
