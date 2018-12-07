//package test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class flyrobe {

WebDriver driver;
	@Test(priority=1, description= "Google login and logout")
public void loginanlogoutgoogle() throws InterruptedException 
{
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");	
		 driver=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		String DATE,MONTH,finalDate;
		//WebDriver driver=new ChromeDriver();
	
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("http://www.flyrobe.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		web1.sendKeys("Mumbai",Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'top-header utility-header mdl-cell--hide-tablet mdl-cell--hide-phone overflowHidden text-muted mt-5')]/descendant::a[contains(@ng-if,'!main.user.loggedIn')]")));
		driver.findElement(By.xpath(".//div[contains(@class,'top-header utility-header mdl-cell--hide-tablet mdl-cell--hide-phone overflowHidden text-muted mt-5')]/descendant::a[contains(@ng-if,'!main.user.loggedIn')]")).click();
		//driver.findElement(By.xpath(".//a[contains(@class,'no-link uppercase clickable border-left ng-scope')]")).click();//login button
	/*	driver.findElement(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div:nth-child(2) > input")).clear();//clear no text box
		driver.findElement(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div:nth-child(2) > input")).sendKeys("8888888888");// enter no 
		driver.findElement(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > button")).click();// click button  */
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(@class,'btn btn-medium google-btn text-white letter-spacing05 position-relative ng-scope')]")));
		String parentHandle = driver.getWindowHandle();
		System.out.println("First Window"+parentHandle);
		driver.findElement(By.xpath(".//button[contains(@class,'btn btn-medium google-btn text-white letter-spacing05 position-relative ng-scope')]")).click();//click google login
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("Login Start....");
	   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();//clear text box
	   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("pratik.bendal@flyrobe.com");// enetr email
//	   driver.findElement(By.xpath("//*[@id=\\\"identifierId\\\"]")).sendKeys(Keys.ENTER);
	   driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#identifierNext > div.ZFr60d.CeoRYc")));	
	   String str1=driver.findElement(By.id("identifierNext")).getText();
	   System.out.println("Button"+str1);
	   driver.findElement(By.id("identifierNext")).click();//clcik next
	   Thread.sleep(2000);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
	   driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).clear();// clear text box
	   driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("flyrobe1621");// enter password
	   driver.findElement(By.id("passwordNext")).click();// click login
	   System.out.println("Login Done....");
	   Thread.sleep(2000);
	   //driver.close();
	    driver.switchTo().window(parentHandle);
	   
			}	
	@Test(priority=2, description= "selectdatehomePage")
	public void selectdatehomePage() throws InterruptedException
	{ 
		String DATE,MONTH,finalDate;
	
		driver.findElement(By.cssSelector("#deliveryDatePicker > input")).click();
        Thread.sleep(1000);

		Boolean datenotfound = true;
		int MONTH1;

		while (datenotfound) {
			List<WebElement> enableDate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]"));
			System.out.println(""+enableDate);
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
				System.out.println(finalDate);
				driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]")).click();
				datenotfound = false;
			} else {
				driver.findElement(By.cssSelector(".xdsoft_next")).click();
				Thread.sleep(3000);
		}
	}
		 
	}}
