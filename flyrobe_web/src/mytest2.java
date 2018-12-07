
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class mytest2 {

	public static void main(String[] args) throws InterruptedException {
	WebDriver safari=new SafariDriver();	
	safari.manage().window().maximize();
	safari.get("http://alpha.flyrobeapp.com");
	safari.findElement(By.xpath("//*[@id=\"mdl-js-layout\"]/header/flyrobe-header/div[3]/div/nav[1]/div/div[1]/a")).click();//click women
	safari.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	safari.findElement(By.xpath("//*[@id=\"mdl-js-layout\"]/main/div[1]/div/div[1]/ul[3]/li[3]/a")).click();//etnic view all
	//safari.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
 //safari.findElement(By.xpath("//*[@id=\"focusDiv\"]/div[2]/product-card/div/div[2]/div[1]/div[2]/i[2]")).click();//heart click
	
	WebElement mainMenu = safari.findElement(By.xpath("//*[@id=\"focusDiv\"]/div[2]/product-card/div/div[2]/div[1]/div[1]/div"));// list page get data
	System.out.println("list page => "+mainMenu.getText());
	
	safari.findElement(By.xpath("//*[@id=\"focusDiv\"]/div[2]/product-card/div/div[1]/a/img")).click();//click selected item in list page
	safari.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	WebElement mainMenu1 = safari.findElement(By.xpath("//*[@id=\"product-details\"]/div[2]/div[2]/div[1]"));// detail page get data
	System.out.println("detail page => "+mainMenu1.getText());
	Thread.sleep(1000);
	
	if(mainMenu.equals(mainMenu1))
	{
		System.out.println("List page data and details page data match");
	}
	else {
		System.out.println("List page data and details page data not match");
	}
	safari.quit();
	}
 
}
