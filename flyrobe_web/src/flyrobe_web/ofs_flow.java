package flyrobe_web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ofs_flow {
	WebDriver driver;
	
	@Test(priority=1,description="fittingexpertassign test")
	public void fittingexpertassign()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		//driver.get("http://web2.flyrobeapp.com:8000/dashboard/dashboard_v2/#/tables/customer-care");
		driver.get("http://web2.flyrobeapp.com/dashboard/testDashboard/#/tables/customer-care");
		
	}
	@Test(priority=2,description="fittingexpertassign test")
	public void fittingexpertassignlogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'panel panel-dark panel-flat login-panel')]/descendant::input[contains(@placeholder,'Username')]")));
		driver.findElement(By.xpath("//div[contains(@class,'panel panel-dark panel-flat login-panel')]/descendant::input[contains(@placeholder,'Username')]")).sendKeys("pratik.bendal@flyrobe.com");
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(@class,'panel-body')]/descendant::input[contains(@placeholder,'Password')]")).sendKeys("pratik123");  
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		
	}
	@Test(priority=3,description="cctab")
	public void fittingexpertassigncctab()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//click order button cc tab
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".open > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")));
		driver.findElement(By.cssSelector(".open > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();//cli ck place reserv
		driver.findElement(By.cssSelector("li.dropdown:nth-child(2) > a:nth-child(1)")).click();//click all
		driver.findElement(By.cssSelector("li.dropdown:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));//click delhi
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::li[contains(@class,'ng-scope dropdown')]")).click();
		driver.findElement(By.cssSelector("li.dropdown:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")).click();//click delhi child city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city 
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::button[contains(@class,'btn btn-primary topnav-btn')]")).click();
		driver.findElement(By.xpath("id(\"DataTables_Table_0\")/tbody[1]/tr[1]/td[2]")).click();//click table
		driver.findElement(By.xpath("//div[contains(@class,'panel panel-default ng-scope')]/descendant::select[contains(@class,'form-control item-details-selct ng-pristine ng-untouched ng-valid ng-empty')]")).click();//dropdown list
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div:nth-child(2) > div:nth-child(6) > div.ibox-content.cc-item > div > div > div.col-xs-9.no-padding > table.table.ng-scope > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select > option:nth-child(2)")).click();//select schedule
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::button[contains(@class,'btn btn-primary btn-block')]")).click();//click submit button			
		
	}
	
	@Test(priority=4,description="omtab")
	public void fittingexpertassignomtab() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions action = new Actions(driver);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Thread.sleep(5000);
		driver.navigate().refresh();
		//Thread.sleep(5000);
		WebElement moveonmenu = driver.findElement(By.xpath("id(\"side-menu\")/li[3]/a[1]"));
		action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("id(\"side-menu\")/li[3]/ul[1]/li[1]/a[1]"))).click().perform();
		 driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//clicked confrim measeured
		 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::ul[contains(@role,'menu')]/child::li[2]")).click();//clicked reserve measure
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[3]/a")).click();//clicke child city box
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::ul[contains(@role,'menu')]/child::li[2]")));
		//driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::ul[contains(@role,'menu')]/child::li[2]")).click();//clicked child city
		driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.ng-scope.dropdown.open > ul > li:nth-child(2) > a")).click();//clicked child city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
		driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
		
		//Craete FE
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Measurement Time & Address ')]")));
		driver.findElement(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Measurement Time & Address ')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ibox-content om-address')]/descendant::label[contains(@class,'toggleSwitch-label')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/span[1]")));
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
		WebElement web1=driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div[1]/div[1]/input[1]"));
		web1.sendKeys("Pratik",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Create FE Trip']")).click();
		driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();
		Thread.sleep(500);
		
		//Select FE
		
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div/input[1]")).sendKeys("Pratik",Keys.ENTER);
		//driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[3]/div[2]/div[4]/div[1]/button[1]")).click();
		//driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();
		Thread.sleep(500);
		//Select Status
		
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Fitting Expert Assigned'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		
		//Out For Measurnment
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")));
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
		driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Out For Measurement'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		
		//Measured
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
		driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Measured'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		
		//confrim for final delivery
		

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
		driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Confirm For Final Delivery'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		
		//Alterd
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();//clicked confrim measeured
		 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::ul[contains(@role,'menu')]/child::li[1]")).click();//clicked reserve confrim
		 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
			driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
			Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
			driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select")).click();
			driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Altered'))]")).click();
			driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		
			//In QC Reserve	
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
			driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
			Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
			driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select")).click();
			driver.findElement(By.xpath(".//option[contains(text(),normalize-space('In Qc Reserve'))]")).click();
			driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
			
			//Package
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
			driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
			driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(@ng-click,'omConfirm.searchData()')]")).click();//click get data button
			Thread.sleep(2000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")));
			driver.findElement(By.xpath(".//*[contains(@id,'DataTables_Table')]/tbody/tr/td[1]")).click();
			driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > thead > tr:nth-child(2) > td.no-border.item-details-select-td.ng-scope > select")).click();
			driver.findElement(By.xpath(".//option[contains(text(),normalize-space('Packaged'))]")).click();
			driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();	
		
			Thread.sleep(5000);
			driver.navigate().refresh();
	}	
	@Test(priority=5,description="omtablogistic")
	public void fittingexpertassignomlogistictab() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement moveonmenu = driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[3]"));
		action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//a[text()='Logistics']"))).click().perform();
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		driver.findElement(By.xpath("id(\"side-menu\")/li[1]/a[1]")).click();
	    //driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();
		driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.dropdown.open > ul > li:nth-child(1) > a")).click();	
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/div/ul/li[3]/a")).click();//clicke child city box
		driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.ng-scope.dropdown.open > ul > li:nth-child(2) > a")).click();//clicked child city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'row')]/descendant::div[contains(@class,'col-lg-6')]/child::button[1]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")));
		driver.findElement(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")).click();
		//bikler trip
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Delivery Time & Address ')]")));
		driver.findElement(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Delivery Time & Address ')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ibox-content om-address')]/descendant::label[contains(@class,'toggleSwitch-label')]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
		WebElement web1=driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div[2]/div[2]/div[5]/div[2]/div[5]/div[1]/div/div/input[1]"));
		web1.sendKeys("Pratik",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Create Bike Trip']")).click();
		driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();
		Thread.sleep(500);
		//select biker
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[3]/div[1]/div[4]/div[1]/input[1]")).sendKeys("Pratik",Keys.ENTER);
		//driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[5]/div[2]/div[3]/div[2]/div[4]/div[1]/button[1]")).click();
	   // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"page-top\"]/div[4]/div[7]/button[2]")));
		//driver.findElement(By.xpath("//*[@id=\"page-top\"]/div[4]/div[7]/button[2]")).click();
		Thread.sleep(500);
		//select ststus
		
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table.table.ng-scope > tbody > tr > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('Delivery Boy Assign'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		Thread.sleep(5000);
		//out for delivery

		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")));
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'row')]/descendant::div[contains(@class,'col-lg-6')]/child::button[1]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")));
		driver.findElement(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table.table.ng-scope > tbody > tr > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('Out For Delivery'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		//deliver
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")));
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]/descendant::div[contains(@class,'col-lg-6')]/descendant::button[contains(text(),'Get Data')]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]")));
		driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]")).click();

		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(6) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table.table.ng-scope > tbody > tr > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('Delivered'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/button[1]")).click();
		//cc tab pickup scheduled
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();
		driver.findElement(By.cssSelector(".open > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")).click();
		driver.findElement(By.cssSelector("li.dropdown:nth-child(2) > a:nth-child(1)")).click();//click all
		driver.findElement(By.cssSelector("li.dropdown:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)"));//click delhi
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::li[contains(@class,'ng-scope dropdown')]")).click();
		driver.findElement(By.cssSelector("li.dropdown:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")).click();//click delhi child city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();//select city 
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();//select mumbai city
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");//Enetr order no
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::button[contains(@class,'btn btn-primary topnav-btn')]")).click();
		driver.findElement(By.xpath("id(\"DataTables_Table_0\")/tbody[1]/tr[1]/td[2]")).click();//click table
		//Thread.sleep(5000);
		
	driver.findElement(By.xpath("//div[contains(@class,'panel panel-default ng-scope')]/descendant::select[contains(@class,'form-control item-details-selct ng-pristine ng-untouched ng-valid ng-empty')]")).click();
	driver.findElement(By.xpath("//option[contains(text(),normalize-space('Pickup Scheduled'))]")).click();
	driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/div[1]/button[1]")).click();
		
		
//		//logistic tab pickup
		Thread.sleep(5000);
		WebElement moveonmenu1 = driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[3]"));
		action.moveToElement(moveonmenu1).moveToElement(driver.findElement(By.xpath("//a[text()='Logistics']"))).click().perform();
		driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//div[contains(@class,'col-lg-7')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")));
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::a[contains(@class,'navbar-item dropdown-toggle')]")).click();
         driver.findElement(By.cssSelector("#navbar > div:nth-child(1) > div > ul > li.dropdown.open > ul > li:nth-child(2) > a")).click();  		
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");
		driver.findElement(By.xpath("//div[contains(@class,'row')]/descendant::div[contains(@class,'col-lg-6')]/child::button[1]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")));
		driver.findElement(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")).click();
		//select trip
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Pickup Time & Address ')]")));
		driver.findElement(By.xpath("//div[contains(@class,'ibox')]/descendant::h5[contains(text(),' Pickup Time & Address ')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ibox-content om-address')]/descendant::label[contains(@class,'toggleSwitch-label')]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/span[1]")).click();
		WebElement web2=driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div[5]/div[1]/div[1]/div[1]/input[1]"));
		web2.sendKeys("Pratik",Keys.ENTER);
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div[5]/div[2]/button[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")));
		driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();
		
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div[3]/div[1]/div[4]/div[1]/input[1]")).sendKeys("Pratik",Keys.ENTER);
		/*driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div[3]/div[2]/div[4]/div[1]/button[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")));
		driver.findElement(By.xpath("id(\"page-top\")/div[4]/div[7]/button[2]")).click();*/

		//select statusS
	
        Thread.sleep(2000);
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[7]/div[2]/div[1]/div[1]/div[2]/table[2]/tbody[1]/tr[1]/td[2]/select[1]")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('Out For Pickup'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[8]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@class,'ui-select-match ng-scope')]")).click();
		driver.findElement(By.cssSelector("div.ui-select-choices-row:nth-child(3) > a:nth-child(1) > div:nth-child(1)")).click();
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-6')]/descendant::input[contains(@placeholder,'Order Id')]")).sendKeys("FMR094165");		
		driver.findElement(By.xpath("//div[contains(@class,'row')]/descendant::div[contains(@class,'col-lg-6')]/child::button[1]")).click();//click get data button
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")));
		driver.findElement(By.xpath("id(\"example\")/tbody[1]/tr[1]/td[1]")).click();	
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(7) > div.ibox-content.om-item > div > div > div.col-xs-9.no-padding > table.table.ng-scope > tbody > tr > td.no-border.item-details-select-td.ng-scope > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('Picked Up'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[8]/button[1]")).click();
		Thread.sleep(2000);
			}
	@Test(priority=6,description="pickup")
	public void fittingexpertassignpickuptab() throws InterruptedException
	{
			WebDriverWait wait = new WebDriverWait(driver, 100);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement moveonmenu = driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[4]"));
		action.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//a[text()='Picked Up']"))).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navbar\"]/ul/li[3]/a")));
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//a[contains(text(),normalize-space('Child Cities Orders'))]")).click();
		//In QC return
        Thread.sleep(20000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("id(\"DataTables_Table_0_filter\")/label[1]/input[1]")));
		driver.findElement(By.xpath("id(\"DataTables_Table_0_filter\")/label[1]/input[1]")).sendKeys("FMR094165");
		Thread.sleep(2000);
		driver.findElement(By.xpath("id(\"DataTables_Table_0\")/tbody[1]/tr[1]/td[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(1) > div.ibox-content.laundry-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > tbody > tr > td.no-border.item-details-select-td > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('In Post Return Qc'))]")).click();
		driver.findElement(By.xpath("//button[contains(text(),normalize-space('Update Status'))]")).click();
		//Qc done
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[15]")));
		driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[15]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div:nth-child(1) > div.col-lg-6 > div > div > div > div:nth-child(1) > input")).sendKeys("FMR094165");
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div.ibox-content.cc-item > div > div > div.col-xs-8.no-padding > table:nth-child(3) > tbody > tr > td:nth-child(3) > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('Qc Done(sd Initiated)'))]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		
		Thread.sleep(1000);
		
		WebElement moveonmenu1 = driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[4]"));
		action.moveToElement(moveonmenu1).moveToElement(driver.findElement(By.xpath("//a[text()='Laundry Items']"))).click().perform();
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@id,'DataTables_Table_0_filter')]/descendant::input[contains(@type,'search')]")));
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@id,'DataTables_Table_0_filter')]/descendant::input[contains(@type,'search')]")).sendKeys("FRES10622-XL-25986");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(1) > div.ibox-content.laundry-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > tbody > tr > td.no-border.item-details-select-td > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('In Post Laundry Qc'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
		//is Live
		Thread.sleep(2000);
		WebElement moveonmenu2 = driver.findElement(By.xpath("//div[contains(@class,'sidebar-collapse')]/descendant::ul[contains(@id,'side-menu')]/child::li[4]"));
		action.moveToElement(moveonmenu2).moveToElement(driver.findElement(By.xpath("//a[text()='Laundry Items']"))).click().perform();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@id,'DataTables_Table_0_filter')]/descendant::input[contains(@type,'search')]")));
		driver.findElement(By.xpath("//div[contains(@class,'col-lg-12')]/descendant::div[contains(@id,'DataTables_Table_0_filter')]/descendant::input[contains(@type,'search')]")).sendKeys("FRES10622-XL-25986");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[1]")).click();
		driver.findElement(By.cssSelector("#page-wrapper > div:nth-child(2) > div > div.row > div.col-lg-5 > div:nth-child(1) > div.ibox-content.laundry-item > div > div > div.col-xs-9.no-padding > table:nth-child(3) > tbody > tr > td.no-border.item-details-select-td > select")).click();
		driver.findElement(By.xpath("//option[contains(text(),normalize-space('Is Live'))]")).click();
		driver.findElement(By.xpath("id(\"page-wrapper\")/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();	
		Thread.sleep(5000);
	}
	@Test(priority=7,description="logout")
	public void fittingexpertassignlogot() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),normalize-space('pratik.bendal@flyrobe.com'))]")).click();
		driver.findElement(By.xpath("//a[contains(text(),normalize-space('Log out'))]")).click();
		driver.quit();
	}
	
	}