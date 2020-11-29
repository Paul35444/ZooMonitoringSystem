/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoringsystem;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author paul3
 */
public class MonitorAnimal {
    public void monitorAnimal() throws IOException {
        //initialize scanners
        Scanner scnr = new Scanner(System.in);
        FileInputStream fileByteStream;
        Scanner inFS;
        
        //variables
        String animalChoice;
        char charOption = '0';
        String textLine1, textLine2, textLine3, textLine4, textLine5;
        String errorCheck = "";
        
        //while user does not quit read from file
        while (charOption != 'Q') {
            fileByteStream = new FileInputStream
                ("src\\monitoringsystem\\animals.txt");
            //scanner to read from file
            inFS = new Scanner(fileByteStream);
            
            //display animal options at top of file
            //loop through the animal options (4) and print them out
            int i;
            for(i = 1; i <= 4; ++i) {
                System.out.println(inFS.nextLine());
            }
            
            //display options for user
            System.out.println("");
            System.out.println("Enter Q to return to monitoring options.");
            System.out.println("");
            System.out.println("Enter animal name from above to monitor: ");
            
            //get user input
            animalChoice = scnr.nextLine();
            
            if(animalChoice.length() == 1) {
                //assign charOption to first letter in string
                charOption = animalChoice.charAt(0);
                //close file read if user quits to monitoring options
                if(charOption == 'Q') {
                    fileByteStream.close();
                    break;
                }
                //handle ERRORS and display to user
                else {
                    System.out.println("");
                    System.out.println("*** ERROR - Enter a valid option. ***");
                    System.out.println("");
                    continue;
                }
            }
            
            while(inFS.hasNextLine()) {
                //read lines from file
                textLine1 = inFS.nextLine();
                //check if textLine1 contains the animalChoice string
                if(textLine1.contains(animalChoice)) {
                //assign textLine1 to errorCheck to check user entry(errors)
                    errorCheck = textLine1;
                
                
               //check file lines for alerts and remove *
                textLine2 = inFS.nextLine();
                if(textLine2.contains("*****")) {
                    textLine2 = textLine2.replace("*****", "");
                    openDialogBox(textLine2);
                }
                
                textLine3 = inFS.nextLine();
                if(textLine3.contains("*****")) {
                    textLine3 = textLine3.replace("*****", "");
                    openDialogBox(textLine3);
                }
                
                textLine4 = inFS.nextLine();
                if(textLine4.contains("*****")) {
                    textLine4 = textLine4.replace("*****", "");
                    openDialogBox(textLine4);
                }
                
                textLine5 = inFS.nextLine();
                if(textLine5.contains("*****")) {
                    textLine5 = textLine5.replace("*****", "");
                    openDialogBox(textLine5);
                }
                
                //print out all lines from animals.txt choice
                System.out.println("");
                System.out.println(textLine1);
                System.out.println(textLine2);
                System.out.println(textLine3);
                System.out.println(textLine4);
                System.out.println(textLine5);
                System.out.println("");
                }
            }
            
            //if animalChoice is NOT present show ERROR
            if(!errorCheck.contains(animalChoice)) {
                System.out.println("");
                System.out.println("*** ERROR - Enter valid option. ***");
                System.out.println("");
            }
            //close file reading if ERROR
            fileByteStream.close();
        }
    }
    
    //create and show dialog box with available alerts & OK box
    /*This does not always overlay on NetBeans and 
    may be present somewhere else on the screen*/
    public void openDialogBox(String alert) {
        JOptionPane.showMessageDialog(
                null, 
                alert, 
                "ALERTS",
                JOptionPane.OK_OPTION);
    }
}