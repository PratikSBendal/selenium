

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class pickdate {
	
@Test
public void pickdate() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, 20);
String DATE,MONTH,finalDate;
driver.get("http://flyrobe.com");
driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
driver.findElement(By.cssSelector("body > div.angular-modal.city-modal > div.modal-contents.ng-scope > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--4-col-phone.mdl-cell--middle > div > div:nth-child(13)")).click(); //lucknow
wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[contains(@placeholder,'Delivery Date')]")));
driver.findElement(By.xpath(".//input[contains(@placeholder,'Delivery Date')]")).click();

Boolean datenotfound = true;
int MONTH1;


while (datenotfound) {
	List<WebElement> enableDate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]"));
	System.out.println("EnableDate"+enableDate);
	
	
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[contains(@data-date,'30')]")));
		//driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[contains(@data-date,'30')]")).click();
		driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]")).click();
		datenotfound = false;
		
	} else {
		driver.findElement(By.cssSelector(".xdsoft_next")).click();
		Thread.sleep(3000);
	
	}
	}		
}
}