package Flyrobe_block_logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Flyrobe_listPage extends Flyrobe_config{
	//Select product from list page within 18 product
	public void listpage() throws InterruptedException, IOException
	{
		Thread.sleep(3000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	     int i,j;
		
		List<WebElement> itemselect=driver.findElements(By.xpath("//div[contains(@id,'focusDiv')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col mdl-cell--2-col-phone mdl-cell--4-col-tablet medium-font ng-scope')]"));
		fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe_block_logic\\Block.txt");
		obj.load(fileinput);
		int index=Integer.parseInt(obj.getProperty("selectitem"));
		System.out.println(itemselect.size());
		for(i=0;i<itemselect.size();i++)
		{
		System.out.println(itemselect.get(i).getText());
		}
		List<WebElement> price=driver.findElements(By.xpath("//div[contains(@id,'focusDiv')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col mdl-cell--2-col-phone mdl-cell--4-col-tablet medium-font ng-scope')]/descendant::div[contains(@class,'mdl-grid mdl-grid--no-spacing rental-values costGrid ng-scope')]/descendant::div[1]"));
		
		
		if(itemselect.size()==i)
		{
			
			System.out.println(itemselect.get(index).getAttribute("!product.is_on_sale"));
			itemselect.get(index).click();
		}
		else
			System.out.println("Data not found");
		Thread.sleep(1000);
			}


}
