package Flyrobe_c2c;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties; 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flyrobe_C2C {
	public static WebDriver driver;
	public static FileInputStream fileinput=null;
	public static Properties obj=null;
	@BeforeTest
	public void c2c_launch() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://flyrobe.com/list-your-products#ListYourProduct");
		obj = new Properties();
		//FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\Address.txt");
Thread.sleep(2000);
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_c2c\\Address.txt");
		obj.load(fileinput);
		String city=obj.getProperty("city");
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		web1.sendKeys(city,Keys.ENTER);
	}

public void c2c_enterdata() throws InterruptedException
{
	System.out.println("Start Fill up form...");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		String name=obj.getProperty("name");
		String mail=obj.getProperty("email");
	    String mobile=obj.getProperty("mobile");
		String pin=obj.getProperty("pin");
		String address=obj.getProperty("address");
		String brand=obj.getProperty("brand");
		String price=obj.getProperty("price");
		String uploadfile=obj.getProperty("filepath");
		String bust=obj.getProperty("bust");
		String waist=obj.getProperty("waist");
		String hip=obj.getProperty("hip");
		if(name.length()>0)
		{
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(name);
		}
		else
		System.out.println("Name not Correct");
		if(mail.endsWith(".com"))
		{
		driver.findElement(By.id("mail")).clear();
		driver.findElement(By.id("mail")).sendKeys(mail);
		}
		else 
		{
			System.out.println("Mail Not Corret");
	        driver.close();
		}
		if(address.length()>0)
        {
		driver.findElement(By.id("flat")).clear();
		driver.findElement(By.id("flat")).sendKeys(address);
        }
		else 
	         
	        System.out.println("Address Not Correct");
		 if(pin.length()==6)
		  {
		driver.findElement(By.id("pincode")).clear();
		driver.findElement(By.id("pincode")).sendKeys(pin);
		  }
		 else
		 {
		System.out.println("Pin Not Corect");
	   driver.close();
	      }
		 if(mobile.length()==10)
	      {	
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys(mobile);
	      }
		 else 
		 {
			   System.out.println("Phone not valid");
	    driver.close();
	    }
	driver.findElement(By.xpath("//button[contains(@ng-click,'addItem()')]")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'formContainer add-item-modal margin-center ng-scope')]/descendant::div[contains(@class,'mb-20 width100')]/descendant::select[contains(@for,'catSelect')]")));
	driver.findElement(By.xpath("//div[contains(@class,'formContainer add-item-modal margin-center ng-scope')]/descendant::div[contains(@class,'mb-20 width100')]/descendant::select[contains(@for,'catSelect')]")).click();
	driver.findElement(By.xpath("//option[text()='Western Gown']")).click();
	if(brand.length()>0)
	{
		driver.findElement(By.id("brand")).clear();
		driver.findElement(By.id("brand")).sendKeys(brand);
	}
	else
	System.out.println("Brand not correct");

	if(price.length()>0)
	{
	driver.findElement(By.id("mrp")).clear();
	driver.findElement(By.id("mrp")).sendKeys(price);
	}
	else
		System.out.println("Price is incoorect");
driver.findElement(By.xpath("//input[contains(@name,'isAlterable')]")).click();
driver.findElement(By.id("fileUpload")).sendKeys(uploadfile);
driver.findElement(By.xpath("//button[contains(@ng-click,'main.addIteminList()')]")).click();
Thread.sleep(10000);
try {
driver.findElement(By.xpath("//div[contains(@class,'no_of_items mb-30 ng-scope')]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]")).click();
System.out.println("Item upload");
}
catch(Exception e)
{
System.out.println("Item not upload");
driver.close();
}
Thread.sleep(10000);
if(bust.length()>0)
{
driver.findElement(By.id("bust")).clear();
driver.findElement(By.id("bust")).sendKeys(bust);
}
else
	System.out.println("Incoorect bust size");
if(waist.length()>0)
{
driver.findElement(By.id("waist")).clear();
driver.findElement(By.id("waist")).sendKeys(waist);
}
else
	System.out.println("Incoorect waist size");
if(hip.length()>0)
{
driver.findElement(By.id("hip")).clear();
driver.findElement(By.id("hip")).sendKeys(hip);
}
else
	System.out.println("Incoorect hip size");
driver.findElement(By.xpath("//input[contains(@placeholder,'Select Day')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[contains(@class,'mdl-menu__container is-upgraded')]/descendant::ul[contains(@for,'daySelect')]/child::li[1]")).click();
driver.findElement(By.id("timeSelect")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[contains(@class,'mdl-menu__container is-upgraded')]/descendant::ul[contains(@for,'timeSelect')]/child::li[1]")).click();
driver.findElement(By.xpath("//span[contains(@class,'mdl-checkbox__ripple-container mdl-js-ripple-effect mdl-ripple--center')]")).click();
driver.findElement(By.xpath("//button[contains(@ng-click,'uploadProducts')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[contains(@class,'mdl-button customOkay mb-20')]")).click();
	}
@AfterTest
public void c2cexit()
{
System.out.println("Successfull C2C page...");
driver.close();
}

}
