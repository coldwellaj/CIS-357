/**
 * Homework 5: JavaFx GUI
 * Student Name: Alex Coldwell
 * Course: CIS 357, Winter 2017
 * Instructor: Dr. Cho
 * Date Finished: 04/05/2.017
 * File Name: TotalSale.java
 */


import java.util.ArrayList;

/**
 * This class is made to hold the total number of sales made.
 * 
 * @author Alexander Coldwell
 */
public class TotalSale {
    private String strItems = "";
    private double dblTotal = 0;
    
    /**
     * This method is called when the user made another sale. It adds info
     * about the sale to the strItems String and then adds the sale amount to 
     * dblTotal
     *
     * @param newSales Items sold
     * @param _dblTotal Money earned to add to dbltotal
     */
    public void addSale(String newSales[], double _dblTotal)
    {
        String hold;
        for (int x = 0; x < newSales.length; x++) {
            hold = newSales[x];
            strItems = strItems + hold + "\n";
        }
        dblTotal = dblTotal + _dblTotal;
    }
    
    /**
     * This function returns the strItems string
     *
     * @return strItems
     */
    public String getSales() {
        
        return strItems;
    }
    
    /**
     * This function returns the dblTotal variable
     *
     * @return
     */
    public double getTotalSale() {
        return dblTotal;
    }
}
