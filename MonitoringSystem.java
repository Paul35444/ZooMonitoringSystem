/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoringsystem;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author paul3
 */
public class MonitoringSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //set up scanner
        Scanner scnr = new Scanner(System.in);
        //assign each class to call it
        MonitorAnimal animal = new MonitorAnimal();
        MonitorHabitat habitat = new MonitorHabitat();
        
        //set up variables
        String scanChoice = "";
        char userChoice = '1';
        
        //continue the loop while the user does not exit with Q
        while(userChoice != 'Q') {
            System.out.println("");
            System.out.println("Monitoring Options");
            System.out.println("For Animal Monitoring Enter - 1");
            System.out.println("For Habitat Monitoring Enter - 2");
            System.out.println("To Quit - Q");
            System.out.println("");
            System.out.println("Enter option: ");
            
            //get user input
            scanChoice = scnr.nextLine();
            
            /*if user enters nothing loop will continue 
            until something is entered*/
            if(scanChoice.length() > 1) {
                userChoice = '0';
            }
            else {
                //assign userChoice to first character in string
                userChoice = scanChoice.charAt(0);
            }
            
            switch(userChoice) {
                //Call on class monitorAnimal and break 
                //switch so it will not default as well
                case '1':
                    animal.monitorAnimal();
                    break;
                //Call on class monitorHabitat and break 
                //switch so it will not default as well
                case '2':
                    habitat.monitorHabitat();
                    break;
                //Quit if user enters Q and break switch 
                //so it will not default as well
                case 'Q':
                    break;
                //handle anything besides "1,2,Q" as ERRORS
                default:
                    System.out.println("");
                    System.out.println("Error - Enter a valid option");
                    break;
            }
        }
    }
}
