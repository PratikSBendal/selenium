package Flyrobe_block_logic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login extends Flyrobe_config {
	
	public void chooiselogin(String a) throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		String loginmail=obj.getProperty("loginmail");
		String pwd=obj.getProperty("pwd");
		a=obj.getProperty("login");
		if(a.equalsIgnoreCase("gmail"))
		{
			
			
				Thread.sleep(1000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'pull-right')]/descendant::a[contains(@class,'no-link uppercase clickable border-left ng-scope')]")));
				driver.findElement(By.xpath("//div[contains(@class,'pull-right')]/descendant::a[contains(@class,'no-link uppercase clickable border-left ng-scope')]")).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div:nth-child(2) > button")));
				driver.findElement(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div:nth-child(2) > button")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(@class,'btn btn-medium google-btn text-white letter-spacing05 position-relative ng-scope')]")));
				//Focus on second window
				String parentHandle = driver.getWindowHandle();
				System.out.println("First Window"+parentHandle);
				driver.findElement(By.xpath(".//button[contains(@class,'btn btn-medium google-btn text-white letter-spacing05 position-relative ng-scope')]")).click();//click google login
				for(String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				//Login 
				System.out.println("Login Start....");
				Thread.sleep(1000);
			   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).clear();//clear text box
			   driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(loginmail);// enetr email
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
		else
		{
			System.out.println("FB");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'pull-right')]/descendant::a[contains(@class,'no-link uppercase clickable border-left ng-scope')]")));
			driver.findElement(By.xpath("//div[contains(@class,'pull-right')]/descendant::a[contains(@class,'no-link uppercase clickable border-left ng-scope')]")).click();
			Thread.sleep(1000);
			//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div.mdl-cell.mdl-cell--4-col-phone.mb-20.mdl-cell--6-col.mdl-cell--4-tablet.mob-center.ma > button")));
			//driver.findElement(By.cssSelector("body > div.angular-modal.login-modal > div.modal-contents.ng-scope > login-form > div > div > div.mdl-cell.mdl-cell--12-col.mdl-cell--8-col-tablet.mdl-cell--4-col-phone.position-relative > div > div > div.mdl-cell.mdl-cell--4-col-phone.mb-20.mdl-cell--6-col.mdl-cell--4-tablet.mob-center.ma > button")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(@class,'btn btn-medium fb-btn text-white letter-spacing05 position-relative padding ng-scope')]")));
			//Focus on second window
			String parentHandle = driver.getWindowHandle();
			System.out.println("First Window"+parentHandle);
			driver.findElement(By.xpath(".//button[contains(@class,'btn btn-medium fb-btn text-white letter-spacing05 position-relative padding ng-scope')]")).click();//click google login
			for(String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			//Login 
			System.out.println("Login Start....");
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(loginmail);
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(pwd);
			driver.findElement(By.id("u_0_0")).click();
			System.out.println("Login Done....");
			   Thread.sleep(2000);
			   //driver.close();
			    driver.switchTo().window(parentHandle);
			    
			    //driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[2]")).click();//close login window	
		}
		}
	}

	

