package Flyrobe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flyrobe_config {
	public static WebDriver driver;
	public static FileInputStream fileinput=null;
	public static Properties obj=null;
	
	@BeforeTest
	public   void pageload() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://flyrobe.com");
		obj = new Properties();
		//FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\Address.txt");
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\Address.txt");
		obj.load(fileinput);
		String city=obj.getProperty("city");
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		web1.sendKeys(city,Keys.ENTER);
	
}
	
	//after order place test mark te order
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
	public void exit()
	{
		System.out.println("Exit");
	}
	
}
