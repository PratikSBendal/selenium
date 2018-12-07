package Flyrobe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flyrobe_login extends Flyrobe_config
{
	
public  void gmaillogin() throws InterruptedException, IOException
{
	
	//Properties obj = new Properties();
	//FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\Address.txt");
	//obj.load(objfile);
	Actions action = new Actions(driver);
WebDriverWait wait = new WebDriverWait(driver, 2000);
String gmail=obj.getProperty("gmail");
String pwd=obj.getProperty("pwd");
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
}
}
