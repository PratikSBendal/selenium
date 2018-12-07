package Flyrobe_block_logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Block_logic_Parent extends Flyrobe_config {
	public void parent() throws InterruptedException, IOException 
	{
	Thread.sleep(2000);
	WebDriverWait wait = new WebDriverWait(driver, 2000);
	driver.findElement(By.id("track-order")).click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#onGoing > div > div.mdl-grid.mdl-grid--no-spacing > div > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--4-col-phone.mdl-cell--5-col-tablet.medium-font.font-base-medium.order-image > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--2-col-phone.mdl-cell--4-col-tablet.font-base-regular.ng-binding")));
String inventeryitem=driver.findElement(By.cssSelector("#onGoing > div > div.mdl-grid.mdl-grid--no-spacing > div > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--4-col-phone.mdl-cell--5-col-tablet.medium-font.font-base-medium.order-image > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--2-col-phone.mdl-cell--4-col-tablet.font-base-regular.ng-binding")).getText();
System.out.println(inventeryitem);
	driver.navigate().to("http://flyrobe.com/a/"+inventeryitem);
	date();
}
	
	
	
	
	
	
	public void noncustomfit() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		driver.findElement(By.id("track-order")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#onGoing > div > div.mdl-grid.mdl-grid--no-spacing > div > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--4-col-phone.mdl-cell--5-col-tablet.medium-font.font-base-medium.order-image > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--2-col-phone.mdl-cell--4-col-tablet.font-base-regular.ng-binding")));
		String inventeryitem=driver.findElement(By.cssSelector("#onGoing > div > div.mdl-grid.mdl-grid--no-spacing > div > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--4-col-phone.mdl-cell--5-col-tablet.medium-font.font-base-medium.order-image > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--2-col-phone.mdl-cell--4-col-tablet.font-base-regular.ng-binding")).getText();
		System.out.println(inventeryitem);
		driver.navigate().to("http://flyrobe.com/a/"+inventeryitem);
				
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\Block.txt");
		//FileInputStream monthblock=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\city.txt");
		obj.load(fileinput);
		String city=obj.getProperty("city");
		String Blockdate=obj.getProperty("Blockmonth");
		
		String cityadd;
		BufferedReader city1=new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\city.txt"));
		List<String> list1 = new ArrayList<String>();
		while((cityadd = city1.readLine()) != null){
		    list1.add(cityadd);
		    
		}
		
		for(int i=0;i<list1.size();i++)
		{
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mdl-js-layout > header > flyrobe-header > div.top-header.utility-header.mdl-cell--hide-tablet.mdl-cell--hide-phone.overflowHidden.text-muted.mt-5 > nav > div > a.no-link.clickable")));
		driver.findElement(By.cssSelector("#mdl-js-layout > header > flyrobe-header > div.top-header.utility-header.mdl-cell--hide-tablet.mdl-cell--hide-phone.overflowHidden.text-muted.mt-5 > nav > div > a.no-link.clickable")).click();
		Thread.sleep(2000);
		
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		web1.sendKeys(list1.get(i),Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("City is: "+list1.get(i));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing')]/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]/child::div[1]")).click();
	   	driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
	   //Thread.sleep(15000);
	   try
	   {
	   	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
	   	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
	   }
	   catch(Exception e)
	   {
	   	wait.until(ExpectedConditions.elementToBeClickable(By.id("datetimepicker")));
	   	driver.findElement(By.id("datetimepicker")).click();
	   }
	   Thread.sleep(1000);
	   	Boolean datenotfound = true;
		int MONTH1;
		while (datenotfound) {
			String getmonth=driver.findElement(By.cssSelector("body > div.xdsoft_datetimepicker.xdsoft_noselect.xdsoft_ > div.xdsoft_datepicker.active > div.xdsoft_mounthpicker > div.xdsoft_label.xdsoft_month > span")).getText();
			System.out.println(getmonth);
			if(getmonth.equalsIgnoreCase(Blockdate))
			{
			List<WebElement> disabledate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[(contains(@class,'xdsoft_disabled'))]"));
			System.out.println("Block Date For "+list1.get(i)+" : "+disabledate.size());
			datenotfound = false;
			}
			else
			{
				 driver.findElement(By.cssSelector(".xdsoft_next")).click();
			}
		}
	   	Thread.sleep(5000);
	   	driver.navigate().refresh();
		Thread.sleep(2000);
		}			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void date() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\Block.txt");
		//FileInputStream monthblock=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\city.txt");
		obj.load(fileinput);
		String city=obj.getProperty("city");
		String Blockdate=obj.getProperty("Blockmonth");
		
		
		String cityadd;
		BufferedReader city1=new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\city.txt"));
		List<String> list1 = new ArrayList<String>();
		while((cityadd = city1.readLine()) != null){
		    list1.add(cityadd);
		    
		}
		
		for(int i=0;i<list1.size();i++)
		{
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mdl-js-layout > header > flyrobe-header > div.top-header.utility-header.mdl-cell--hide-tablet.mdl-cell--hide-phone.overflowHidden.text-muted.mt-5 > nav > div > a.no-link.clickable")));
		driver.findElement(By.cssSelector("#mdl-js-layout > header > flyrobe-header > div.top-header.utility-header.mdl-cell--hide-tablet.mdl-cell--hide-phone.overflowHidden.text-muted.mt-5 > nav > div > a.no-link.clickable")).click();
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		web1.sendKeys(list1.get(i),Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("City is: "+list1.get(i));
		driver.navigate().refresh();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
		driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
		Thread.sleep(1000);
	   	Boolean datenotfound = true;
		int MONTH1;
		while (datenotfound) {
			String getmonth=driver.findElement(By.cssSelector("body > div.xdsoft_datetimepicker.xdsoft_noselect.xdsoft_ > div.xdsoft_datepicker.active > div.xdsoft_mounthpicker > div.xdsoft_label.xdsoft_month > span")).getText();
			System.out.println(getmonth);
			if(getmonth.equalsIgnoreCase(Blockdate))
			{
			List<WebElement> disabledate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[(contains(@class,'xdsoft_disabled'))]"));
			System.out.println("Block Date For "+list1.get(i)+" : "+disabledate.size());
			datenotfound = false;
			}
			else
			{
				 driver.findElement(By.cssSelector(".xdsoft_next")).click();
			}
		}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void logic() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		driver.findElement(By.id("track-order")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#onGoing > div > div.mdl-grid.mdl-grid--no-spacing > div > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--4-col-phone.mdl-cell--5-col-tablet.medium-font.font-base-medium.order-image > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--2-col-phone.mdl-cell--4-col-tablet.font-base-regular.ng-binding")));
		String inventeryitem=driver.findElement(By.cssSelector("#onGoing > div > div.mdl-grid.mdl-grid--no-spacing > div > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--4-col-phone.mdl-cell--5-col-tablet.medium-font.font-base-medium.order-image > div > div:nth-child(1) > div.mdl-cell.mdl-cell--7-col.mdl-cell--2-col-phone.mdl-cell--4-col-tablet.font-base-regular.ng-binding")).getText();
		System.out.println(inventeryitem);
		driver.navigate().to("http://flyrobe.com/a/"+inventeryitem);
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\Block.txt");
		//FileInputStream monthblock=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\city.txt");
		obj.load(fileinput);
		String city=obj.getProperty("city");
		String Blockdate=obj.getProperty("Blockmonth");
		String gender=obj.getProperty("gender");
		
		
		String cityadd;
		BufferedReader city1=new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\city.txt"));
		List<String> list1 = new ArrayList<String>();
		while((cityadd = city1.readLine()) != null){
		    list1.add(cityadd);
		    
		}
		
		for(int i=0;i<list1.size();i++)
		{
			Thread.sleep(5000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mdl-js-layout > header > flyrobe-header > div.top-header.utility-header.mdl-cell--hide-tablet.mdl-cell--hide-phone.overflowHidden.text-muted.mt-5 > nav > div > a.no-link.clickable")));
		driver.findElement(By.cssSelector("#mdl-js-layout > header > flyrobe-header > div.top-header.utility-header.mdl-cell--hide-tablet.mdl-cell--hide-phone.overflowHidden.text-muted.mt-5 > nav > div > a.no-link.clickable")).click();
		WebElement web1=driver.findElement(By.xpath(".//div[contains(@class,'selectize-control ng-pristine ng-untouched ng-valid single')]/descendant::input[contains(@id,'sample1-selectized')]"));
		
		web1.sendKeys(list1.get(i),Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("City is: "+list1.get(i));
		driver.navigate().refresh();
		Thread.sleep(2000);
		if(gender.equals("Men"))
		{
		driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing')]/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]/child::div[1]")).click();
				driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
		   Thread.sleep(2000);
		   try
		   {
		   	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
		   	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
		   }
		   catch(Exception e)
		   {
		   	wait.until(ExpectedConditions.elementToBeClickable(By.id("datetimepicker")));
		   	driver.findElement(By.id("datetimepicker")).click();
		   }
		}
	else
	{
		Thread.sleep(2000);
		try
		   {
		   	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
		   	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
		   }
		   catch(Exception e)
		   {
		   	wait.until(ExpectedConditions.elementToBeClickable(By.id("datetimepicker")));
		   	driver.findElement(By.id("datetimepicker")).click();
		   }
	}		
		Thread.sleep(1000);
	   	Boolean datenotfound = true;
		int MONTH1;
		while (datenotfound) {
			String getmonth=driver.findElement(By.cssSelector("body > div.xdsoft_datetimepicker.xdsoft_noselect.xdsoft_ > div.xdsoft_datepicker.active > div.xdsoft_mounthpicker > div.xdsoft_label.xdsoft_month > span")).getText();
			System.out.println(getmonth);
			if(getmonth.equalsIgnoreCase(Blockdate))
			{
			List<WebElement> disabledate=driver.findElements(By.xpath(".//div[contains(@class,'xdsoft_calendar')]/descendant::td[(contains(@class,'xdsoft_disabled'))]"));
			System.out.println("Block Date For "+list1.get(i)+" : "+disabledate.size());
			datenotfound = false;
			}
			else
			{
				 driver.findElement(By.cssSelector(".xdsoft_next")).click();
			}
		}
		Thread.sleep(5000);
	   	driver.navigate().refresh();
		Thread.sleep(2000);

		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
