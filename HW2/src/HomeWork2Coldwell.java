// Homework 2: 2D Arrays
// Student Name: Alex Coldwell
// Course: CIS 357, Winter 2017
// Instructor: Dr. Cho
// Date Finnished: 02/13/2017
// Program Description: This program takes a 2D array and tells the user if
// there is 3, 4, or 5 consecutive numbers diagonally, horizantally, and 
// vertically. The program then finds the minSum of all of the consecutive
// numbers in the array.

/**
 *
 * @author Alex Coldwell
 */
public class HomeWork2Coldwell {
      public static String strStart;
      public static String strEnd;
      public static int intMinSum;
      public static int[][] twoDArray1 = {{0,1,0,3,1,6,1}, 
          {0,1,6,8,6,0,1}, {5,6,2,1,8,2,9}, 
          {6,5,6,1,1,9,1}, {1,3,6,1,4,0,7}, 
          {3,3,3,3,4,0,7}};
      public static int[][] twoDArray3 = {{0,1,0,3,1,6,1},
          {0,1,6,8,6,0,1}, {5,6,2,1,6,2,9},
          {6,5,6,6,1,9,1}, {1,3,6,1,4,0,7},
          {3,6,3,9,4,0,7}};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Variable
        int intChoice;
        boolean flag = false;
        java.util.Scanner objInput = new java.util.Scanner(System.in);
        
