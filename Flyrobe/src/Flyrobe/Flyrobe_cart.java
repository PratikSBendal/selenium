package Flyrobe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flyrobe_cart extends Flyrobe_config {
	public void cart() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 2000);
	       Actions action = new Actions(driver);
	      
	     WebElement moveonmenu = driver.findElement(By.xpath("//div[contains(@class,'main-content cart-sectionp pb-0 ng-scope')]/descendant::div[contains(@class,'mdl-grid standard-width')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col  mdl-cell--8-col-tablet mdl-cell--4-col-phone')]/descendant::div[contains(@class,'coupon-cart-place-order-btn text-center width100 mt-20 couponButtonM1 ng-scope')]/child::a[1]"));
				action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'main-content cart-sectionp pb-0 ng-scope')]/descendant::div[contains(@class,'mdl-grid standard-width')]/descendant::div[contains(@class,'mdl-cell mdl-cell--4-col  mdl-cell--8-col-tablet mdl-cell--4-col-phone')]/descendant::div[contains(@class,'coupon-cart-place-order-btn text-center width100 mt-20 couponButtonM1 ng-scope')]/child::a[1]"))).click().perform();
		    		  
	       
	
	
	}
}
