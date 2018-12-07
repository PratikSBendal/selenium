import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.applet.*;
import java.awt.TextArea;
@Test
public class texttest  {
	public void text_test()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		
		driver.get("http://alpha.flyrobeapp.com/groom-dress-collection");
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//div[contains(@class,'city-checkbox inline-block ng-scope')]/child::label[contains(@for,'chandigarhCity')]")).click();
		
		
		/*WebElement text1=driver.findElement(By.xpath(".//span[contains(@class,'free-home-delivery')]"));
		String font_family=text1.getCssValue("font-family");
		System.out.println("Free Home Delivery & Free Pick-Up : "+font_family);
		String font="Roboto";
		if(font_family.equalsIgnoreCase(font))
		{
			System.out.println("Font-family match");
		}else
		{
			System.out.println("Font-family not match");
		}
	
		String width=text1.getCssValue("width");
		System.out.println("Free Home Delivery & Free Pick-Up : "+width);
		String width1="138px";
		if(width.equalsIgnoreCase(width1))
		{
			System.out.println("Width match");
		}else
		{
			System.out.println("Width not match");
		}
		
		String height=text1.getCssValue("height");
		System.out.println("Free Home Delivery & Free Pick-Up : "+height);
		String height1="30px";
		if(height.equalsIgnoreCase(height1))
		{
			System.out.println("height match");
		}else
		{
			System.out.println("height not match");
		}
		
		String fontsize=text1.getCssValue("font-size");
		System.out.println("Free Home Delivery & Free Pick-Up : "+fontsize);
		String fontsize1="13px";
		if(fontsize.equalsIgnoreCase(fontsize1))
		{
			System.out.println("font match");
		}else
		{
			System.out.println("font not match");
		}	
		
		String fontweight=text1.getCssValue("font-weight");
		System.out.println("Free Home Delivery & Free Pick-Up : "+fontweight);
		String fontweight1="500";
		if(fontweight.equalsIgnoreCase(fontweight1))
		{
			System.out.println("fontweight match");
		}else
		{
			System.out.println("fontweight not match");
		}
		
		
		String lineheight=text1.getCssValue("line-height");
		System.out.println("Free Home Delivery & Free Pick-Up :"+lineheight);
		String lineheight1="1.15";
		if(lineheight.equalsIgnoreCase(lineheight1))
		{
			System.out.println("lineheight match");
		}else
		{
			System.out.println("lineheight not match");
		}
		
		String letterspacing=text1.getCssValue("letter-spacing");
		System.out.println("Free Home Delivery & Free Pick-Up : "+letterspacing);
		String letterspacing1="0.3px";
		if(letterspacing.equalsIgnoreCase(letterspacing1))
		{
			System.out.println("letterspacing match");
		}else
		{
			System.out.println("letterspacing not match");
		}
		
		String textalign=text1.getCssValue("text-align");
		System.out.println("Free Home Delivery & Free Pick-Up : "+textalign);
		String textalign1="left";
		if(textalign.equalsIgnoreCase(textalign1))
		{
			System.out.println("textalign match");
		}else
		{
			System.out.println("textalign not match");
		}
		
		String color=text1.getCssValue("color");
		System.out.println("Free Home Delivery & Free Pick-Up : "+height);
		String color1="#656873";
		if(color.equalsIgnoreCase(color1))
		{
			System.out.println("color match");
		}else
		{
			System.out.println("color not match");
		}*/
		WebElement text2=driver.findElement(By.xpath("//span[contains(@class,'planning-to-buy-a-sh')]"));
		String font_family=text2.getCssValue("font-family");
		System.out.println("Free Home Delivery & Free Pick-Up : "+font_family);
		String font="AvenirNextLTPro-Demi";
		if(font_family.equalsIgnoreCase(font))
		{
			System.out.println("Font-family match");
		}else
		{
			System.out.println("Font-family not match");
		}
	
		String width=text2.getCssValue("width");
		System.out.println("Free Home Delivery & Free Pick-Up : "+width);
		String width1="494px";
		if(width.equalsIgnoreCase(width1))
		{
			System.out.println("Width match");
		}else
		{
			System.out.println("Width not match");
		}
		
		String height=text2.getCssValue("height");
		System.out.println("Free Home Delivery & Free Pick-Up : "+height);
		String height1="141px";
		if(height.equalsIgnoreCase(height1))
		{
			System.out.println("height match");
		}else
		{
			System.out.println("height not match");
		}
		
		String fontsize=text2.getCssValue("font-size");
		System.out.println("Free Home Delivery & Free Pick-Up : "+fontsize);
		String fontsize1="36px";
		if(fontsize.equalsIgnoreCase(fontsize1))
		{
			System.out.println("font match");
		}else
		{
			System.out.println("font not match");
		}	
		
		
		String lineheight=text2.getCssValue("line-height");
		System.out.println("Free Home Delivery & Free Pick-Up :"+lineheight);
		String lineheight1="1.31";
		if(lineheight.equalsIgnoreCase(lineheight1))
		{
			System.out.println("lineheight match");
		}else
		{
			System.out.println("lineheight not match");
		}
		
		String letterspacing=text2.getCssValue("letter-spacing");
		System.out.println("Free Home Delivery & Free Pick-Up : "+letterspacing);
		String letterspacing1="0.1px";
		if(letterspacing.equalsIgnoreCase(letterspacing1))
		{
			System.out.println("letterspacing match");
		}else
		{
			System.out.println("letterspacing not match");
		}
		
		String textalign=text2.getCssValue("text-align");
		System.out.println("Free Home Delivery & Free Pick-Up : "+textalign);
		String textalign1="left";
		if(textalign.equalsIgnoreCase(textalign1))
		{
			System.out.println("textalign match");
		}else
		{
			System.out.println("textalign not match");
		}
		
		String color=text2.getCssValue("color");
		System.out.println("Free Home Delivery & Free Pick-Up : "+height);
		String color1="#ffffff";
		if(color.equalsIgnoreCase(color1))
		{
			System.out.println("color match");
		}else
		{
			System.out.println("color not match");
		}
	}

}
