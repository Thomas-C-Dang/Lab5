//import Scanner
import java.io.*;  //Note - Since we are using multiple classes from java.io, we can use the * wildcard vs listing each individually.  Any 2+, it is best to use *
import java.util.Scanner;

/**
 * Program Description
 * 1) Fill in steps
 * 
 * @author Name, optional email
 * @version v1.0
 * @since date
 */
public class Grades{ //Remove _Starter.
    public static void main (String[] args) throws IOException{  //look how small main() is when we divide and conquer into (resusable) methods!  Only 4 lines!!!
        //String vars inFile, outFile for the file names
        String inFile, outFile;
        //set inFile using getInFile()
        inFile = getInFile();
        //set outFile using getOutFile()
        outFile = getOutFile();
        //call processFile() with inFile and outFile as arguments
        processFile(inFile, outFile);
    }//end main

    /**
     * Uses Scanner to get and return input file name
     * @return name of file from Scanner  //NOTE - Description only for return
     */
    public static String getInFile(){
        //create String var
        String inFileString;
        //Create Scanner object tied to System.in (ie keyboard) and message to user like-Enter the name of the input file (ie input.txt).  
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of the input file");
        //Assign to String var from above via keyboard.nextLine()
        inFileString = keyboard.nextLine();
        //create File var
        //create a new File object with String var from above as argument and assign to File var from above
        File var = new File(inFileString);
        //create a while loop pit to ensure that file .exists (remember if it exists, you don't need to be in the pit.  Think ! here
        while (!(var.exists())){
            System.out.println("Enter the name of the input file. File not found.");
            inFileString = keyboard.nextLine();
            var = new File(inFileString);
        }
            //repeat message to user like-Enter the name of the input file (ie input.txt).  Assign to String var from above via .nextLine()
            //repeat create a new File object with temp as argument and assign to File var from above
            return inFileString;
        }

        //return String var from above
    
    /**
     * <Put description here-see above as example>
     * <@return - see above as example>
     */
    public static String getOutFile(){ //for getting output file name
    
    //create a method to generate and return a String for the output file name.  
        Scanner keyboard = new Scanner(System.in);
    
    //Create a Scanner object tied to System.in (ie keyboard)
    
        System.out.println("Enter the name of the output file.");
    //Message to user
    
        return keyboard.nextLine();
    //return keyboard.nextLine() 
    }
        
    /**
     * <Put description in here for processFile method.  NOTE can be several lines if necessary
     * <Need to create two @param entry lines>
     */    
    public static void processFile(String input, String output)throws IOException{
        
    
    
    //create a void processFile method with 2 String parameters.  Since working with File, will need throws IOException
        ////vars section
        //int var number to assign from Scanner input
        int number;
        //int var accumulators for As,Bs,Cs,Ds,Fs,min,max
        int As, Bs, Cs, Ds, Fs, min, max;
        //int vars for total,count
        int total, count;
        //double var for avg
        double avg;
        //int var set for each line of grades with 1 assigned
        int set = 1;

        ////Scanner and PrintWriter streams section
        //create File object to create a file from inFileName param
        File inFile = new File(input);
        //create Scanner object with File object from above.  NOTE-You know this will work based on while pit in getInFile()
        Scanner inStream = new Scanner(inFile);
        //create PrintWriter object with inOutFile from method param.  NOTE-PrintWriter creates a new file or overwrites an 
        //    existing file if using FileWriter.
        
        PrintWriter outStream = new PrintWriter(new FileWriter(output));

        //outer while loop to test if Scanner object .hasNextLine()
            while (inStream.hasNextLine()){
            //set As=Bs=Cs=Ds=Fs=count=0 since new line of scores to average
            As=0;
            Bs=0;
            Cs=0;
            Ds=0;
            Fs=0;
            count=0;
            //set average to 0.0 since new line of scores to average
            avg = 0.0;
            //set number var to Scanner object using nextInt() 
            number = inStream.nextInt();
            //set min=max=number
            min=number;
            max=number;
            //set total=count=0
            total=0;
            count=0;
            //inner while loop looking for sentinel (-1).  -1 will cause while loop to stop reading.  Think how you will use ! here
            while (number != -1){
        
            
                if(number < min){
                    //set min to number
                    min = number;
                }
                if (number > max){
                //repeat the same except for max this time 
                    max = number;
                }
                //increment count since you will use this as the denominator to calculate average
                //add number to the total accumulator.  Think += here
                total += number;
                count++;

                //if-else if section to set increment the proper letter grade accumulators
                if(number>=90)
                    As++;
                else if (number>=80){
                    Bs++;
                }
                else if(number >= 70){
                    Cs++;
                }
                else if (number >= 60){
                    Ds++;
                }
                else{
                    Fs++;
                }
                //account for all letter grades

                //need to read in the next number using Scanner object with .nextInt().  You are in a while pit to process each grade for each line
                if (inStream.hasNextInt()){
                    number = inStream.nextInt();
                }
            }//end while
            
            //Write to the PrintWriter object (ie outStream) like you would to the screen (ie .println("Set " + set + " of grades calculated")
            //set++;
            outStream.println("Set " + set + " of grades calculated");
            if (count == 0){
                outStream.println("No grades to average.");
            }
            else{
                //print to PrintWriter object, Number of As: along with the value in the As accumulator
                //repeat above for Bs, Cs,Ds, and Fs
                outStream.println("Number of As: " + As);
                outStream.println("Number of Bs: " + Bs);
                outStream.println("Number of Cs: " + Cs);
                outStream.println("Number of Ds: " + Ds);
                outStream.println("Number of Fs: " + Fs);
                //print to PrintWriter object, The high score was: along with the value in max
                outStream.println("High score was: " + max);
                //repeat above but for min
                outStream.println("Low score was: " + min);
                //compute avg. NOTE-Both total and count are integers.  You will need to cast here (double).
                avg = (double) total/count;
                //print to PrintWriter object, The avg score is: nicely formatted to 1 decimal place
                outStream.printf("The average score is: %.1f%n", avg);
            }//end else
        }//end while for each line
        //message out to the console screen (System.out.println("Grade processing is completed");
        System.out.println("Grade processing is complete");
        //Perhaps a message out to console screen, You can retrieve the output file at, <output file location>
        System.out.println("Retrieve the output file at " + output);
        //close the inStream and outStream using the .close() for each
        inStream.close();
        outStream.close();
    }//end processFile()
}//end Grades class