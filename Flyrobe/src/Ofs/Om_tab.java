package Ofs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Om_tab extends Multiple_status{
	
	
public void feasign() throws InterruptedException, IOException
{
	fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\input.txt");
	obj = new Properties();
	obj.load(fileinput);
	String orderid=obj.getProperty("orderid");
	WebDriverWait wait = new WebDriverWait(driver, 100);
	Actions action = new Actions(driver);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Thread.sleep(5000);
	driver.navigate().refresh();
	Thread.sleep(5000);
	WebElement moveonmenu = driver.findElement(By.xpath("id(\"side-menu\")/li[3]/a[1]"));
	action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("id(\"side-menu\")/li[3]/ul[1]/li[1]/a[1]"))).click().perform();
	 driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")));
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")).click();//click Reserve
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();//selectreserve
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//clicked confrim measeured
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[2]/a")));
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[2]/a")).click();//clicked reserve measure
	driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/a")).click();//clicke child city box
	driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.ng-scope.dropdown.open > ul > li:nth-child(2) > a")).click();//clicked child city
	driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
	driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
	driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
	driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
	Thread.sleep(2000);
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html//div[@class='ui-grid-canvas']//div[2]/div[1]")));
	driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[3]/div[1]")).click();
	
	//Craete FE
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Measurement Time & Address ')]")));
	driver.findElement(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Measurement Time & Address ')]")).click();
	driver.findElement(By.xpath("//div[contains(@class,'ibox-content om-address')]/descendant::label[contains(@class,'toggleSwitch-label')]")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div:nth-child(3) > div:nth-child(6) > div.ibox-content.om-address > div:nth-child(5) > div:nth-child(1) > div > div > div > span")));
	driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div:nth-child(3) > div:nth-child(6) > div.ibox-content.om-address > div:nth-child(5) > div:nth-child(1) > div > div > div > span")).click();
	
//	Thread.sleep(500);
	
	WebElement web1=driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[3]/div[6]/div[2]/div[5]/div[1]/div/div/input[1]"));
	web1.sendKeys("Pratik",Keys.ENTER);
	driver.findElement(By.xpath("//span[text()='Create FE Trip']")).click();
	driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();
	Thread.sleep(500);
	//Select FE
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[3]/div[6]/div[2]/div[3]/div[1]/div[4]/div/div/span")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[3]/div[6]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys("Pratik",Keys.ENTER);
	    driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[3]/div[8]/button")).click();
	    driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//dropdown list
		
	//Select Status
	    BufferedReader statusread = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\Status_Selection\\OM_tab_Reserver_Measusring_FE_assign_or_other_status.txt"));
		Scanner console = new Scanner(System.in);

		String statusread1;
		while((statusread1 = statusread.readLine()) != null)
		{
			System.out.println(statusread1);
		
		}
		// select transition 
		System.out.println("Pls Click Enetr to contnue..");
		System.out.println("Please Select Status"+console.nextLine());
		String status=console.nextLine();
	    int statusint =Integer.parseInt(status);
	    switch(statusint)
		{
	    case 1:
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();//Cancelled By Us
	    	break;
	    case 2:
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();//Ready For Option Sharing
	    	break;
	    case 3:
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Measurement'))]")).click();//Out For Measurement
	    	break;
	    case 4://positive flow
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Fitting Expert Assigned'))]")).click();//Fitting Expert Assigned
	    	driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
	    	//Out For Measurnment
	    	Thread.sleep(1000);
	       driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//drop-down list
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Measurement'))]")).click();//'Out For Measurement
	    	driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
	    	Out_For_Measurnment_trasition();//its select a transition after FE expert assign.
	    	Measurnmnet_trasition();//its select a transition after measured 
	    	break;
	    	default:
	    		System.out.println("Not Select any option");
		}
	
	driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
	String currentsttus=driver.findElement(By.xpath("//td[@ng-if='main.fullStatus[item.status]']")).getText();//get current status
	System.out.println("Current Status: "+currentsttus);
	}

public void confrimorder() throws InterruptedException, IOException
{ 
	fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\input.txt");
	obj = new Properties();
	obj.load(fileinput);
	String orderid=obj.getProperty("orderid");
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 100);
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(5000);
	
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")));
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")).click();//click Reserve
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();//selectreserve
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//clicked confrim measeured
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[1]/a")));
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[1]/a")).click();//clicked reserve confrim
	driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/a")).click();//clicke child city box
	driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.ng-scope.dropdown.open > ul > li:nth-child(2) > a")).click();//clicked child city
	driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
	driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[3]/div[1]")).click();
		 driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//dropdown list
		BufferedReader confrimfinaldeliveryafterstatus = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\Status_Selection\\OM_tab_Reserver_Measusring_after_confrimfinaldelivery__or_other_status.txt"));
		Scanner console = new Scanner(System.in);
		String statusread1;
		while((statusread1 = confrimfinaldeliveryafterstatus.readLine()) != null)
		{
			System.out.println(statusread1);
		
		}
		// select transition 
		System.out.println("Pls Click Enetr to contnue..");
		System.out.println("Please Select Status"+console.nextLine());
		String status=console.nextLine();
	    int statusint =Integer.parseInt(status);
	    switch(statusint)
		{
		case 1:
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();//Cancelled By Us
	    	break;
	    case 2:
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Ready For Option Sharing'))]")).click();//Ready For Option Sharing
	    	break;
	    case 3:
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Altered'))]")).click();//Out For Measurement
	    	 driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
	    	after_alterd();
	    	driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();
	    	after_Inqcreserve();
	    	break;
	    	default:
	    		System.out.println("Not Select any Option");    	
	    }
	    driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
		String currentsttus=driver.findElement(By.xpath("//td[@ng-if='main.fullStatus[item.status]']")).getText();//get current status
		System.out.println("Current Status: "+currentsttus);
		}
