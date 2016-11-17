/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.util.Scanner;

/**
 *
 * @author: Dominic Lewis 
 * Date Created: 20161117
 * Purpose: Checks the student roll to be valid against a format 
 */
public class CheckStudentRoll {

    public static void main(String[] args) {

        String studentRoll = getStringInput();
        System.out.println("Student Roll:" + studentRoll);

    }

    //This method gets the input for the roll
    public static String getStringInput() {
        //Create an instance of scanner for the string input
        Scanner stringScan = new Scanner(System.in);
        String userEntry = "";
        boolean valid = false;
        int validCount = 0;
        //Loop for the input
        do {
            //Error Report
            if (validCount > 0) {
                System.out.println("Invalid roll or format");
            }
            //Prompt and get input
            System.out.println("Enter roll number:(DD-DDD-DDDDD)");

            userEntry = stringScan.next();
            //check if the string is valid
            valid = validateString(userEntry);
            //Increment the validation count
            validCount++;

        } while (valid == false);

        return userEntry;
    }

    //This function will validate the string and return true if the string is valid 
    public static boolean validateString(String userEntry) {

        boolean valid = false;
        //set the string to be an array 
        char[] userEntryArray = userEntry.toCharArray();
        int[] numbers = new int[12]; //create space for the int array 
        int length = userEntry.length(); //Get length of the usersEntry

        //validate the length
        if (length == 12) {
            valid = true;
        }

        //if the length is valid then check the content of string by turning the numbers into ints 
        if (valid == true) {
            for (int i = 0; i < length; i++) {
                //Check if the int positions are correct 
                if ((i == 0) || (i == 1) || (i == 3) || (i == 4) || (i == 5) || (i == 7) || (i == 8) || (i == 9) || (i == 10) || (i == 11)) {
                    //conver the char from the userEntry to an int in a different int array
                    numbers[i] = Character.getNumericValue(userEntryArray[i]); //returns ascii value of the char

                    //check if the number is a valid number 
                    if (((numbers[i] >= 0) && (numbers[i] <= 10) && valid == true)) {
                        valid = true;
                    } else {
                        valid = false;
                    }

                }//end if 
                //check the hyphens have been input
                else if ((valid == true) && (userEntryArray[i] == '-')) {
                    valid = true;
                } else {
                    valid = false;
                }// end else 

            }//end for 

        }//end if  

        return valid;
    }
}
