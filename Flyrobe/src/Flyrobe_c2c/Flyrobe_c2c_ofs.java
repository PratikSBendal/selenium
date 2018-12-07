package Flyrobe_c2c;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flyrobe_c2c_ofs extends Flyrobe_C2C {
public void flyrobeofs() throws InterruptedException
{
	
	System.out.println("Execute C2C leads...");
	Actions action=new Actions(driver);
	String name=obj.getProperty("name");
	WebDriverWait wait = new WebDriverWait(driver, 20);
	driver.get("http://web2.flyrobeapp.com:8000/dashboard/dashboard_v2/#/tables/customer-care");
	//login
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'panel panel-dark panel-flat login-panel')]/descendant::input[contains(@placeholder,'Username')]")));
	driver.findElement(By.xpath("//div[contains(@class,'panel panel-dark panel-flat login-panel')]/descendant::input[contains(@placeholder,'Username')]")).sendKeys("pratik.bendal@flyrobe.com");
	driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[contains(@class,'panel-body')]/descendant::input[contains(@placeholder,'Password')]")).sendKeys("pratik123");  
	driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	
	//process to rejection
	WebElement moveonmenu = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/a"));
	action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("id(\"side-menu\")/li[10]/ul[1]/li[6]/a[1]"))).click().perform();
	
	driver.findElement(By.xpath("//div[contains(@placeholder,'Select Mode...')]")).click();
	Thread.sleep(2000);
driver.findElement(By.xpath("id(\"navbar\")/div[1]/div[1]/div[2]/div[1]/ul[1]/descendant::li[contains(@class,'ui-select-choices-group')]/child::div[3]")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("id(\"navbar\")/div[1]/div[1]/div[3]/div[1]")));
driver.findElement(By.xpath("id(\"navbar\")/div[1]/div[1]/div[3]/div[1]")).click();
driver.findElement(By.xpath("id(\"navbar\")/div[1]/div[1]/div[3]/div[1]/ul[1]/descendant::li[contains(@class,'ui-select-choices-group')]/child::div[3]")).click();
driver.findElement(By.xpath("//button[contains(text(),normalize-space('Get Data'))]")).click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type,'search')]")));
driver.findElement(By.xpath("//input[contains(@type,'search')]")).sendKeys(name);
Thread.sleep(2000);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
driver.findElement(By.xpath("//button[contains(text(),normalize-space('Update Status'))]")).click();
driver.findElement(By.xpath("//select[contains(@required,'required')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//option[contains(text(),normalize-space('Rejected'))]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//select[contains(@required,'required')]")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-sm-6')]/descendant::button[contains(text(),normalize-space('Update'))]")));
driver.findElement(By.xpath("//div[contains(@class,'col-sm-6')]/descendant::button[contains(text(),normalize-space('Update'))]")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"page-top\"]/div[5]/div[7]/button[2]")));
driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[5]/div[7]/button[2]")).click();

}
}

 