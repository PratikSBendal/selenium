package Ofs_new;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.BeforeTest;

	public class Config_ofs {


		public static WebDriver driver;
		public static FileInputStream fileinput=null;
		
		public static Properties obj=null;
			
			
			public void Ofs_launch() throws IOException, InterruptedException
			{
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
				driver=new ChromeDriver();
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				driver.manage().window().maximize();
				//driver.get("http://web2.flyrobeapp.com:8000/dashboard/dashboard_v2/#/tables/customer-care");
				driver.get("http://web2.flyrobeapp.com:8000/dashboard/alpha/#/login");
				WebDriverWait wait = new WebDriverWait(driver, 20);
				fileinput=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\input.txt");
				obj = new Properties();
				obj.load(fileinput);
				String username=obj.getProperty("username");
				String pwd=obj.getProperty("pwd");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'panel panel-dark panel-flat login-panel')]/descendant::input[contains(@placeholder,'Username')]")));
				driver.findElement(By.xpath("//div[contains(@class,'panel panel-dark panel-flat login-panel')]/descendant::input[contains(@placeholder,'Username')]")).sendKeys(username);
				driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
				driver.findElement(By.xpath("//div[contains(@class,'panel-body')]/descendant::input[contains(@placeholder,'Password')]")).sendKeys(pwd);  
				driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
				Thread.sleep(5000);
				
		}
			
	}



