package Mobile_Web_Flyrobe;

import static org.testng.Assert.expectThrows;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flyrobe_mobile_config {
	public static WebDriver driver;
	public static FileInputStream fileinput=null;
	public static Properties obj=null;
	
	@BeforeTest
	public void mobile_config() throws IOException, InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	Map<String, String> maprevolution= new HashMap<String, String>();
	maprevolution.put("deviceName", "Nexus 5");
	
	//or
//	Map<String,Object> maprevolution=new HashMap<String,Object>();
//	maprevolution.put("Width", 375);
//	maprevolution.put("height", 667);
//	maprevolution.put("pixelRatio", 4.0);
	Map<String,Object> maprevolution1=new HashMap<String,Object>();
	maprevolution1.put("mobileEmulation", maprevolution);
	
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	capabilities.setCapability(ChromeOptions.CAPABILITY, maprevolution1);
	
     driver = new ChromeDriver(capabilities);
    
     driver.manage().window().maximize();
	driver.get("http://flyrobe.com");
	obj = new Properties();
	String DATE,MONTH,finalDate;
	//FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\Address.txt");
	fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\Address.txt");
	obj.load(fileinput);
	String city=obj.getProperty("city");
	WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
	web1.sendKeys(city,Keys.ENTER);
	
	Thread.sleep(5000);
	
	}
	@Test
	public void date() throws InterruptedException, IOException
	{
		int i;
		 Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),normalize-space('Women'))]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("id(\"mdl-js-layout\")/descendant::div[contains(@class,'mdl-grid mdl-grid--no-spacing ng-scope')]/descendant::a[1]/child::img[1]")));
		driver.findElement(By.xpath("id(\"mdl-js-layout\")/descendant::div[contains(@class,'mdl-grid mdl-grid--no-spacing ng-scope')]/descendant::a[1]/child::img[1]")).click();
		//list page
		Thread.sleep(5000);	
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
	
		
		List<WebElement> itemselect=driver.findElements(By.xpath("//div[contains(@id,'focusDiv')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col mdl-cell--2-col-phone mdl-cell--4-col-tablet medium-font ng-scope')]"));
		
		System.out.println(itemselect.size());
		for(i=0;i<itemselect.size();i++)
		System.out.println(itemselect.get(i).getText());
		if(itemselect.size()==i)
		{
			
			System.out.println(itemselect.get(2).getAttribute("!product.is_on_sale"));
			itemselect.get(3).click();
		}
		else
			System.out.println("Data not found");
		
		//details page
		Thread.sleep(2000);
		driver.navigate().refresh();
	       Thread.sleep(15000);
	       
	       WebElement element = driver.findElement(By.xpath("id(\"addToWish\")"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	       
	       WebElement moveonmenu = driver.findElement(By.xpath("id(\"datetimepicker\")/input[1]"));
			action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("id(\"datetimepicker\")/input[1]"))).click().perform();
			String DATE,MONTH,finalDate;
			Thread.sleep(1000);
			Boolean datenotfound = true;
			int MONTH1;
			while (datenotfound) {
				List<WebElement> enableDate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]"));
				
				if (enableDate.size() > 0) 
				{
					DATE = enableDate.get(0).getAttribute("data-date");
					if(DATE.length() == 1)
					DATE = "0" + DATE;
						
					MONTH1 = Integer.parseInt(enableDate.get(1).getAttribute("data-month")) + 1;
					MONTH = "" + MONTH1;
					if (MONTH.length() == 1)
						MONTH = "0" + MONTH;
					
					
					finalDate = enableDate.get(0).getAttribute("data-year") + "-" + MONTH + "-" + DATE;
					System.out.println("finaldate"+finalDate);
					
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")));
					
					driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")).click();
					datenotfound = false;
					Thread.sleep(3000);				
				} else {
					driver.findElement(By.cssSelector(".xdsoft_next")).click();
					Thread.sleep(3000);			
				}
	
			}
			driver.findElement(By.xpath("//button[contains(text(),normalize-space('ADD TO CART'))]")).click();
			Thread.sleep(2000);
			//cart page
			driver.findElement(By.xpath("//div[contains(@class,'main-content cart-sectionp pb-0 ng-scope')]/descendant::div[contains(@class,'mdl-grid standard-width')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col  mdl-cell--8-col-tablet mdl-cell--4-col-phone')]/descendant::div[contains(@class,'coupon-cart-place-order-btn text-center width100 mt-20 couponButtonM1 ng-scope')]/child::a[1]")).click();
			//gmail login
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div:nth-child(2) > button")));
			driver.findElement(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div:nth-child(2) > button")).click();
			//Focus on second window
			String parentHandle = driver.getWindowHandle();
			System.out.println("First Window"+parentHandle);
			driver.findElement(By.xpath(".//button[contains(@class,'btn btn-medium google-btn text-white letter-spacing05 position-relative ng-scope')]")).click();//click google login
			for(String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			//Login 
			System.out.println("Login Start....");
		   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();//clear text box
		   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("pepark619");// enetr email
		   driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#identifierNext > div.ZFr60d.CeoRYc")));	
		   String str1=driver.findElement(By.id("identifierNext")).getText();
		   System.out.println("Button"+str1);
		   driver.findElement(By.id("identifierNext")).click();//clcik next
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
		   driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).clear();// clear text box
		   driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("peterpark619");// enter password
		   driver.findElement(By.id("passwordNext")).click();// click login
		   System.out.println("Login Done....");
		   Thread.sleep(2000);
		   //driver.close();
		    driver.switchTo().window(parentHandle);
		    
	    driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]")).click();//close login window
		    
		    //checkout page

			Properties obj = new Properties();
			FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\Address.txt");
			obj.load(objfile);
			String name=obj.getProperty("name");
			String mail=obj.getProperty("mail");
		    String mobile=obj.getProperty("mobile");
			String pin=obj.getProperty("pin");
			String address=obj.getProperty("address");
			//add pin code
			BufferedReader pincoderead = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\flyrobe_web\\src\\flyrobe_web\\mumbaipin.txt"));
			String pincodeinsertinlist;

			List<String> list = new ArrayList<String>();
			while((pincodeinsertinlist = pincoderead.readLine()) != null){
			    list.add(pincodeinsertinlist);
			}
	         System.out.println(list);
	         //add address
	         Thread.sleep(5000);
	         WebElement element1 = driver.findElement(By.id("addressButton"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
		    driver.findElement(By.id("addressButton")).click();
		    Thread.sleep(1000);
		    if(name.length()>0)
			{
	    	   driver.findElement(By.id("name")).clear();
			   driver.findElement(By.id("name")).sendKeys(name);
			}
		    else
		    	   System.out.println("Name Not Correct");
		    
		    if(mail.endsWith(".com"))
	        {	
	  	        driver.findElement(By.id("mail")).clear();
	   	        driver.findElement(By.id("mail")).sendKeys(mail);
	          }
	        else {
	         System.out.println("Mail Not Corret");
	        driver.close();
	        }
		    
		    if(mobile.length()==10)
		      {	
			   driver.findElement(By.id("phone")).clear();
		       driver.findElement(By.id("phone")).sendKeys(mobile);
		      }
		    else {
				   System.out.println("Phone not valid");
		    driver.close();
		    }
		   
		    if(list.contains(pin))
			  {
		        	 driver.findElement(By.id("pincode")).clear();
		            driver.findElement(By.id("pincode")).sendKeys(pin);
			  }
		    else {
		    System.out.println("Pin Not Corect");
		    driver.close();
		    }
		    if(address.length()>0)
	        {
	 	     driver.findElement(By.id("flat")).clear();
	         driver.findElement(By.id("flat")).sendKeys(address);
	         
	       }
	        else 
	         
	        System.out.println("Address Not Correct");
		    //WebDriverWait wait = new WebDriverWait(driver, 2000);
		    driver.findElement(By.xpath("//div[contains(@id,'addAddressButtons')]/child::button[1]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//button[contains(text(),'TAKE NEW')]")).click();
		    Thread.sleep(1000);

		    List<WebElement> placeOrder1 = driver.findElements(By.xpath(".//button[contains(text(),normalize-space('Give Measurements Online'))]"));
		 driver.findElement(By.xpath(".//button[contains(text(),normalize-space('Give Measurements Online'))]")).click();
	    
		    Thread.sleep(1000);
		    WebElement moveonmenu1 = driver.findElement(By.xpath("id(\"online\")/label[1]/span[2]"));
		    action.moveToElement(moveonmenu1).moveToElement(driver.findElement(By.xpath("id(\"online\")/label[1]/span[2]"))).click().perform();

		    Thread.sleep(1000);
		    WebElement moveonmenu2 = driver.findElement(By.xpath("id(\"proceedNow\")/a[1]"));
		    action.moveToElement(moveonmenu2).moveToElement(driver.findElement(By.xpath("id(\"proceedNow\")/a[1]"))).click().perform();

		    Thread.sleep(1000);
		    driver.findElement(By.id("continueButton")).click();

		    Thread.sleep(1000);
		    WebElement moveonmenu3 = driver.findElement(By.xpath("//div[contains(@id,'payGrid')]/descendant::span[contains(text(),' CASH ON DELIVERY')]"));
		    action.moveToElement(moveonmenu3).moveToElement(driver.findElement(By.xpath("//div[contains(@id,'payGrid')]/descendant::span[contains(text(),' CASH ON DELIVERY')]"))).click().perform();
		    Thread.sleep(1000);
		    List<WebElement> placeOrder = driver.findElements(By.xpath("//button[contains(@id,'cod') and text()=normalize-space('RENT NOW')]"));
		    System.out.println(placeOrder.size()-1);
		    placeOrder.get(placeOrder.size()-1).click();
		    System.out.println("Successfully Oreder Place");	 
	}
	}

