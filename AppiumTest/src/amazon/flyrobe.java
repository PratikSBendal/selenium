package amazon;

//import java.awt.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class flyrobe {

	public static void main(String[] args) throws MalformedURLException ,InterruptedException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "LYF F8");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		
		
	    capabilities.setCapability("appPackage","com.flyrobe.android"); 
		capabilities.setCapability("appActivity","com.flyrobe.android.ui.activity.SplashActivity"); 
		capabilities.setCapability("udid","8c98d341");
		AndroidDriver driver;
		 driver = (AndroidDriver) new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities); 
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'com.flyrobe.android:id/btn_men')]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'com.flyrobe.android:id/edtMobileNumber')]")).sendKeys("8888888888");
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'com.flyrobe.android:id/btnProceed')]")).click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'com.flyrobe.android:id/ll_google_login')]")).click();
		//first time gmail login
	    //driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@index,'2')]")).click();

	
		  driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		  
		  List<WebElement> cities= driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'com.flyrobe.android:id/rv_city_list')]/descendant::android.widget.LinearLayout[contains(@resource-id,'com.flyrobe.android:id/city_bg_layout')]"));
		  System.out.println(cities);
		  cities.get(6).click();
            driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'com.flyrobe.android:id/dmsv_home')]")).click();
         //   WebElement menu1=driver.findElement(By.xpath("//android.widget.HorizontalScrollView"))
            
            
		  
	
		  /*driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'com.flyrobe.android:id/city_bg_layout')]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'com.flyrobe.android:id/image_horizontal')]")).click();
		driver.findElement(By.xpath("//com.flyrobe.android:id/image_horizontal[contains(@index,'1')]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@index,'12' )]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@index,'18')]")).click();
	    driver.findElement(By.xpath("//android.widget.Button[conatins(@index,'8')]")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[contains(@index,'10')]")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[contains(@index,'27')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@index,'7')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@index,'2')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@index,'4')]")).click();
		driver.findElement(By.xpath("//android.support.v7.app.ActionBar$Tab[contains(@index,'2')]")).click();
		driver.findElement(By.xpath("//android.widget.RadioButton[contains(@index,'0')]")).click();
		driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'com.flyrobe.android:id/btn_checkout_card_cash')]")).click();*/
		//driver.quit();
	 
	}

}
