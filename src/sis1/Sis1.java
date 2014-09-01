/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sis1;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author waxrain
 */


public class Sis1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	boolean runGame = true;
	
        System.out.print("Input display name : ");
	String name = Menu.getName();
	while (runGame){
	
	// TODO connect to server (DONE?)
    try {
	if (args.length == 2){
	    Connector.Start(args[0], Integer.parseInt(args[1]));
	}
	else{
	    Connector.Start();
	}
	// TODO input mode
	    Connector.Send(name);
	    
	    Menu.display();
	    //System.out.println(Connector.Retrieve().toString());
	    
	    System.out.print("Input choice : ");
	    int C = Menu.getChoice();
	    
	    while (C != 3){
		if (C == 1 || C == 2){
		    if (C == 1){
			//Connector.Send(1);
			// TODO CODE for MAKEROOM
			
		    }
		    else {
			//Connector.Send(2);
			// TODO CODE for DISPLAYROOMS
			
		    }
		// TODO input data
		System.out.println("Input hand;"); 
		System.out.println("1. Rock"); 
		System.out.println("2. Paper"); 
		System.out.println("3. Scissors");
		System.out.print("Your hand is : ");
		
		Scanner Sc = new Scanner(System.in);
		int tempHand = Sc.nextInt();
		
		Connector.Send(tempHand);
		// TODO send hand data 
	        // TODO finish sending hand data
		
		Object Winner = Connector.Retrieve();
		String result = Winner.toString();
		// TODO receive result
		
		if (result.compareTo("LOSE") == 0)
		    System.out.println("You LOSE!");
		else if (result.compareTo("WIN") == 0)
		    System.out.println("You WIN!");
		else if (result.compareTo("DRAW") == 0)
		    System.out.println("DRAW MATCH!");
		else {
		    System.err.print("ERROR: CORRUPTED RESULT.");
		}
	        // TODO finish receive result
	
	        // TODO Display result
		}
		else {
		    System.out.print("Wrong choice, please re-input : ");
		}
		Menu.display();
		C = Menu.getChoice();
	    }
	    runGame = false;
	    Connector.JankenClose();
	    }
	    
	catch (IOException ex){
	    System.out.println("Error in connection...");
	}
	
	}
    }
    
}
