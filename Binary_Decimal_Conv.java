
/**
 * This is a menu driven program that prompts the user for input to choose between multiple program options, they can enter "1" 
 * and access a program that converts a decimal number into binary, they can press "2" to gain access to a program that will 
 * convert a binary number into decimal notation, and they can also press "3" to quit. additionally there are added exception
 * handling bits of code to help make the program more stable.
 * 
 * @author (Justin Senia, EID: E00851822) 
 * @version (COSC 221, WINTER 2015, Due 1/15/2015, Lab Assignment#1)
 */
//importing java untility package for scanner class
import java.util.*;
public class Binary_Decimal_Conv
{   
    public static void main (String [] args)
    {
        System.out.println("Student:       Justin Senia");
        System.out.println("Student#:      E00851822");
        System.out.println("CLASS:         COSC 221 WINTER 2015");
        System.out.println("DUE DATE:      1/10/2015");
        System.out.println("Lab:           #1");
        System.out.println("\n");
        
        //Declaring and initializing initial response variables
        String stringResponse = "";
        int intResponse = 0;
        
        //Declaring and initializing decimal to binary variables and arrays
        String decimalInput = "0";
        int[] decimalArray = new int[8];
        
        //Declaring and initializing binary to decimal variables and arrays
        String stringInput = "00000000";
        char[] charArray = new char[8];
        int[] binaryArray = new int[8];
        int[] multArray = new int[8];
        int[] equalsArray = new int[8];
        
        //Declaring and initializing Exception handling variables
        boolean correctMenuInput = false;
        boolean isDecimal = false;
        boolean isBinary = false;
        
        //creating new scanner object
        Scanner keyIn = new Scanner(System.in);
        
        //initializing main loop
        while (intResponse != 3)
        {   
            //resetting all exception handling variables to default values
            isBinary = true;
            isDecimal = true;
            correctMenuInput = true;
            
            //Displaying main menu
            System.out.println("---------------------------------------------------------");
            System.out.println("| Please enter a menu choice...                         |");
            System.out.println("---------------------------------------------------------");
            System.out.println("| Enter the number 1 to convert decimal to binary       |");
            System.out.println("| Enter the number 2 to convert binary to decimal       |");
            System.out.println("| Enter the number 3 to quit                            |");
            System.out.println("---------------------------------------------------------\n");
            System.out.print("Enter your selection now: ");
            
            //Querying user for input/selection
            stringResponse = keyIn.next();
            
            //Exception handling check to make sure response is a 1, 2 or 3
            if (stringResponse.equals("1") || stringResponse.equals("2") || stringResponse.equals("3"))
                correctMenuInput = true;
            else
                correctMenuInput = false;
            
            //Exception handling response when there is an error made in start menu selection
            if (correctMenuInput == false)
            {
               System.out.println("\n**********************************************************");
               System.out.println("Error! Incorrect input! Please enter the number 1, 2 or 3|");
               System.out.println("**********************************************************\n");
            }
            
            else
            {
                //parsing the input from the stringResponse variable to create an integer value to work with
                intResponse = Integer.parseInt(stringResponse);  
                System.out.println();
                
                
                
                
                //Initializing switch with three courses of action, case1: decimal to binary conversion, case2: binary to decimal conversion, case3:quit
                switch(intResponse)
                {
                    //Case1 is a decimal to binary conversion
                    case 1:
                    //querying user for input
                    System.out.print("Please enter a number between 0 and 255:");
                    decimalInput = keyIn.next();
                    System.out.println();
                    
                    //Exception handling, determining if inputted data is the right length
                    if (decimalInput.length() > 3 )
                    isDecimal = false;
                    

                    //Exception handling, Determining if the inputted data is a numerical value
                    String alphaDecCheck = "0";
                    if (isDecimal == true)
                    {
                        for(int q = 0; q < decimalInput.length(); q = q +1)
                        {   
                            //temp variable to be used to use only one digit at a time in the loop
                            alphaDecCheck = decimalInput.substring(q, q+1);
                            
                            if (alphaDecCheck.equals("0") ||
                               alphaDecCheck.equals("1") ||
                               alphaDecCheck.equals("2") ||
                               alphaDecCheck.equals("3") ||
                               alphaDecCheck.equals("4") ||
                               alphaDecCheck.equals("5") ||
                               alphaDecCheck.equals("6") ||
                               alphaDecCheck.equals("7") ||
                               alphaDecCheck.equals("8") ||
                               alphaDecCheck.equals("9") )
                                    isDecimal = true;
                            else
                            {
                                    //breaks if a non-number character is found
                                    isDecimal = false;
                                    break;
                            }
                         }  
                        }
                    
                    //parsing the input from the decimalInput variable to create an integer to work with
                        int decTemp = 0;
                    if (isDecimal == true)
                        decTemp = Integer.parseInt(decimalInput);
                    
                    //exception handling code to determine that the entered value falls within range of desired values
                    if(decTemp < 0 || decTemp > 255)
                        isDecimal = false;
                    
                    //Exception handling response when there is an error made in the decimal number entry
                    if (isDecimal == false)
                    {
                        System.out.println("\n***************************************************");
                        System.out.println("Error! Incorrect input! Returning to start menu...|");
                        System.out.println("***************************************************\n");
                        break;
                    }    
                    
                    //loop that calculates individual digits of binary number and then puts them in a created array named decimalArray[], then divides the original number so calculations can continue 
                    for(int u=7; u >= 0 ; u=u-1)
                    {
                        decimalArray[u] = decTemp%2;
                        decTemp = decTemp/2;
                    }
                    
                    //print statement and loop that will display each member of the array in correct order to create the binary number desired
                    System.out.print("The decimal number \"" + decimalInput + "\" converted into binary is: ");
                    for(int o=0; o < 8 ; o=o+1)
                    {
                        System.out.print(decimalArray[o]);
                    }
                    System.out.println("\n");
                    
                    //ends the case
                    break;
                    
                    
                    
                    //Case2 is a binary to decimal conversion
                    case 2:
                    // initializing variable that will be the sum total of the array elements
                    int total = 0;
                    //querying the user for input
                    System.out.print("Please enter an 8 digit number consisting of only 1's and 0's : ");
                    stringInput = keyIn.next();
                    
                    //Exception handling statement to determine if the length of the inputted data is the correct number of digits
                    if (stringInput.length() !=8)
                        isBinary = false;
                    
                    
                    //Exception handling Loop for validating whether or not all the digits are ones or zeros
                    if (isBinary == true)
                    {
                        for (int n =0; n < 8; n = n+1)
                        {
                            //declaring and initializing a string variable that will be used to test each character found within it individually
                            String testSub = stringInput.substring(n, n+1);
                                 if (testSub.equals("1") || testSub.equals("0"))
                                 {
                                     isBinary = true;
                                 }
                                 //breaks if any number or letter other than 1 or 0 are found
                                 else
                                 {
                                     isBinary = false;
                                     break;
                                 }
                        }
                    }

                    //Exception handling error message that pops up when either alphanumeric characters other than 1 or 0 are entered in. 
                    if (isBinary == false)
                    {
                        System.out.println("\n***************************************************");
                        System.out.println("Error! Incorrect input! Returning to start menu...|");
                        System.out.println("***************************************************\n");
                        break;
                    }

                     
                    //for loop that populates arrays to be used in expression
                    for(int i=0; i<8; i=i+1)
                    {
                        charArray[i] = stringInput.charAt(i);    
                        binaryArray[i] = (charArray[i]-48);
                        multArray[i] = binaryArray[i];
                    }
                    
                    //multiplies the individual array iterations by 2 to the nth number of times depending on numerical array location and adds it back into the original array iteration at the end
                    for (int y=7; y>0; y=y-1)
                    {
                        for (int x=0; x<y; x=x+1)
                        {
                        multArray[x] = multArray[x]*2;
                        }
                    }
                    
                    //multiplies multiplied array interations with corresponding binary values, and then adds them all up
                    for(int l=0; l<8; l=l+1)
                    {
                        equalsArray[l] = multArray[l] * binaryArray[l];
                        total = total + equalsArray[l];
                    }
                    
                    //prints out arrays
                    System.out.println("The number " + stringInput + " converted into decimal notation is: " + total + "\n");
                    break;
                    
                    
                    
                    //displays the text that says the program is ending and ends the main loop, thus ending the program
                    case 3:
                    System.out.println("Terminating program...");
                    break;
                    
                    
                    //default exception catch, just in case previous attempts were unsuccessful, followed by a break 
                    default:
                    System.out.println("\n****************************************************************");
                    System.out.println("Error! Incorrect input! Please enter a number between 1 and 3...|");
                    System.out.println("*****************************************************************\n");
                    break;
                    
                }
            }
        }
    }
}