        // Repeat until the right input is used
        while(flag == false)
        {
            // Prompt user with options and take input
            System.out.println("> java homework2 - Coldwell");
            System.out.print("Enter a choice: (1 for fixed value, 2 for random values)");
            intChoice = objInput.nextInt();
            
            // Procces input
            switch (intChoice) {
                case 1:
                    testWithFixedValues();
                    flag = true;
                    break;
                case 2:
                    testWithRandomValues();
                    flag = true;
                     break;
                default:
                    System.out.println("Wrong input try again");
                    System.out.println();
                    break;
          }
        
        }
          
        
    }
    
    /**
     * Tests the isConsecutiveNum function with a randomly generated array
     * 
     */
    public static void testWithRandomValues()
    {
        // Declar Variables/Objects
        int[][] randomArray;
        int intRow = 0;
        int intColumn = 0;
        int intConsec = 0;
        java.util.Scanner objInput = new java.util.Scanner(System.in);
        
        // Repeat until correct input for row and column
        while((intRow > 10 || intRow < 5) || ( intColumn > 10 || intColumn < 5))
        {
            System.out.print("Enter row and column (5 - 10): ");
            intRow = objInput.nextInt();
            intColumn = objInput.nextInt();
        }
        
        // Create array
        randomArray = generate2DArray(intRow, intColumn);
        
        // Repeat until correct input for consecutive number
        while(intConsec < 3 || intConsec > 5)
        {
            System.out.print("Enter consecutive number (3, 4, 5): ");
            intConsec = objInput.nextInt();
        }
        
        
        
        if (isConsecutiveNum(randomArray, intConsec) == true)
        {
            System.out.println("Consecutive " + intConsec + ": Found " + "(" + strStart + " - " + strEnd + ")");
            printArray(randomArray);
            System.out.println("Minimum Sum: " + intMinSum);
        }
        else
        {
            System.out.println("Consecutive " + intConsec + ": Not Found ");
            printArray(randomArray);
        }
    }
    
    /**
     * Tests the isConsecutiveNum function with two 6 X 7 integer arrays;
     * twoDArray1, and twoDAraay3
     * 
     */
    public static void testWithFixedValues()
    {
        // Print Label
        System.out.println("Fixed Array 1");
        if (isConsecutiveNum(twoDArray1, 4) == true)
        {
            System.out.println("Consecutive four: Found " + "(" + strStart + " - " + strEnd + ")");
            printArray(twoDArray1);
            System.out.println("Minimum Sum: " + intMinSum);
        }
        else
        {
            System.out.println("Consecutive four: Not Found ");
        }
        System.out.println();
        
        // Print Label
        System.out.println("Fixed Array 3");
        if (isConsecutiveNum(twoDArray3, 4) == true)
        {
            System.out.println("Consecutive four: Found " + "(" + strStart + " - " + strEnd + ")");
            printArray(twoDArray1);
            System.out.println("Minimum Sum: " + intMinSum);
        }
        else
        {
            System.out.println("Consecutive four: Not Found ");
        }
    }
    
    /**
     * Checks if a 2D array has any consecutive intNum numbers horizontally,
     * vertically, and diagonally. It then calls functions to find the minSum
     * and start and end locations.
     * 
     * @param intArray
     * @param intNum
     * @return returns a boolean
     */
    public static boolean isConsecutiveNum(int[][] intArray, int intNum)
    {
        boolean boolCheck = false;

        for( int x = 0; x < (intArray.length); x++)
        {
            for(int y = 0; y < (intArray[0].length); y++)
            {
                if ((intArray.length - x) >= intNum && y >= intNum )
                {
                    boolCheck = checkConsectDownLeft(intArray, x, y, intNum);
                    if (boolCheck == true)
                    {
                        sumDownLeft(intArray, x, y, intNum);
                        strStart = "[" + (x) + "," + (y) + "]";
                        strEnd = "[" + (x + (intNum - 1)) + "," + ((y - intNum) + 1) + "]";
                        return boolCheck;
                    }
                }

                if ((intArray.length - x) >= intNum)
                {
                    boolCheck = checkConsectDown(intArray, x, y, intNum);
                    if (boolCheck == true)
                    {
                        sumDown(intArray, x, y, intNum);
                        strStart = "[" + (x) + "," + (y) + "]";
                        strEnd = "[" + (x + (intNum - 1)) + "," + (y) + "]";
                        return boolCheck;
                    }
                }

                if ((intArray.length - x) >= intNum && (intArray[x].length - y) >= intNum)
                {
                    boolCheck = checkConsectDownRight(intArray, x, y, intNum);
                    if (boolCheck == true)
                    {
                        sumDownRight(intArray, x, y, intNum);
                        strStart = "[" + (x) + "," + (y) + "]";
                        strEnd = "[" + (x + (intNum - 1)) + "," + (y + (intNum - 1)) + "]";
                        return boolCheck;
                    }
                }
                if ((intArray[x].length - y) >= intNum)
                {
                    boolCheck = checkConsectRight(intArray, x, y, intNum);
                    if (boolCheck == true)
                    {
                        sumRight(intArray, x, y, intNum);
                        strStart = "[" + (x) + "," + (y) + "]";
                        strEnd = "[" + (x) + "," + (y + (intNum - 1)) + "]";
                        return boolCheck;
                    }
                }
            }
        }
        return boolCheck;
    }
       
    /**
     * Generates a random 2D integer array
     * 
     * @param intM
     * @param intN
     * @return returns a 2D integer array
     */
    public static int[][] generate2DArray(int intM, int intN)
    {
        java.util.Random rnd = new java.util.Random();
        rnd.setSeed(1);

        int[][] randomArray = new int[intM][intN];

        for (int x = 0; x < intM; x++)
        {
            for (int y = 0; y < intN; y++)
            {
                randomArray[x][y] = rnd.nextInt(9);
            }
        }

        return randomArray;
    }
    
    /**
     * Sums up the intNum numbers to the down-left if the current element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     */
    public static void sumDownLeft(int[][] intArray, int x, int y, int intNum)       
    {
        intMinSum = 0;
        // Check for downleft sum
        for( int i = 0; i < intNum; i++ ) 
        {
            intMinSum += intArray[x + i][y - i];
        }
    }
   
    /**
     * Sums up the intNum numbers below the current element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     */
    public static void sumDown(int[][] intArray, int x, int y, int intNum)
    {
        intMinSum = 0;
        // Check for down sum
        for( int i = 0; i < intNum; i++ ) 
        {
            intMinSum += intArray[x + i][y];
        }
    }

    /**
     * Sums up the intNum numbers to the down-right of the current element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     */
    public static void sumDownRight(int[][] intArray, int x, int y, int intNum)
    {
        intMinSum = 0;
        // Check for downright sum
        for( int i = 0; i < intNum; i++ ) 
        {
            intMinSum += intArray[x + i][y + i];
        }
    }

    /**
     * Sums up the intNum numbers to the right of the current element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     */
    public static void sumRight(int[][] intArray, int x, int y, int intNum)
    {
        intMinSum = 0;
        // Check for right sum
        for( int i = 0; i < intNum; i++ ) 
        {
            intMinSum += intArray[x][y + i];
        }
    }

    /**
     * Checks if there are intNum consecutive numbers to the down-left
     * of the current array element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     * @return returns a boolean
     */
    public static boolean checkConsectDownLeft(int[][] intArray, int x, int y, int intNum)
    {
        boolean check = true;

        for (int i = 0; i < (intNum - 1); i++)
        {
            if (intArray[(x + i)][(y - i)] != intArray[(x + i) + 1][(y - i) - 1])
            {
                check = false;
            }  
        }


        return check;
    }

    /**
     * Checks if there are intNum consecutive numbers down
     * from the current array element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     * @return returns a boolean
     */
    public static boolean checkConsectDown(int[][] intArray, int x, int y, int intNum)
    {
        boolean check = true;

        for (int i = 0; i < (intNum - 1); i++)
        {
            if (intArray[(x + i)][(y)] != intArray[(x + i) + 1][(y)])
            {
                check = false;
            }
        }
        return check;
    }

    /**
     * Checks if there are intNum consecutive numbers to the down-right
     * of the current array element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     * @return returns a boolean
     */
    public static boolean checkConsectDownRight(int[][] intArray, int x, int y, int intNum)
    {
        boolean check = true;

        for (int i = 0; i < (intNum - 1); i++)
        {
            if (intArray[(x + i)][(y + i)] != intArray[(x + i) + 1][(y + i) + 1])
            {
                check = false;
            }
        }
        return check;
    }

    /**
     * Checks if there are intNum consecutive numbers to the right
     * of the current array element
     * 
     * @param intArray
     * @param x
     * @param y
     * @param intNum
     * @return returns a boolean
     */
    public static boolean checkConsectRight(int[][] intArray, int x, int y, int intNum)
    {
        boolean check = true;

        for (int i = 0; i < (intNum - 1); i++)
        {
            if (intArray[(x)][(y + i)] != intArray[(x)][(y + i) + 1])
            {
                check = false;
            }
        }
        return check;
    }
    
    /**
     * prints 2D array handed to it
     * 
     * @param intArray
     */
    public static void printArray(int[][] intArray)
    {
        for( int x = 0; x < (intArray.length); x++)
        {
            for(int y = 0; y < (intArray[0].length); y++)
                {
                    System.out.print(intArray[x][y]);
                    System.out.print(" ");
                }
                System.out.println("");
        }
    }
}