public void om_logistic() throws IOException, InterruptedException
{
	fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\input.txt");
	obj = new Properties();
	obj.load(fileinput);
	String orderid=obj.getProperty("orderid");
	Actions action = new Actions(driver);
	
//	Thread.sleep(5000);
	WebElement moveonmenu = driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[3]"));
	action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//a[text()='Logistics']"))).click().perform();driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	Thread.sleep(5000);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")));
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")).click();//click Reserve
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();//selectreserve
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//clicked confrim measeured
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[1]/a")).click();//select reserve confrim in house.
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/a")).click();//clicke child city box
		driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.ng-scope.dropdown.open > ul > li:nth-child(2) > a")).click();//clicked child city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
	driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
	driver.findElement(By.xpath("//div[contains(@class,'row')]/descendant::div[contains(@class,'col-lg-6')]/child::button[1]")).click();//click get data button
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[3]")).click();
	//delivery boy assign
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Delivery Time & Address ')]")));
	driver.findElement(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Delivery Time & Address ')]")).click();
	driver.findElement(By.xpath("//div[contains(@class,'ibox-content om-address')]/descendant::label[contains(@class,'toggleSwitch-label')]")).click();
	driver.findElement(By.xpath("//div[@class='ui-select-container ui-select-bootstrap dropdown ng-empty ng-valid']//div[@class='ui-select-match ng-scope']//span[@tabindex='-1']")).click();
	
	driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-address')]/descendant::input[11]")).sendKeys("Pratik",Keys.ENTER);

	driver.findElement(By.xpath("//html//div[@class='ibox-content om-address']/div[@class='row']/div[@class='col-xs-6']/button[1]")).click();
	driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();
	driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-address')]/descendant::span[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[3]/div[6]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys("Pratik",Keys.ENTER);
	 driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//dropdown list
		BufferedReader om_logistic = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\Status_Selection\\OM_tab_Reserver_Measusring_after_package__or_other_status.txt"));
		Scanner console = new Scanner(System.in);
		String statusread1;
		while((statusread1 = om_logistic.readLine()) != null)
		{
			System.out.println(statusread1);
		
		}
		// select transition 
		System.out.println("Pls Click Enetr to contnue..");
		System.out.println("Please Select Status"+console.nextLine());
		String status=console.nextLine();
	    int statusint =Integer.parseInt(status);
	    switch(statusint)
		{
		case 1:
	    	driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Cancelled By Us'))]")).click();//Cancelled By Us
	    	break;
		case 2:
			driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Delivery'))]")).click();//Out For Delivery
	    	break;
		case 3:
			driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Boy Assign'))]")).click();//Delivery Boy Assign
			driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();
			after_delivery_boy_assign();
	    	break;
		case 4:
			driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Delivery Boy Scheduled'))]")).click();//Delivery Boy Scheduled
	    	break;
		case 5:
			driver.findElement(By.xpath(".//option[contains(text(),normalize-space('3pl Delivery Scheduled'))]")).click();//3pl Delivery Scheduled
	    	break;
	    	default:
	    		System.out.println("Not Select any option");
		}
	    driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
		String currentsttus=driver.findElement(By.xpath("//td[@ng-if='main.fullStatus[item.status]']")).getText();//get current status
		System.out.println("Current Status: "+currentsttus);
	
}

public void om_logistic_pickup() throws InterruptedException, IOException
{
	Actions action = new Actions(driver);
	fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\input.txt");
	obj = new Properties();
	obj.load(fileinput);
	String orderid=obj.getProperty("orderid");
	WebElement moveonmenu = driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[3]"));
	action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//a[text()='Logistics']"))).click().perform();driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	Thread.sleep(5000);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")));
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/a")).click();//click Reserve
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[1]/ul/li[1]/a")).click();//selectreserve
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//clicked confrim measeured
	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[2]/ul/li[3]/a")).click();//select reserve pickup in house.
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[4]/a")).click();//clicke child city box
		driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.ng-scope.dropdown.open > ul > li:nth-child(2) > a")).click();//clicked child city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
	driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
	driver.findElement(By.xpath("//div[contains(@class,'row')]/descendant::div[contains(@class,'col-lg-6')]/child::button[1]")).click();//click get data button
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[4]")).click();
	//delivery boy assign
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Pickup Time & Address ')]")));
	driver.findElement(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Pickup Time & Address ')]")).click();
	driver.findElement(By.xpath("//div[contains(@class,'ibox-content om-address')]/descendant::label[contains(@class,'toggleSwitch-label')]")).click();
	driver.findElement(By.xpath("//div[@class='ui-select-container ui-select-bootstrap dropdown ng-empty ng-valid']//div[@class='ui-select-match ng-scope']//span[@tabindex='-1']")).click();
	
	driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-address')]/descendant::input[11]")).sendKeys("Pratik",Keys.ENTER);

	driver.findElement(By.xpath("//html//div[@class='ibox-content om-address']/div[@class='row']/div[@class='col-xs-6']/button[1]")).click();

	driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();
	driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-address')]/descendant::span[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[3]/div[7]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys("Pratik",Keys.ENTER);
	
	after_pickup_boy_assign();//get status from out for pickup
	}	
}
