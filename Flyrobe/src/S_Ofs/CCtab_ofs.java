package S_Ofs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CCtab_ofs extends Multiple_status{
	public void cctabdelivery(String orderid,String CCtab)throws InterruptedException, IOException
	{
		Actions action = new Actions(driver);
	  //driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//click order button cc tab
		WebDriverWait wait = new WebDriverWait(driver, 20);
		fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
	    obj = new Properties();
		obj.load(fileinput3);
		int switch1=Integer.parseInt(obj.getProperty("Manual"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")));
		 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")).click();//click Reserve
		 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();//selectreserve
         driver.findElement(By.cssSelector("li.dropdown:nth-child(2) > a:nth-child(1)")).click();//click on order
         driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[1]/a")).click();//click on placed reserved.
         driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/a")).click();//click on parent
         driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/ul/li[2]/a")).click();//click child cities
         driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
     	driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::button[contains(@class,'btn btn-primary m-t-7')]")).click();//get data 
		Thread.sleep(1000);
		
       driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[2]/div[1]")).click();//click on table
	driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content cc-item')]/descendant::td[9]")).click();//dropdown list
	BufferedReader statusread = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Status_Selection\\CC_tab_Place_Reserve.txt"));
	Scanner console = new Scanner(System.in);

	String statusread1;
	while((statusread1 = statusread.readLine()) != null)
	{
		System.out.println(statusread1);
	
	}
	if(switch1==0)
	{
		 int statusint=Integer.parseInt(CCtab);
    switch(statusint)
	{
	case 1:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measurement Scheduled From Placed'))]")).click();//Measurement Scheduled From Placed
break;
	case 2:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Online Measurement'))]")).click();//Confirm For Online Measurement
break;
	case 3:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Final Delivery'))]")).click();//Confirm For Final Delivery
break;
	case 4:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm W/o Measurement For Repeat'))]")).click();//Confirm W/o Measurement For Repeat
break;
	case 5:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Future Measurements'))]")).click();//Future Measurements
break;
	case 6:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();//Cancelled By Us
driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content cc-item')]/descendant::td[11]")).click();//select child option. its select reason.
break;
	case 7:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();//Ready For Option Sharing
//ready_for_option_shairing();
driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'col-lg-12')]/child::button[contains(@class,'btn btn-primary btn-block')]")).click();//click submit button
//ready_for_option_shairing_tab();
break;
	default:
	System.out.println("Not Choose Any Option ");
	
   }	
	
}
	else 
{
	System.out.println("Pls Click Enetr to contnue..");
	System.out.println("Please Select Status"+console.nextLine());
	String status=console.nextLine();
    int statusint =Integer.parseInt(status);
    switch(statusint)
	{
	case 1:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measurement Scheduled From Placed'))]")).click();//Measurement Scheduled From Placed
break;
	case 2:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Online Measurement'))]")).click();//Confirm For Online Measurement
break;
	case 3:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Final Delivery'))]")).click();//Confirm For Final Delivery
break;
	case 4:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm W/o Measurement For Repeat'))]")).click();//Confirm W/o Measurement For Repeat
break;
	case 5:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Future Measurements'))]")).click();//Future Measurements
break;
	case 6:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();//Cancelled By Us
driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content cc-item')]/descendant::td[11]")).click();//select child option. its select reason.
break;
	case 7:
driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();//Ready For Option Sharing
//ready_for_option_shairing();
driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'col-lg-12')]/child::button[contains(@class,'btn btn-primary btn-block')]")).click();//click submit button
//ready_for_option_shairing_tab();
break;
	default:
	System.out.println("Not Choose Any Option ");
	
   }	

}
	driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'col-lg-12')]/child::button[contains(@class,'btn btn-primary btn-block')]")).click();
	String currentsttus=driver.findElement(By.xpath("//td[@ng-if='main.fullStatus[item.status]']")).getText();//get current status
	System.out.println("Current Status: "+currentsttus);
}
	
	
	
	
	public void cctab_pickup(String orderid,String psd) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		fileinput3=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\Switch\\switch.txt");
	    obj = new Properties();
		obj.load(fileinput3);
	
		int switch1=Integer.parseInt(obj.getProperty("Manual"));
		driver.findElement(By.xpath("//a[@ui-sref='tables.customerCare']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")));
			 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")).click();//click Reserve
			 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();//selectreserve
			 driver.findElement(By.cssSelector("li.dropdown:nth-child(2) > a:nth-child(1)")).click();//click on order
	         driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[2]/a")).click();//click on Pickup reserved.
	         driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/a")).click();//click on parent
	         driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/ul/li[2]/a")).click();//click child cities
	         driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
	     	driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::button[contains(@class,'btn btn-primary m-t-7')]")).click();//get data 
			Thread.sleep(1000);
			driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[2]")).click();
			driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content cc-item')]/descendant::td[9]")).click();//dropdown list
			BufferedReader Pickup_Reserve = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Status_Selection\\CC_tab_Pickup_Reserve.txt"));
			Scanner console = new Scanner(System.in);

			String statusread1;
			while((statusread1 = Pickup_Reserve.readLine()) != null)
			{
				System.out.println(statusread1);
			
			}
			// select transition 
			if(switch1==0)
			{
				 int statusint=Integer.parseInt(psd);
		    switch(statusint)
			{
			       case 1:
				driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Pickup Scheduled'))]")).click();//Pickup Scheduled
				break;
					case 2:
				driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Return Initiated'))]")).click();//Return Initiated
				break;
					case 3:
				driver.findElement(By.xpath(".//option[contains(text(),normalize-space('3pl Pickup Scheduled'))]")).click();//3pl Pickup Scheduled
				break;
					default:
						System.out.println("Not Choose Any Option ");
			}
			}
			else
			{
				System.out.println("Pls Click Enetr to contnue..");
				System.out.println("Please Select Status"+console.nextLine());
				String status=console.nextLine();
			    int statusint =Integer.parseInt(status);
			    switch(statusint)
				{
				  case 1:
						driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Pickup Scheduled'))]")).click();//Pickup Scheduled
						break;
							case 2:
						driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Return Initiated'))]")).click();//Return Initiated
						break;
							case 3:
						driver.findElement(By.xpath(".//option[contains(text(),normalize-space('3pl Pickup Scheduled'))]")).click();//3pl Pickup Scheduled
						break;
							default:
								System.out.println("Not Choose Any Option ");	
				}
			}
			driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'col-lg-12')]/child::button[contains(@class,'btn btn-primary btn-block')]")).click();
			String currentsttus=driver.findElement(By.xpath("//td[@ng-if='main.fullStatus[item.status]']")).getText();//get current status
			System.out.println("Current Status: "+currentsttus);
	}

}
