package flyrobe_web;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class shop_flyrobe {
	WebDriver driver;
	int i;
	String DATE,MONTH,finalDate;
	@BeforeTest
	public void pageload()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://flyrobe.com");
		
	}
	@Test(priority=1,description="HomePage")
	public void homepage() throws InterruptedException, IOException
	{
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\flyrobe_web\\src\\flyrobe_web\\Address.txt");
		obj.load(objfile);
		String gmail=obj.getProperty("gmail");
		String pwd=obj.getProperty("pwd");
		String city=obj.getProperty("city");
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		web1.sendKeys(city,Keys.ENTER);
		
			Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'pull-right')]/descendant::a[contains(@class,'no-link uppercase clickable border-left ng-scope')]")));
		driver.findElement(By.xpath("//div[contains(@class,'pull-right')]/descendant::a[contains(@class,'no-link uppercase clickable border-left ng-scope')]")).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div:nth-child(2) > button")));
		driver.findElement(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div:nth-child(2) > button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(@class,'btn btn-medium google-btn text-white letter-spacing05 position-relative ng-scope')]")));
		String parentHandle = driver.getWindowHandle();
		System.out.println("First Window"+parentHandle);
		driver.findElement(By.xpath(".//button[contains(@class,'btn btn-medium google-btn text-white letter-spacing05 position-relative ng-scope')]")).click();//click google login
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("Login Start....");
	   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();//clear text box
	   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(gmail);// enetr email
	   driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#identifierNext > div.ZFr60d.CeoRYc")));	
	   String str1=driver.findElement(By.id("identifierNext")).getText();
	   System.out.println("Button"+str1);
	   driver.findElement(By.id("identifierNext")).click();//clcik next
	   Thread.sleep(2000);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
	   driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).clear();// clear text box
	   driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(pwd);// enter password
	   driver.findElement(By.id("passwordNext")).click();// click login
	   System.out.println("Login Done....");
	   Thread.sleep(2000);
	   //driver.close();
	    driver.switchTo().window(parentHandle);
	    
	    driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]")).click();//close login window
        Thread.sleep(5000);
        WebElement moveonmenu = driver.findElement(By.xpath("//*[@id=\"deliveryDatePicker\"]/input"));
		action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//*[@id=\"deliveryDatePicker\"]/input"))).click().perform();
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
				
				
				
				MONTH1 = Integer.parseInt(enableDate.get(0).getAttribute("data-month")) + 1;
				MONTH = "" + MONTH1;
				if (MONTH.length() == 1)
					MONTH = "0" + MONTH;
				
				
				finalDate = enableDate.get(0).getAttribute("data-year") + "-" + MONTH + "-" + DATE;
				System.out.println("finaldate"+finalDate);
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")));
				
				driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")).click();
			
				datenotfound = false;
				
			} else {
				driver.findElement(By.cssSelector(".xdsoft_next")).click();
				Thread.sleep(3000);			
			}
			}	
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//*[@id=\"genderHome\"]")).click();
		
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mdl-js-layout > main > div:nth-child(1) > div.jumbotron.position-relative.bg-dark-grey.home-banner > div:nth-child(2) > div > div.mdl-cell.mdl-cell--12-col > div > div.mdl-menu__container.is-upgraded.is-visible > ul > li:nth-child(2)")));
		driver.findElement(By.cssSelector("#mdl-js-layout > main > div:nth-child(1) > div.jumbotron.position-relative.bg-dark-grey.home-banner > div:nth-child(2) > div > div.mdl-cell.mdl-cell--12-col > div > div.mdl-menu__container.is-upgraded.is-visible > ul > li:nth-child(2)")).click();
		driver.findElement(By.xpath("//*[@id=\"homeSearchButton\"]/a/button")).click();
	 	
	}
	@Test(priority=2,description="ListPage")
	public void listpage() throws InterruptedException
	{
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	
		
		List<WebElement> itemselect=driver.findElements(By.xpath("//div[contains(@id,'focusDiv')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col mdl-cell--2-col-phone mdl-cell--4-col-tablet medium-font ng-scope')]"));
		
		System.out.println(itemselect.size());
		for(i=0;i<itemselect.size();i++)
		System.out.println(itemselect.get(i).getText());
	
		if(itemselect.size()==i)
		{
			
			System.out.println(itemselect.get(2).getAttribute("!product.is_on_sale"));
			itemselect.get(2).click();
		}
		else
			System.out.println("Data not found");
		
			}
	@Test(priority=3,description="Details Page")
	public void detailspage() throws InterruptedException
	{
		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		driver.findElement(By.xpath("//*[@id=\"product-details\"]/div[2]")).click();
		driver.navigate().refresh();
       Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
		driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
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
								
			} else {
				driver.findElement(By.cssSelector(".xdsoft_next")).click();
				Thread.sleep(3000);			
			}
			}
		driver.findElement(By.xpath("//div[contains(@class,'modal-contents ng-scope')]/descendant::button[contains(text(),'OKAY GOT IT')]")).click();
		driver.findElement(By.id("addToCart")).click();
		}
	@Test(priority=4,description="cart")
	public void cart() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
	       Actions action = new Actions(driver);
	       driver.findElement(By.xpath("//div[contains(@class,'main-content cart-sectionp pb-0 ng-scope')]/descendant::div[contains(@class,'mdl-grid standard-width')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col  mdl-cell--8-col-tablet mdl-cell--4-col-phone')]/descendant::div[contains(@class,'js-suggest-coupons ng-scope')]/descendant::div[contains(@class,'cpnContain')]/child::button[1]")).click();
			
	       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.modal-section.coupon-modal > div > div.coupon-modal-wrapper.font-base-regular.position-relative.coupon-mob-bg.ng-scope > div.all-coupons > div:nth-child(2) > div.coupons-list.red-theme.padding-bottom25 > div:nth-child(1) > div.mdl-grid.coupon-repeat > div.mdl-cell.mdl-cell--1-col.mdl-cell--1-col-phone.mdl-cell--1-col-tablet.text-center.padding6.coupon-checkbox-mob > label > span.mdl-checkbox__ripple-container.mdl-js-ripple-effect.mdl-ripple--center")));
	       driver.findElement(By.cssSelector("body > div.modal-section.coupon-modal > div > div.coupon-modal-wrapper.font-base-regular.position-relative.coupon-mob-bg.ng-scope > div.all-coupons > div:nth-child(2) > div.coupons-list.red-theme.padding-bottom25 > div:nth-child(1) > div.mdl-grid.coupon-repeat > div.mdl-cell.mdl-cell--1-col.mdl-cell--1-col-phone.mdl-cell--1-col-tablet.text-center.padding6.coupon-checkbox-mob > label > span.mdl-checkbox__ripple-container.mdl-js-ripple-effect.mdl-ripple--center")).click();
		   
	       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.modal-section.coupon-modal > div > div.coupon-modal-wrapper.font-base-regular.position-relative.coupon-mob-bg.ng-scope > div.all-coupons > div:nth-child(2) > div.coupons-list.red-theme.padding-bottom25 > div.bottom-border.position-relative.ng-scope.red-selected > div.mdl-grid.coupon-repeat > div.coupon-apply-btn.ng-scope > button")));
			driver.findElement(By.cssSelector("body > div.modal-section.coupon-modal > div > div.coupon-modal-wrapper.font-base-regular.position-relative.coupon-mob-bg.ng-scope > div.all-coupons > div:nth-child(2) > div.coupons-list.red-theme.padding-bottom25 > div.bottom-border.position-relative.ng-scope.red-selected > div.mdl-grid.coupon-repeat > div.coupon-apply-btn.ng-scope > button")).click();
	       
			
			 WebElement moveonmenu = driver.findElement(By.xpath("//div[contains(@class,'main-content cart-sectionp pb-0 ng-scope')]/descendant::div[contains(@class,'mdl-grid standard-width')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col  mdl-cell--8-col-tablet mdl-cell--4-col-phone')]/descendant::div[contains(@class,'coupon-cart-place-order-btn text-center width100 mt-20 couponButtonM1 ng-scope')]/child::a[1]"));
			action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'main-content cart-sectionp pb-0 ng-scope')]/descendant::div[contains(@class,'mdl-grid standard-width')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col  mdl-cell--8-col-tablet mdl-cell--4-col-phone')]/descendant::div[contains(@class,'coupon-cart-place-order-btn text-center width100 mt-20 couponButtonM1 ng-scope')]/child::a[1]"))).click().perform();
	}
	@Test(priority=5,description="checkout")
	public void checkout() throws InterruptedException, IOException
	{
		Actions action = new Actions(driver);
		
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\flyrobe_web\\src\\flyrobe_web\\Address.txt");
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
	    driver.findElement(By.id("addIconTop")).click();
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
	    WebDriverWait wait = new WebDriverWait(driver, 2000);
driver.findElement(By.xpath("//div[contains(@id,'addAddressButtons')]/child::button[1]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//button[contains(text(),'TAKE NEW')]")).click();
Thread.sleep(1000);

List<WebElement> placeOrder1 = driver.findElements(By.xpath(".//button[contains(text(),normalize-space('Give Measurements Online'))]"));
System.out.println(placeOrder1.size()-1);
placeOrder1.get(placeOrder1.size()-1).click();
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
Thread.sleep(2000);


}
	
	
	@AfterTest
 public void escalation() throws InterruptedException
 {
	 Thread.sleep(2000);
System.out.println("Start Order To Test...");
String Orderno=driver.findElement(By.cssSelector("#mdl-js-layout > main > div:nth-child(2) > div > div > div > div.text-center.raleway-regular.border-bottom.pb-20 > div.text-light-grey.font-base-medium.big-font.ng-binding")).getText();
System.out.println(Orderno);
	 String temp[]=Orderno.split(" ");
	 for(String order1:temp)
	 {
	     System.out.println(order1);  
	 }
	  String s1=temp[1];
	      String s2=temp[2];
	      System.out.println(s2);
driver.navigate().to("https://node.flyrobeapp.com:8002/escalationDashboardNewDB");
driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
driver.findElement(By.xpath("//div[contains(@class,'navbar-header')]/child::input[1]")).sendKeys(s2);
driver.findElement(By.xpath("//div[contains(@class,'navbar-header')]/child::input[2]")).click();
Thread.sleep(10000);
driver.findElement(By.id("order_status_update")).click();
driver.switchTo().alert().accept();
Thread.sleep(2000);
driver.switchTo().alert().accept();
driver.findElement(By.xpath("//div[contains(@class,'navbar-header')]/child::input[2]")).click();
Thread.sleep(2000);
String Test=driver.findElement(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[4]")).getText();
System.out.println(Test);
if(Test.equals("TEST"))
{
System.out.println("Order Successfully Test");
}
else
{
System.out.println("Order Not Successfully Test");
}
driver.close();
}
}
