import java.util.ArrayList;
import java.util.Collections;
/**
 * This file contains the TwoDShapesColdwellHW3 class. This class contains
 * the main method to test the ComparableCircle, ComparableTriangle, and the
 * ComparableRectangle classes by placing them in an Array list printing them.
 * Sorting them and then printing them again.
 *
 * @author Alex Coldwell
 */
public class TwoDShapesColdwellHW3 {
    public static void main(String[] args) 
    {
        ArrayList list = new ArrayList();
        
        list.add(new ComparableRectangle(5.1,6.1));
        list.add(new ComparableRectangle(4.1,7.1));
        list.add(new ComparableRectangle(3.2, 8.9));
        list.add(new ComparableTriangle(3.2, 8.9, 5.0));
        list.add(new ComparableTriangle(4.2, 5.0, 1.3));
        list.add(new ComparableTriangle(1.1, 2.2, 3.3));
        list.add(new ComparableCircle(3.9));
        list.add(new ComparableCircle(2.0));
        list.add(new ComparableCircle(2.6));
        
        System.out.println(list);
        System.out.println("");
        
        Collections.sort(list);
        System.out.println(list);
        
        
    }
}
