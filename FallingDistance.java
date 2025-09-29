//import Scanner
import java.util.Scanner;
/**
 * Program Description
 * 1) Scanner Object is made
 * 2) Asks the user how many seconds they would like to calculate each second of falling distance
 * 3) Displays a chart based on the falling distance formula.
 * 
 * @author Thomas Dang
 * @version v1.0
 * @since 9/28/2025
 */

public class FallingDistance{ //Remove _Starter.
    //public constant for acceleration
    public static final double ACCELERATION = 9.8;  
    public static void main (String[] args) {
        //create Scanner object
        Scanner keyboard = new Scanner(System.in);
        //double var for distance
        double distance;
        //int var for numOfSecs
        int numOfSecs;
        //Display Please enter how many seconds to compute:
        System.out.print("Please enter how many seconds to compute.\n");
        //get input from user for numOfSecs
        numOfSecs = keyboard.nextInt();
        //Display Time(secs) Distance(m) such that the output lines up nicely.  Think escape chars here (ie \t
        //Possibly add ========= under Time and Distance, see Lab5 output example
        System.out.println("Time(s) \t Distance(m)");
        System.out.println("=========   =========");
        //for loop that runs for each second
        for (int i = 1; i <= numOfSecs; i++){
            distance = getDistance(i);
            System.out.printf(i + "\t %.2f \n", distance);
        }
        //  distance is assigned by getDistance() that passes current second from for loop
        //  Display current second and distance with nice formatting (2 dec places for distance).  printf will work well here
    } //end main
    /**
     * 
     * Finds the falling distance for an individual second
     * @param seconds
     * @return fallingDistance
     */
    //Create getDistance header with correct return type and parameter.  Since static method is calling, must be static. Can be public or private
        //the body just needs to be a single statement, a return that calculates distance.  See Lab5 for the formula
    public static double getDistance(int seconds){
        return 0.5*ACCELERATION*Math.pow(seconds, 2);
    }
}//end class