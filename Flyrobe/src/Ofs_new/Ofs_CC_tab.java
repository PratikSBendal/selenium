package Ofs_new;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ofs_CC_tab extends Config_ofs{
	public void cctabdelivery()throws InterruptedException, IOException
	{
		Actions action = new Actions(driver);
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  //driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//click order button cc tab
		WebDriverWait wait = new WebDriverWait(driver, 20);
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Ofs\\input.txt");
	obj = new Properties();
		obj.load(fileinput);
		String orderid=obj.getProperty("orderid");
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys(orderid);//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::button[contains(@class,'btn btn-primary m-t-7')]")).click();//get data 
		Thread.sleep(1000);
       driver.findElement(By.xpath("//html//div[@class='ui-grid-canvas']//div[2]/div[1]")).click();//click on table
       driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'ibox-content cc-item')]/descendant::td[9]")).click();//dropdown list
       driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measurement Scheduled From Placed'))]")).click();
       driver.findElement(By.xpath("//div[@class='col-lg-5']/descendant::div[contains(@class,'col-lg-12')]/child::button[contains(@class,'btn btn-primary btn-block')]")).click();
//       List<WebElement> dropdownstatus=driver.findElements(By.xpath("//option[@ng-repeat='loadPoint in main.statusMap[item.status]']"));
//       for(int i=0;i<dropdownstatus.size();i++)
//       {
//   		System.out.println(dropdownstatus.get(i).getText());
//   		} 
//     
       
       }
}