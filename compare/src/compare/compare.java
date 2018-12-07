package compare;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class compare {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\flyrobe_web\\src\\flyrobe_web\\Address.txt");
		Scanner mumbaipin=new Scanner("C:\\Users\\hp\\eclipse-workspace\\flyrobe_web\\src\\flyrobe_web\\mumbaipin.txt");
		obj.load(objfile);
		String s="400072";
		//obj.load(mumbaipin);
		
		// List<String> list=new ArrayList<>();
		// while(mumbaipin.hasNextLine()){
		     //list.add(mumbaipin.nextLine()); 
		     if(mumbaipin.equals(s))
		     {
		    	 System.out.println("yes");
		    	 
		     }
		     else
		    	 System.out.println("no");

		 }
		
	}


