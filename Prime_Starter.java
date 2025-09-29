//import Scanner and/or JOptionPane
import java.util.Scanner;
/**
 * Program Description
 * 1) Scanner object is made
 * 2) Asks the user for a number greater than 2
 * 3) Tests to see if the number is prime
 * 4) Displays the result
 * 5) Asks if they want to go again
 * 
 * @author Thomas Dang
 * @version v1.0
 * @since 9/28/2025
 */
public class Prime_Starter{ //Remove _Starter.
    public static void main (String[] args) {
        //boolean var isPrime
        boolean isPrime;
        //int var number            //original number to test
        int number; 
        //String var playAgain      //string to test to calc another number
        String playAgain;
        do{ //get program working first and then incorporate do while to play again
            //Display message to user, something like Enter a whole number>2 (ie 19) to test if prime
            
            //Create a Scanner object or JOptionPane to get user input and assign to number '
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a whole number greater than 2, to see if it's a prime number.");
            number = keyboard.nextInt();
            //set isPrime to the result of testForPrime(number)
            isPrime = testForPrime(number);
            //if else to test if isPrime.  Display number and whether prime.
            if (isPrime){
                System.out.println(number + " is prime.");
            }
            else{
                System.out.println(number + " is not prime.");
            }
            
            //Display message to test another number, something like Enter yes to test another number, no to quit
            //set playAgain to user choice    
            System.out.println("Do you want to calculate another number? Say yes or no.");
            playAgain = keyboard.next();
            
        }while(playAgain.equalsIgnoreCase("yes"));
    }//end main

    /**
     * 
     * Finds out if a number is a prime number or not.
     * @param number
     * @return whether or not the number is prime.
     */
    //write header here for testForPrime.  Can be public or private, but needs to be static.  Return type? Needs 1 param
        //int var inNumberSqRt   //gets input from user and takes square root.  this shortens the testing and makes more efficient
        //set inNumberSqRt to (int)Math.sqrt(param var).  NOTE:We need to cast as an int.
        //boolean var isPrimeMeth set to true, assumes number is prime
    public static boolean testForPrime(int num){
        int inNumberSqRt = (int)Math.sqrt(num);
        boolean isPrimeMeth = true;
        for(int i=2;isPrimeMeth&&i<=inNumberSqRt;i++){  //declare and set int var to 2  //Can start here vs 1 for one less run
           //create an if to see if inNumber is divisible by i
           if (num % i == 0){
               isPrimeMeth = false;
           }
                //if true set isPrimeMeth=?
        }
        return isPrimeMeth;
    }//end testForPrime
}//end Prime