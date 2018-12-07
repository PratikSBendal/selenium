package flyrobe_web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class checkgoogle {
	@Test
	public void google()
	{
		WebDriver driver;
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://google.com");
	driver.findElement(By.id("lst-")).sendKeys("hello");
}
}