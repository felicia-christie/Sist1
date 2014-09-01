/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sis1;

import java.util.Scanner;
/**
 *
 * @author SPM
 */
public class Menu {
    public static void display(){
	System.out.println("1. Create room");
	System.out.println("2. Join room");
	System.out.println("3. EXIT");
    }
    
    public static String getName(){
	Scanner S = new Scanner(System.in);
	String Name;
	Name = S.nextLine();
	
	return Name;
    }
    public static int getChoice(){
	Scanner S = new Scanner(System.in);
	int Choice;
	Choice = S.nextInt();
	
	return Choice;
    } 
}
