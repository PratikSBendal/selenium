package Flyrobe_block_logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flyrobe_checkout extends Flyrobe_config{
	public void checkout() throws InterruptedException, IOException
	{
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		//Properties obj = new Properties();
		//FileInputStream objfile = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\flyrobe_web\\src\\flyrobe_web\\Address.txt");
		//obj.load(objfile);
		String name=obj.getProperty("name");
		String mail=obj.getProperty("mail");
	    String mobile=obj.getProperty("mobile");
		String pin=obj.getProperty("pin");
		String address=obj.getProperty("address");
		//add pin code
		BufferedReader pincoderead = new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\mdapin.txt"));
		//BufferedReader agrapinread=new BufferedReader(new FileReader("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\Flyrobe\\agrapin.txt"));
		String pincodeinsertinlistmumbai,pincodeinsertinlistagra;

		List<String> list1 = new ArrayList<String>();
		while((pincodeinsertinlistmumbai = pincoderead.readLine()) != null){
		    list1.add(pincodeinsertinlistmumbai);
		}
         System.out.println(list1);
         
//         List<String> list2 =new ArrayList<String>();
//         while((pincodeinsertinlistagra = agrapinread.readLine()) != null){
// 		    list2.add(pincodeinsertinlistagra);
// 		}
          //System.out.println(list2);
          
         //add address
	    driver.findElement(By.id("addIconTop")).click();
	    Thread.sleep(1000);
	    if(name.length()>0)
		{
    	   driver.findElement(By.id("name")).clear();
		   driver.findElement(By.id("name")).sendKeys(name);
		}
	    else
	    	   System.out.println("Name Not Correct");
	    
	    if(mail.endsWith(".com"))
        {	
  	        driver.findElement(By.id("mail")).clear();
   	        driver.findElement(By.id("mail")).sendKeys(mail);
          }
        else {
         System.out.println("Mail Not Corret");
        driver.close();
        }
	    
	    if(mobile.length()==10)
	      {	
		   driver.findElement(By.id("phone")).clear();
	       driver.findElement(By.id("phone")).sendKeys(mobile);
	      }
	    else {
			   System.out.println("Phone not valid");
	    driver.close();
	    }
	   
	    if(list1.contains(pin))
		  {
	        	 driver.findElement(By.id("pincode")).clear();
	            driver.findElement(By.id("pincode")).sendKeys(pin);
		  }
	    else {
	    System.out.println("Pin Not Corect");
	    driver.close();
	    }
	    if(address.length()>0)
        {
 	     driver.findElement(By.id("flat")).clear();
         driver.findElement(By.id("flat")).sendKeys(address);
         
       }
        else 
         
        System.out.println("Address Not Correct");
	    WebDriverWait wait = new WebDriverWait(driver, 2000);
driver.findElement(By.xpath("//div[contains(@id,'addAddressButtons')]/child::button[1]")).click();
Thread.sleep(5000);
//custom fit cloths
try {
	
	WebElement element = driver.findElement(By.xpath("id(\"mdl-js-layout\")/main[1]/div[1]/div[1]/div[1]/button[2]"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
   
driver.findElement(By.xpath("//button[contains(text(),'TAKE NEW')]")).click();
Thread.sleep(2000);
String storefecity=driver.findElement(By.cssSelector("#mdl-js-layout > main > div:nth-child(2) > div > div.mdl-cell.mdl-cell--8-col.leftContainer > div.panel.show > div:nth-child(1) > div.mdl-cell--8-col.checkoutPage-storeFulfilled-measurementContent > h6")).getText();
System.out.println(storefecity);
//fe store city measurnment selct 
if(storefecity.equals("Select Store Measurement"))
{
List<WebElement> placeOrder1 = driver.findElements(By.xpath(".//button[contains(text(),normalize-space('Give Measurements Online'))]"));
System.out.println(placeOrder1.size()-1);
Thread.sleep(2000);
placeOrder1.get(placeOrder1.size()-1).click();
}
//select non fe and not store 
else
{
wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mdl-js-layout > main > div:nth-child(2) > div > div.mdl-cell.mdl-cell--8-col.leftContainer > div.panel.show > div:nth-child(1) > div.mdl-cell--8-col.measurementContent > div:nth-child(4) > a:nth-child(1) > button")));
driver.findElement(By.cssSelector("#mdl-js-layout > main > div:nth-child(2) > div > div.mdl-cell.mdl-cell--8-col.leftContainer > div.panel.show > div:nth-child(1) > div.mdl-cell--8-col.measurementContent > div:nth-child(4) > a:nth-child(1) > button")).click();
}

Thread.sleep(2000);
WebElement moveonmenu1 = driver.findElement(By.xpath("id(\"online\")/label[1]/span[2]"));
action.moveToElement(moveonmenu1).moveToElement(driver.findElement(By.xpath("id(\"online\")/label[1]/span[2]"))).click().perform();

Thread.sleep(1000);
WebElement moveonmenu2 = driver.findElement(By.xpath("id(\"proceedNow\")/a[1]"));
action.moveToElement(moveonmenu2).moveToElement(driver.findElement(By.xpath("id(\"proceedNow\")/a[1]"))).click().perform();

Thread.sleep(1000);
driver.findElement(By.id("continueButton")).click();

Thread.sleep(1000);
WebElement moveonmenu3 = driver.findElement(By.xpath("//div[contains(@id,'payGrid')]/descendant::span[contains(text(),' CASH ON DELIVERY')]"));
action.moveToElement(moveonmenu3).moveToElement(driver.findElement(By.xpath("//div[contains(@id,'payGrid')]/descendant::span[contains(text(),' CASH ON DELIVERY')]"))).click().perform();
//driver.findElement(By.xpath("id(\"payGrid\")/div[1]/div[1]/ul[1]/a[2]/li[1]")).click();
Thread.sleep(1000);
List<WebElement> placeOrder = driver.findElements(By.xpath("//button[contains(@id,'cod') and text()=normalize-space('RENT NOW')]"));
System.out.println(placeOrder.size()-1);
placeOrder.get(placeOrder.size()-1).click();
System.out.println("Successfully Oreder Place");
Thread.sleep(2000);
}
//non cuctom cloths handle 
catch(Exception e)
{
	Thread.sleep(1000);
	WebElement moveonmenu3 = driver.findElement(By.xpath("//div[contains(@id,'payGrid')]/descendant::span[contains(text(),' CASH ON DELIVERY')]"));
	action.moveToElement(moveonmenu3).moveToElement(driver.findElement(By.xpath("//div[contains(@id,'payGrid')]/descendant::span[contains(text(),' CASH ON DELIVERY')]"))).click().perform();
	Thread.sleep(1000);
	List<WebElement> placeOrder = driver.findElements(By.xpath("//button[contains(@id,'cod') and text()=normalize-space('RENT NOW')]"));
	System.out.println(placeOrder.size()-1);
	placeOrder.get(placeOrder.size()-1).click();
	System.out.println("Successfully Oreder Place");
	Thread.sleep(2000);
}


}

}
