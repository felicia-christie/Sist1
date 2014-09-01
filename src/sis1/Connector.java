/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sis1;

import java.io.*;
import java.net.*;

/**
 *
 * @author SPM
 */
public class Connector {
    public static ObjectInputStream inStream;
    public static ObjectOutputStream outStream;
    public static String address = "localhost";
    public static int port = 46464;
    public static Socket jankenSocket = null;
    
    public static void Start(String add, int inPort){	
	try{
	    jankenSocket = new Socket(add, inPort);
	    jankenSocket.setSoTimeout(5000);
	    inStream = new ObjectInputStream(jankenSocket.getInputStream());
	    outStream = new ObjectOutputStream(jankenSocket.getOutputStream());
		
	}
	catch (IOException ex){
	    System.out.println(ex);
	}
    }
    
    public static void Start(){
	try{
	    jankenSocket = new Socket(address, port);
	    jankenSocket.setSoTimeout(5000);
	    inStream = new ObjectInputStream(jankenSocket.getInputStream());
	    outStream = new ObjectOutputStream(jankenSocket.getOutputStream());
	    
	}
	catch(IOException ex){
	    System.out.println(ex);
	}
    }
    
    public static void Send(Object X) throws IOException{
	outStream.writeObject(X);
	outStream.flush();
	outStream.reset();
	
    }
    
    public static Object Retrieve() throws IOException{
	try {
	    return inStream.readObject();
	}
	catch (ClassNotFoundException ex){
	    return null;
	}
    }
    
    public static void JankenClose() throws IOException{
	try{
	    outStream.close();
	    inStream.close();
	    jankenSocket.close();
	}
	catch (IOException ex){
	}
    }
}
