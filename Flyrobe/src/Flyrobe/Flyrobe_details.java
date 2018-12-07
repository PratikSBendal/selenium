package Flyrobe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flyrobe_details extends Flyrobe_config{
	String DATE,MONTH,finalDate;
	 
	public void detailsautodatepage() throws InterruptedException,IOException
	{
		String genderget=obj.getProperty("gender");
	String together=obj.getProperty("together");
	
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		//driver.findElement(By.xpath("//*[@id=\"product-details\"]/div[2]")).click();
	if(genderget.equalsIgnoreCase("Women") )
		{
		System.out.println("Women Date");
		driver.navigate().refresh();
		}
	
	else
	{
		System.out.println("Men date");
	}
       Thread.sleep(15000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
		driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
		Thread.sleep(1000);
       	Boolean datenotfound = true;
		int MONTH1;
		while (datenotfound) {
			List<WebElement> enableDate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]"));
			
			if (enableDate.size() > 0) 
			{
				DATE = enableDate.get(0).getAttribute("data-date");
				if(DATE.length() == 1)
				DATE = "0" + DATE;
					
				MONTH1 = Integer.parseInt(enableDate.get(1).getAttribute("data-month")) + 1;
				MONTH = "" + MONTH1;
				if (MONTH.length() == 1)
					MONTH = "0" + MONTH;
				
				
				finalDate = enableDate.get(0).getAttribute("data-year") + "-" + MONTH + "-" + DATE;
				System.out.println("finaldate"+finalDate);
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")));
				
				driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")).click();
				datenotfound = false;
					Thread.sleep(3000);			
			} else {
				driver.findElement(By.cssSelector(".xdsoft_next")).click();
				Thread.sleep(3000);			
			}
			}
      try {
	//driver.findElement(By.cssSelector("body > div.angular-modal.date-template-modal-desk > div.modal-contents.ng-scope > div > button")).click();
	driver.findElement(By.xpath("//div[contains(@class,'modal-contents ng-scope')]/descendant::button[contains(text(),'OKAY GOT IT')]")).click();
		driver.findElement(By.id("addToCart")).click();
      }
		catch(Exception e)
		{
			driver.findElement(By.id("addToCart")).click();
		}
	}
	
	public void detailsmanualdatepage() throws InterruptedException

	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
		String genderget=obj.getProperty("gender");
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		String date=obj.getProperty("date");
		   int month=Integer.parseInt(obj.getProperty("month"));
		    int year=Integer.parseInt(obj.getProperty("year"));
		    System.out.println(date);
		    System.out.println(month);
		 Boolean datenotfound = true;
		 if(genderget.equalsIgnoreCase("Women"))
			{
			System.out.println("Women Date");
			driver.navigate().refresh();
			}
		else {
			System.out.println("Men date");
		}
	       Thread.sleep(15000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
			driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
			Thread.sleep(1000);
		 
		while(datenotfound)
	    {				   
		
		List<WebElement> enableDate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]"));
		String months=driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_other_month'))]")).getAttribute("data-month");
		String years=driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))]")).getAttribute("data-year");
	int montint=Integer.parseInt(months);
 	int yearsint=Integer.parseInt(years);
         System.out.println(montint);
		        	    	//If date match with input then goes to this loop.
			 if(montint==(month-1) && yearsint==year || montint==(month-1) && yearsint<year)

		   {
	    for(WebElement data1:enableDate)
	    {
		    	//data_date.add(data1.getAttribute("data-date"));
	    	String className = data1.getAttribute("class");
	    	String datecompare=data1.getText();
	    	if(datecompare.equals(date))
    	{
	    	data1.click();
	    	break;
         }
	    	
	   }	
    datenotfound = false;
    Thread.sleep(3000);
		}
//If date not match with input then goes to this loop.
			 	 
	  else 
	  {
			  driver.findElement(By.cssSelector(".xdsoft_next")).click();		 
	}
		
	}
		 
try 
{
				
	driver.findElement(By.xpath("//div[contains(@class,'modal-contents ng-scope')]/descendant::button[contains(text(),'OKAY GOT IT')]")).click();
	driver.findElement(By.id("addToCart")).click();
				
}
				
catch(Exception e)
{
driver.findElement(By.id("addToCart")).click();
}
}

	
	
	//place order for men auto date
public void detailspagemenautodate() throws InterruptedException, IOException
{
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
	Actions action = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 2000);
	//driver.findElement(By.xpath("//*[@id=\"product-details\"]/div[2]")).click();
	driver.navigate().refresh();
   Thread.sleep(15000);
   List<WebElement> inputbox1=driver.findElements(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]"));
   List<String> list1=new ArrayList<String>();
   for(WebElement data:inputbox1)
   {
   	list1.add(data.getText());
   }
   System.out.println(list1);

//   Thread.sleep(15000);
   if(list1.contains("COLLAR SIZE"))
   {
   	Thread.sleep(5000);
   	driver.findElement(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')and p[contains(text(),'Collar Size')]]/descendant::div[contains(@class,'dropdown-wrapper width95 inline')]")).click();
   	driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
   	driver.findElement(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')and p[contains(text(),'Waist Size')]]/descendant::div[contains(@class,'dropdown-wrapper width95 inline')]")).click();
   	List<WebElement> list=driver.findElements(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]"));
   System.out.println(list.size()-1);
   list.get(list.size()-1).click();
   
   detailsautodatepage();
   

   }
   else
   {
   	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing')]/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]/child::div[1]")).click();
   	driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
//   	Thread.sleep(15000);
//   	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
//   	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
  	Thread.sleep(1000);
   	detailsautodatepage();
   
   }
   		
}

//place order for men manual date
//public void detailspagemenmanualdate() throws InterruptedException, IOException
//{
//	driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
//	Actions action = new Actions(driver);
//	WebDriverWait wait = new WebDriverWait(driver, 2000);
//	//driver.findElement(By.xpath("//*[@id=\"product-details\"]/div[2]")).click();
//	driver.navigate().refresh();
//   Thread.sleep(15000);
//   
//   List<WebElement> inputbox1=driver.findElements(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]"));
//   List<String> list1=new ArrayList<String>();
//   for(WebElement data:inputbox1)
//   {
//   	list1.add(data.getText());
//   }
//   System.out.println(list1);
//
////   Thread.sleep(15000);
//   if(list1.contains("COLLAR SIZE"))
//   {
//   	Thread.sleep(5000);
//   	driver.findElement(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')and p[contains(text(),'Collar Size')]]/descendant::div[contains(@class,'dropdown-wrapper width95 inline')]")).click();
//   	driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
//   	driver.findElement(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')and p[contains(text(),'Waist Size')]]/descendant::div[contains(@class,'dropdown-wrapper width95 inline')]")).click();
//   	List<WebElement> list=driver.findElements(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]"));
//   System.out.println(list.size()-1);
//   list.get(list.size()-1).click();
//   
//   detailsmanualdatepage();
//   
//
//   }
//   else
//   {
//   	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing')]/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]/child::div[1]")).click();
//   	driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
//   	Thread.sleep(15000);
//   	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
//   	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
//   	Thread.sleep(1000);
//   	detailsmanualdatepage();
//   
//   }
//	
//}
}
