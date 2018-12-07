package Flyrobe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Date_select extends Flyrobe_config {
	String DATE,MONTH,finalDate;
	public  void autodate() throws InterruptedException
	{
		String DATE,MONTH,finalDate;
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 2000);

			Thread.sleep(5000);
    WebElement moveonmenu = driver.findElement(By.xpath("//*[@id=\"deliveryDatePicker\"]/input"));
	action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//*[@id=\"deliveryDatePicker\"]/input"))).click().perform();
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
			
			
			
			MONTH1 = Integer.parseInt(enableDate.get(0).getAttribute("data-month")) + 1;
			MONTH = "" + MONTH1;
			if (MONTH.length() == 1)
				MONTH = "0" + MONTH;
			
			
			finalDate = enableDate.get(0).getAttribute("data-year") + "-" + MONTH + "-" + DATE;
			System.out.println("finaldate"+finalDate);
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")));
			
			driver.findElement(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[not(contains(@class,'xdsoft_disabled'))and not(contains(@class,'xdsoft_current'))]")).click();
		
			datenotfound = false;
			
		} else {
			driver.findElement(By.cssSelector(".xdsoft_next")).click();
			Thread.sleep(3000);			
		}
		}	
	
}  
	
	//pick manual date from user
	
	public void manualdate() throws InterruptedException
	{
		
	    String date=obj.getProperty("date");
	   int month=Integer.parseInt(obj.getProperty("month"));
	    int year=Integer.parseInt(obj.getProperty("year"));
	    System.out.println(date);
	    System.out.println(month);
	    Boolean datenotfound = true;
	    System.out.println(year);
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		
		 WebElement moveonmenu = driver.findElement(By.xpath("//*[@id=\"deliveryDatePicker\"]/input"));
			action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//*[@id=\"deliveryDatePicker\"]/input"))).click().perform();
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
		}
//If date not match with input then goes to this loop.
	  else 
	  {
			  driver.findElement(By.cssSelector(".xdsoft_next")).click();
			 
	}
			 
}
	
}
	
	//pick male or female and click view collection on home page
	public void genderselecthome() throws InterruptedException
	{
    String genderget=obj.getProperty("gender");
		
		WebDriverWait wait = new WebDriverWait(driver, 2000);

		Thread.sleep(3000);	
		driver.findElement(By.xpath("//*[@id=\"genderHome\"]")).click();
		List<WebElement> gender=driver.findElements(By.cssSelector("#mdl-js-layout > main > div:nth-child(1) > div.jumbotron.position-relative.bg-dark-grey.home-banner > div:nth-child(2) > div > div.mdl-cell.mdl-cell--12-col > div > div.mdl-menu__container.is-upgraded.is-visible > ul"));
		//System.out.println(gender.size());	
		//System.out.println(gender.get(0).getText());
		List<String> genderadd=new ArrayList<String>();
		
		for(WebElement genderselect: gender)
		{
			genderadd.add(genderselect.getText());
		}
		System.out.println(genderadd);
	 	if(genderadd.contains(genderget))
	 	{
	 		System.out.println("Select Men");
	 		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mdl-js-layout > main > div:nth-child(1) > div.jumbotron.position-relative.bg-dark-grey.home-banner > div:nth-child(2) > div > div.mdl-cell.mdl-cell--12-col > div > div.mdl-menu__container.is-upgraded.is-visible > ul > li:nth-child(1)")));
			driver.findElement(By.cssSelector("#mdl-js-layout > main > div:nth-child(1) > div.jumbotron.position-relative.bg-dark-grey.home-banner > div:nth-child(2) > div > div.mdl-cell.mdl-cell--12-col > div > div.mdl-menu__container.is-upgraded.is-visible > ul > li:nth-child(1)")).click();
			
			driver.findElement(By.xpath("//*[@id=\"homeSearchButton\"]/a/button")).click();
	 	}
	 	else
	 	{
	 		System.out.println("Select Women");
	 		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mdl-js-layout > main > div:nth-child(1) > div.jumbotron.position-relative.bg-dark-grey.home-banner > div:nth-child(2) > div > div.mdl-cell.mdl-cell--12-col > div > div.mdl-menu__container.is-upgraded.is-visible > ul > li:nth-child(2)")));
			driver.findElement(By.cssSelector("#mdl-js-layout > main > div:nth-child(1) > div.jumbotron.position-relative.bg-dark-grey.home-banner > div:nth-child(2) > div > div.mdl-cell.mdl-cell--12-col > div > div.mdl-menu__container.is-upgraded.is-visible > ul > li:nth-child(2)")).click();
			driver.findElement(By.xpath("//*[@id=\"homeSearchButton\"]/a/button")).click();
	 	}
	}
	
}
	

