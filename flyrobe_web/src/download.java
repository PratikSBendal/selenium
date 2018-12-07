import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class download {
	@Test
	public void download() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	String DATE,MONTH,finalDate;
	driver.get("http://flyrobe.com");
	driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("body > div.angular-modal.city-modal > div.modal-contents.ng-scope > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--4-col-phone.mdl-cell--middle > div > div:nth-child(13)")).click(); //lucknow
driver.findElement(By.xpath(".//div[contains(@class,'pull-right')]/child::a[contains(@target,'_blank')]")).click();
	
	}
}	