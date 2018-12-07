package Ofs_new;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Run_ofs extends Config_ofs{

	public static void main(String[] args) throws IOException, InterruptedException {
		Config_ofs config=new Config_ofs();
		Ofs_CC_tab ctab=new Ofs_CC_tab();
		Ofs_OM_tab omtab=new Ofs_OM_tab();
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs_new\\Status.txt");
		obj = new Properties();
		obj.load(fileinput);
		String status=obj.getProperty("Status");
		config.Ofs_launch();
		//Measurement Scheduled from cc tab.
		if(status.equalsIgnoreCase("MSL"))
		{
			ctab.cctabdelivery();
			System.out.println("Measurement Scheduled");
	    }
		//Confrim final delivery from om tab
		      else if(status.equalsIgnoreCase("CWM"))
		        {
			
			        ctab.cctabdelivery();
			        omtab.feasign_to_confrimfinaldelivery();
			        System.out.println("Confrim Final Delivery");
			       
		         }
		else
		{
			System.out.println("Pls Select status");
		}
		
	}
	}


