package Ofs_new;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ofs_OM_tab extends Config_ofs{
	public void feasign_to_confrimfinaldelivery() throws InterruptedException, IOException
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
		
//		Thread.sleep(500);
		
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
		    driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Fitting Expert Assigned'))]")).click();//Fitting Expert Assigned
		    driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
		    Thread.sleep(2000);
//		    WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		    
		    driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//dropdown list
		    driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Measurement'))]")).click();//Out For Measurement
		    driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
		    driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//dropdown list
		    System.out.println("Fitting Expert Assign");
		    driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measured'))]")).click();//Measured
		    driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
		    driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content om-item')]/descendant::td[9]")).click();//dropdown list
		    driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Final Delivery'))]")).click();//Confirm For Final Delivery
		    driver.findElement(By.xpath("//html//div[@class='col-lg-5']/div[@class='col-xs-6']/button[1]")).click();//click submit button
		   
		    
}
	
}