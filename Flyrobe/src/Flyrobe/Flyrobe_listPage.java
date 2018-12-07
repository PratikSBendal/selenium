package Flyrobe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Flyrobe_listPage extends Flyrobe_config{
	//Select product from list page within 18 product
	public void listpage() throws InterruptedException
	{
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	     int i;
		
		List<WebElement> itemselect=driver.findElements(By.xpath("//div[contains(@id,'focusDiv')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col mdl-cell--2-col-phone mdl-cell--4-col-tablet medium-font ng-scope')]"));
		
		System.out.println(itemselect.size());
		for(i=0;i<itemselect.size();i++)
		System.out.println(itemselect.get(i).getText());
	
		if(itemselect.size()==i)
		{
			
			System.out.println(itemselect.get(2).getAttribute("!product.is_on_sale"));
			itemselect.get(3).click();
		}
		else
			System.out.println("Data not found");
		Thread.sleep(1000);
			}


}