//****output****
/*
Student:       Justin Senia
Student#:      E00851822
CLASS:         COSC 221 WINTER 2015
DATE:          1/10/2015
Lab:           #1


---------------------------------------------------------
| Please enter a menu choice...                         |
---------------------------------------------------------
| Enter the number 1 to convert decimal to binary       |
| Enter the number 2 to convert binary to decimal       |
| Enter the number 3 to quit                            |
---------------------------------------------------------

Enter your selection now: 1

Please enter a number between 0 and 255:193

The decimal number "193" converted into binary is: 11000001

---------------------------------------------------------
| Please enter a menu choice...                         |
---------------------------------------------------------
| Enter the number 1 to convert decimal to binary       |
| Enter the number 2 to convert binary to decimal       |
| Enter the number 3 to quit                            |
---------------------------------------------------------

Enter your selection now: 2

Please enter an 8 digit number consisting of only 1's and 0's : 11000001
The number 11000001 converted into decimal notation is: 193

---------------------------------------------------------
| Please enter a menu choice...                         |
---------------------------------------------------------
| Enter the number 1 to convert decimal to binary       |
| Enter the number 2 to convert binary to decimal       |
| Enter the number 3 to quit                            |
---------------------------------------------------------

Enter your selection now: 3

Terminating program...
*/
