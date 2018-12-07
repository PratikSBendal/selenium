

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class offer {
	@Test(priority=1, description= "Google login and logout")
	public void offers() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");	
			
			WebDriver driver=new FirefoxDriver();
			JavascriptExecutor javascript = (JavascriptExecutor) driver;
			  javascript.executeScript("alert('Test Case Execution Is started Now..');");
			 Thread.sleep(2000);
			 driver.switchTo().alert().accept();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			driver.manage().window().maximize();
			driver.get("http://www.flyrobe.com/");
	        driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//div[contains(@class,'city-checkbox inline-block ng-scope')]/child::label[contains(@for,'chandigarhCity')]")).click();
			driver.findElement(By.xpath(".//a[contains(@class,'uppercase no-link middle-header-call')]")).click();//click offer
			driver.findElement(By.xpath(".//div[contains(@class,'inline-block offer-section text-center pt-60 ph-25 ')]/descendant::button[contains(@ng-click-copy,'WELCOME150')]")).click();
			driver.navigate().back();
			/*driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
			/*WebElement e=driver.findElement(By.cssSelector("body"));
			e.sendKeys(Keys.CONTROL + "t");*/	
			/*driver.get("http://www.google.com");
			driver.findElement(By.id("lst-ib")).clear();//clear no text box
			driver.findElement(By.id("lst-ib")).sendKeys(Keys.CONTROL + "v");*/
			
		
		
			
	}

}
