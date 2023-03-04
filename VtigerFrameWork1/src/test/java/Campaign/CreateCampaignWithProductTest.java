package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utilities.Base_Class;
import Generic_utilities.Excel_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Property_Utility;
import Generic_utilities.WebDriver_Utility;
import POM_Repo.CampaignCreatePage;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ProductCreatePage;


public class CreateCampaignWithProductTest extends Base_Class
{

	@Test(groups={"SmokeTest","RegressionTest"})
	public void createCampaignWithProductTest() throws Throwable 
	//public static void main(String[] args) throws Throwable 
	{
		/*String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();*/
		
		//Property_Utility plib=new Property_Utility();
		/*String BROWSER = plib.getKeyValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver(); 
		}*/
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.waitForPageToLoad(driver);
		wlib.maximizeWindow(driver);
		//driver.manage().window().maximize();

		// Fetching data from property file
		/*FileInputStream fis = new FileInputStream("src/test/resources/vtigerpropertyfile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		//added in base class
		/*String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");

		driver.get(URL);*/
		
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();*/
		
		//added in base class
		/*Login_Page lp=new Login_Page(driver);
		lp.loginToApp(USERNAME, PASSWORD);*/

		// click on product
		//driver.findElement(By.linkText("Products")).click();
		Home_Page home=new Home_Page (driver);
		home.clickProductLink();
		
		// click on plus icon
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		ProductCreatePage productpage=new ProductCreatePage(driver);
		productpage.clickPlusIcon();

		// handle random popup
	    /*Random r = new Random();
		int rnum = r.nextInt(500);*/
		Java_Utility jlib=new Java_Utility();
		int rnum = jlib.getRanNum();

		// Fetching product data from excel
		/*FileInputStream fise = new FileInputStream("src/test/resources/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sh = book.getSheet("Product");
		Row rownum = sh.getRow(0);
		Cell cellnum = rownum.getCell(0);
		String productname = cellnum.getStringCellValue() + rnum;*/
		Excel_Utility elib=new Excel_Utility();
		//String productname=elib.getExcelData("Product", 0, 0)+rnum;
		//By using DataFormatter i am calling method
		String productname = elib.getExcelDataByUsingDataFormatter("Product", 0, 0)+rnum;
		

		//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
		  productpage.ClickinProductName(productname);
		
		
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		  productpage.clickSaveButton();
		Thread.sleep(2000);

		// click on more option
		//driver.findElement(By.linkText("More")).click();
		home.clickMoreOption();
		
		
		
		// click on campaign
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		home.clickCampaignlink();

		// click on plus icon
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampaignCreatePage campaignpage=new CampaignCreatePage (driver);
		campaignpage.clickPlusIcon();

		
		// Fetching campaign data from excel
		/*Sheet sh1 = book.getSheet("Campaign");
		Row rownum1 = sh1.getRow(0);
		Cell cellnum1 = rownum1.getCell(0);
		String campaignname = cellnum1.getStringCellValue();*/
		//Excel_Utility elib1=new Excel_Utility();//already created thats why i commented it see above
		//String campaignname = elib.getExcelData("Campaign", 0, 0);
		//By using DataFormatter i am calling method
		String campaignname = elib.getExcelDataByUsingDataFormatter("Campaign", 0, 0);
		

		//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignname);
		campaignpage.ClickinCampaignName(campaignname);
		
		// click on product plus icon
		//driver.findElement(By.xpath("//img[@alt='Select']")).click();
		campaignpage.clickproductPlusIcon();

		// Handle window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		

		// enter data into search text field 
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("laptop", Keys.ENTER);
		//dynamic xpath we used if values are changing every time so we store it into variable and use that variable every time like productname
		
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productname);
		campaignpage.clickSearchProductName(productname);
		
		//click on search button
		//driver.findElement(By.xpath("//input[@name='search']")).click();
		campaignpage.clickSearchButton();
		  
		Thread.sleep(2000);
		// select product name 
		
		//driver.findElement(By.xpath("//a[text()='Mobile215']")).click();
		
		//here we used dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
		Thread.sleep(2000);
		
		
		
		
		// switch to parent window
		driver.switchTo().window(parentId);
		// click on save button
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		campaignpage.clickSaveButton();
		
		//validation
		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		Assert.assertEquals(campaignname, actData);
		/*if(actData.contains(campaignname))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
					
		

		Thread.sleep(2000);
		// click on administrator
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		
		//added in base class
		//home.clickSignoutLink(driver);
		
		// click on signout
		//driver.findElement(By.linkText("Sign Out")).click();

	}
	/*
	@Test
	public void m1()
	{
		System.out.println("m1 is running");
	}*/

}
