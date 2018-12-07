

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class mytest {

	public static void main(String[] args) {

		WebDriver safari=new SafariDriver();
       safari.get("http://alpha.flyrobeapp.com");
     
       safari.manage().window().maximize();
       safari.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
      
       Actions action = new Actions(safari);
       WebElement mainMenu = safari.findElement(By.xpath("//*[@id=\"mdl-js-layout\"]/header/flyrobe-header/div[3]/div/nav[1]/div/div[1]/a"));
       System.out.println("element find "+mainMenu.getText());
       action.moveToElement(mainMenu).build().perform();
       
      /* safari.findElement(By.xpath("//*[@id=\"genderHome\"]/span")).click();
       safari.findElement(By.xpath("//*[@id=\"mdl-js-layout\"]/main/div[1]/div[2]/div[2]/div/div[2]/div/div[3]/ul/li[1]")).click();
       safari.findElement(By.xpath("//*[@id=\"typeHome\"]/span")).click();
       safari.findElement(By.xpath("//*[@id=\"mdl-js-layout\"]/main/div[1]/div[2]/div[2]/div/div[2]/div/div[5]/ul/li[2]")).click();
       safari.findElement(By.xpath("//*[@id=\"homeSearchButton\"]/a/button")).click();*/
       	
} 

     
	}

