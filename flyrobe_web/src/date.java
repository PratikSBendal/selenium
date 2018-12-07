
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class date {
	@Test
	public void date() throws InterruptedException{
		
	String DATE,MONTH,finalDate;
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");	
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("http://www.flyrobe.com");
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		web1.sendKeys("Mumbai",Keys.ENTER);
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
		}}
}
 