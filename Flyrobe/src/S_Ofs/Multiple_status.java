package S_Ofs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Multiple_status extends Configuration_ofs {
	public void Out_For_Measurnment_trasition(String orderid,String measured) throws IOException
	{
		fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
	    obj = new Properties();

		obj.load(fileinput3);
		String statusstring=obj.getProperty("Measured");
		int switch1=Integer.parseInt(obj.getProperty("Manual"));
		driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//drop-down list
		//Select Transition For Out Measurement
		 BufferedReader statusreoutformeasurnment = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Status_Selection\\OM_tab_Reserver_Measusring_outfor_measur__or_other_status.txt"));
			Scanner console1 = new Scanner(System.in);

			String statusread2;
			while((statusread2 = statusreoutformeasurnment.readLine()) != null)
			{
				System.out.println(statusread2);
			
			}
			// select transition 
			
			if(switch1==0)
			{
				 int statusint=Integer.parseInt(measured);
		    switch(statusint)
			{
		        case 1:
		    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();
		    	    break;
		    	case 2:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();
		    		break;
		    	case 3:	
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measured'))]")).click();
		    		
		    		break;
		    		
		    	case 4:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measurement Failed'))]")).click();
		    		break;
		    	default:
	    		System.out.println("Not Select any option");
			}
			}
			else
			{
				System.out.println("Pls Click Enetr to contnue..");
				System.out.println("Please Select Status"+console1.nextLine());
				String status=console1.nextLine();
			    int statusint =Integer.parseInt(status);
			    switch(statusint)
				{
				case 1:
			    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();
			    	    break;
			    	case 2:
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();
			    		break;
			    	case 3:	
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measured'))]")).click();
			    		
			    		break;
			    		
			    	case 4:
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measurement Failed'))]")).click();
			    		break;
			    	default:
		    		System.out.println("Not Select any option");
				}
			}
			driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
			String currentsttus=driver.findElement(By.xpath("//td[@ng-if='main.fullStatus[item.status]']")).getText();//get current status
			System.out.println("Current Status: "+currentsttus);
	}
	
	public void Measurnmnet_trasition(String orderid,String confrim) throws IOException, InterruptedException
	{
		fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
	    obj = new Properties();
		
		obj.load(fileinput3);
	
		int switch1=Integer.parseInt(obj.getProperty("Manual"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//drop-down list
		//Select Transition For Out Measurement
		 BufferedReader Measurnmnet_trasition = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Status_Selection\\OM_tab_Reserver_Measusring_after_measur__or_other_status.txt"));
			Scanner console1 = new Scanner(System.in);

			String statusread2;
			while((statusread2 = Measurnmnet_trasition.readLine()) != null)
			{
				System.out.println(statusread2);
			
			}
			// select transition 
			if(switch1==0)
			{
				 int statusint=Integer.parseInt(confrim);
		    switch(statusint)
		    {
		        case 1:
		    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();
		    	    break;
		    	case 2:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();
		    		break;
		    	case 3:	
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Final Delivery'))]")).click();
		    		
		    		break;
		    		
		    	default:
	    		System.out.println("Not Select any option");
			}
			}
			else
			{
				System.out.println("Pls Click Enetr to contnue..");
				System.out.println("Please Select Status"+console1.nextLine());
				String status=console1.nextLine();
			    int statusint =Integer.parseInt(status);
			    switch(statusint)
				{
				 case 1:
				    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();
				    	    break;
				    	case 2:
				    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();
				    		break;
				    	case 3:	
				    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Final Delivery'))]")).click();
				    		
				    		break;
				    		
				    	default:
			    		System.out.println("Not Select any option");
				}
			    }	
		
	}
	public void after_alterd(String orderid,String iqc) throws IOException
	{

		fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
	    obj = new Properties();	
		obj.load(fileinput3);
		int switch1=Integer.parseInt(obj.getProperty("Manual"));
		driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//drop-down list
		//Select Transition For Out Measurement
		 BufferedReader after_alterd = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Status_Selection\\OM_tab_Reserver_Measusring_after_alteration__or_other_status.txt"));
			Scanner console1 = new Scanner(System.in);

			String statusread2;
			while((statusread2 = after_alterd.readLine()) != null)
			{
				System.out.println(statusread2);
			
			}
			// select transition 
			if(switch1==0)
			{
				 int statusint=Integer.parseInt(iqc);
		    switch(statusint)
		    {
		        case 1:
		    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();
		    	    break;
		    	case 2:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();
		    		break;
		    	case 3:	
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('In Qc Reserve'))]")).click();
		    		
		    		break;
		    		
		    	default:
	    		System.out.println("Not Select any option");
			}
			}
			else
			{
				System.out.println("Pls Click Enetr to contnue..");
				System.out.println("Please Select Status"+console1.nextLine());
				String status=console1.nextLine();
			    int statusint =Integer.parseInt(status);
			    switch(statusint)
				{
				case 1:
			    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();
			    	    break;
			    	case 2:
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();
			    		break;
			    	case 3:	
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('In Qc Reserve'))]")).click();
			    		
			    		break;
			    		
			    	default:
		    		System.out.println("Not Select any option");
				}
			}
	}
	public void after_Inqcreserve(String orderid,String pkd) throws IOException
	{
		fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
	    obj = new Properties();
		obj.load(fileinput3);
		int switch1=Integer.parseInt(obj.getProperty("Manual"));
		driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//drop-down list
		//Select Transition For Out Measurement
		 BufferedReader after_Inqcreserve = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Status_Selection\\OM_tab_Reserver_Measusring_after_Qcreserve__or_other_status.txt"));
			Scanner console1 = new Scanner(System.in);

			String statusread2;
			while((statusread2 = after_Inqcreserve.readLine()) != null)
			{
				System.out.println(statusread2);
			
			}
			// select transition 
			if(switch1==0)
			{
				 int statusint=Integer.parseInt(pkd);
		    switch(statusint)
		    {
		    
		        case 1:
		    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Packaged'))]")).click();
		    	    break;
		    	case 2:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Failed And Ready For Option Sharing'))]")).click();
		    		break;
		    	
		    	default:
	    		System.out.println("Not Select any option");
			}
			}
			else
			{
				System.out.println("Pls Click Enetr to contnue..");
				System.out.println("Please Select Status"+console1.nextLine());
				String status=console1.nextLine();
			    int statusint =Integer.parseInt(status);
			    switch(statusint)
				{
				case 1:
			    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Packaged'))]")).click();
			    	    break;
			    	case 2:
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Failed And Ready For Option Sharing'))]")).click();
			    		break;
			    	
			    	default:
		    		System.out.println("Not Select any option");
				}
			}
	}
	public void after_delivery_boy_assign(String orderid,String dvd) throws IOException, InterruptedException
	{
		fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
	    obj = new Properties();
		obj.load(fileinput3);
		int switch1=Integer.parseInt(obj.getProperty("Manual"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//drop-down list
		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Delivery'))]")).click();//Out For Delivery
		driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
		
		//Select Transition after delivery boy assign
		 BufferedReader after_delivery_boy_assign = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Status_Selection\\OM_logistic_tab_after_delivery_boy_assign.txt"));
			Scanner console1 = new Scanner(System.in);

			String statusread2;
			while((statusread2 = after_delivery_boy_assign.readLine()) != null)
			{
				System.out.println(statusread2);
			
			}
			// select transition 
			if(switch1==0)
			{
				 int statusint=Integer.parseInt(dvd);
		    switch(statusint)
		   
		    {
		        case 1:
		    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivered'))]")).click();//Delivered
		    	    break;
		    	case 2:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Returned'))]")).click();//Returned
		    		break;
		    	case 3:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Reattempt'))]")).click();//Delivery Reattempt
		    		break;
		    	case 4:
		    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Failed'))]")).click();//Delivery Failed
		    		break;
		    	default:
	    		System.out.println("Not Select any option");
			}
			}
			else
			{
				System.out.println("Pls Click Enetr to contnue..");
				System.out.println("Please Select Status"+console1.nextLine());
				String status=console1.nextLine();
			    int statusint =Integer.parseInt(status);
			    switch(statusint)
			    {
			    case 1:
			    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivered'))]")).click();//Delivered
			    	    break;
			    	case 2:
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Returned'))]")).click();//Returned
			    		break;
			    	case 3:
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Reattempt'))]")).click();//Delivery Reattempt
			    		break;
			    	case 4:
			    		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Failed'))]")).click();//Delivery Failed
			    		break;
			    	default:
		    		System.out.println("Not Select any option");
			    }
			}
	}
	
public void after_pickup_boy_assign(String orderid,String piup) throws InterruptedException, IOException
{
	Thread.sleep(1000);
	fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
    obj = new Properties();
	obj.load(fileinput3);
	int switch1=Integer.parseInt(obj.getProperty("Manual"));
driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//drop-down list
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Pickup'))]")).click();//Out For Delivery
driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
BufferedReader after_pickup_boy_assign = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\Status_Selection\\OM_logistic_tab_after_pickup_boy_assign.txt"));
Scanner console1 = new Scanner(System.in);

String statusread2;
while((statusread2 = after_pickup_boy_assign.readLine()) != null)
{
	System.out.println(statusread2);

}
// select transition 
if(switch1==0)
{
	 int statusint=Integer.parseInt(piup);
switch(statusint)

{
case 1:
	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Picked Up'))]")).click();//Picked Up
    break;
case 2:
	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Pickup Reattempt'))]")).click();//Pickup Reattempt
    break;
case 3:
	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Pickup Failed'))]")).click();//Pickup Failed
    break;
}
}
else
{
	System.out.println("Pls Click Enetr to contnue..");
	System.out.println("Please Select Status"+console1.nextLine());
	String status=console1.nextLine();
    int statusint =Integer.parseInt(status);
    switch(statusint) {
    case 1:
    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Picked Up'))]")).click();//Picked Up
        break;
    case 2:
    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Pickup Reattempt'))]")).click();//Pickup Reattempt
        break;
    case 3:
    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Pickup Failed'))]")).click();//Pickup Failed
        break;
    }	
}
driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
}



public void ready_for_option_shairing(String orderid) throws IOException
{
	driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content cc-item')]/descendant::td[11]")).click();//select child option. its select reason.
	BufferedReader ready_for_option_shairing = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\Status_Selection\\Ready_for_option_shairing.txt"));
	Scanner console1 = new Scanner(System.in);

	String statusread2;
	while((statusread2 = ready_for_option_shairing.readLine()) != null)
	{
		System.out.println(statusread2);

	}
	// select transition 
	System.out.println("Pls Click Enetr to contnue..");
	System.out.println("Please Select Status"+console1.nextLine());
	String status1=console1.nextLine();
	int statusint1 =Integer.parseInt(status1);
	switch(statusint1)
	{
case 1:
	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ordered by mistake'))]")).click();//Picked Up
    break;
case 2:
	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Didn't know it was rental'))]")).click();//Pickup Reattempt
    break;
case 3:
	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Event got cancelled'))]")).click();//Pickup Failed
    break;
	}
}
public void ready_for_option_shairing_tab(String orderid) throws IOException, InterruptedException
{
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\input.txt");
	obj = new Properties();
		obj.load(fileinput);
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(5000);
	WebElement moveonmenu = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[4]/a"));
	action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//a[@ui-sref='optionSharing.readyForOptionSharing']"))).click().perform();
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")));
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")).click();//click Reserve
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();//selectreserve
	 driver.findElement(By.xpath("//a[@class='navbar-item dropdown-toggle']")).click();//click status 
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li/a")).click();//select ready for option shairing
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/a")).click();//click on parent
     driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/ul/li[2]/a")).click();//click child cities
     driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
  	driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
  	driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
	driver.findElement(By.xpath("//button[@class='btn btn-primary topnav-btn']")).click();//get data 
	Thread.sleep(1000);
	driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[2]")).click();
	
	 
}
}
