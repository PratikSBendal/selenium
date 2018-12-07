package Flyrobe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flyrobe_together_order extends Flyrobe_config{
	
	//place order men eunsamble or non eunsamble
	String DATE,MONTH,finalDate;
	static int i;
	public void menshop() throws InterruptedException, IOException
	{
Flyrobe_details date=new Flyrobe_details();
		Thread.sleep(5000);
		//driver.navigate().to("http://flyrobe.com");
		 Thread.sleep(5000);
		 Actions action = new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver, 2000);
		 		driver.findElement(By.xpath("//nav[contains(@class,'mdl-navigation mdl-cell--hide-tablet mdl-cell--hide-phone font-base-regular')]/descendant::div[contains(@class,'header-flex')]/descendant::div[contains(@class,'hover-menu occasion-nav')]/child::a[contains(@title,'Men')]")).click();
		 
		 		driver.findElement(By.cssSelector("#mdl-js-layout > main > div.men-home-page.ng-scope.mv-35 > div > div.mdl-cell.mdl-cell--3-col.mdl-cell--hide-phone.mdl-cell--hide-tablet.navigation-men-left > ul.pl-0.pt-15 > li:nth-child(1) > a")).click();
		 		//WebElement moveonmenu = driver.findElement(By.xpath("//nav[contains(@class,'mdl-navigation mdl-cell--hide-tablet mdl-cell--hide-phone font-base-regular')]/descendant::div[contains(@class,'header-flex')]/descendant::div[contains(@class,'hover-menu occasion-nav')]/child::a[contains(@title,'Men')]"));
		 	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'hover-menu-content letter-spacing1 top-header')]/descendant::div[contains(@class,'mdl-grid mdl-grid--no-spacing pv-30 line-height-init hover-menu-section-detail')]/descendant::div[contains(@class,'pt-5')]/child::a[contains(text(),'View All')]")));

		 		// action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'hover-menu-content letter-spacing1 top-header')]/descendant::div[contains(@class,'mdl-grid mdl-grid--no-spacing pv-30 line-height-init hover-menu-section-detail')]/descendant::div[contains(@class,'pt-5')]/child::a[contains(text(),'View All')]"))).doubleClick().perform();
	       
//List Page
Thread.sleep(5000);
List<WebElement> itemselect=driver.findElements(By.xpath("//div[contains(@id,'focusDiv')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col mdl-cell--2-col-phone mdl-cell--4-col-tablet medium-font ng-scope')]"));

System.out.println(itemselect.size());
for(i=0;i<itemselect.size();i++)
System.out.println(itemselect.get(i).getText());

if(itemselect.size()==i)
{
	
	System.out.println(itemselect.get(0).getAttribute("!product.is_on_sale"));
	itemselect.get(4).click();
}
else
	System.out.println("Data not found");
//details page
Thread.sleep(5000);
//driver.navigate().refresh();
Thread.sleep(5000);
List<WebElement> inputbox1=driver.findElements(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]"));
List<String> list1=new ArrayList<String>();
for(WebElement data:inputbox1)
{
	list1.add(data.getText());
}
System.out.println(list1);

Thread.sleep(15000);
if(list1.contains("COLLAR SIZE"))
{
	Thread.sleep(5000);
	driver.findElement(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')and p[contains(text(),'Collar Size')]]/descendant::div[contains(@class,'dropdown-wrapper width95 inline')]")).click();
	driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
	driver.findElement(By.xpath("id(\"product-details\")/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')and p[contains(text(),'Waist Size')]]/descendant::div[contains(@class,'dropdown-wrapper width95 inline')]")).click();
	List<WebElement> list=driver.findElements(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]"));
System.out.println(list.size()-1);
list.get(list.size()-1).click();
Thread.sleep(15000);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
Thread.sleep(1000);
	

}
else
{
	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing')]/descendant::div[contains(@class,'mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone mb-20 ng-scope')]/child::div[1]")).click();
	driver.findElement(By.xpath("//div[contains(@for,'demo-size')]/descendant::ul[contains(@class,'pl-0')]/child::li[1]")).click();
	Thread.sleep(15000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")));
	driver.findElement(By.xpath("//div[contains(@class,'mdl-grid mdl-grid--no-spacing mob-center')]/descendant::div[contains(@id,'datetimepicker')]")).click();
	Thread.sleep(1000);
 // date.date();
		}
		date.detailsautodatepage();
driver.findElement(By.id("addToCart")).click();
	
}
	
}
