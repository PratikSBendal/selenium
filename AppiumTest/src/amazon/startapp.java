package amazon;


import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class startapp {
 
		
		public static void main(String[] args) throws MalformedURLException, InterruptedException {
 
			//File classpathRoot = new File(System.getProperty("user.dir"));
			//File appDir = new File(classpathRoot, "\\Apps\\Amazon");
			//File app = new File(appDir, "Amazon India Online Shopping_v14.2.0.300_apkpure.com.apk");
 			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", "LYF F8");
			capabilities.setCapability("platformVersion", "6.0.1");
			capabilities.setCapability("platformName", "Android");
			
		    capabilities.setCapability("appPackage","in.amazon.mShop.android.shopping"); 
			capabilities.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity"); 
			capabilities.setCapability("udid","8c98d341");
			 WebDriver driver;
			 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'in.amazon.mShop.android.shopping:id/web_home_shop_by_department_label')]")).click();
			//xpath("//android.widget.Button[contains(@resource-id,'digit5')]")

			 //driver.quit();
		 
	}
 
}