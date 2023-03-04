package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utilities.Base_Class;
import Generic_utilities.Excel_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Property_Utility;
import Generic_utilities.WebDriver_Utility;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.OrganizationCreatePage;
import POM_Repo.ProductCreatePage;
import POM_Repo.Validation;
import Product.CreateProductTest;


public class CreateOrgnizationTest extends Base_Class
{

	@Test(retryAnalyzer=Generic_utilities.RetryAnalyzer.class)
	public void createOrgnizationTest()throws Throwable
	//public static void main(String[] args) throws Throwable 
	{
		/*String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/ ");*/
		
		//added in base class
		Property_Utility plib=new Property_Utility();
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
		
		//Fetching Data From Notepad
		/*FileInputStream fis=new FileInputStream("src/test/resources/vtigerpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		
		//added in base class
		/*String URL =plib.getKeyValue("url");
		String USERNAME =plib.getKeyValue("username");
		String PASSWORD =plib.getKeyValue("password");
		
		driver.get(URL);*/
		
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//added in base class
		/*Login_Page lp=new Login_Page(driver);
		lp.loginToApp(USERNAME, PASSWORD);*/
		
		//click on organization
		Thread.sleep(2000);
		
		//driver.findElement(By.linkText("Organizations")).click();
		Home_Page home=new Home_Page(driver);
		home.clickOrganizationLink();
		
		Thread.sleep(2000);
		//click on plus icon
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click(); 
		OrganizationCreatePage orgpage=new OrganizationCreatePage(driver);
		orgpage.clickPlusIcon();
		
		//to capture screenshot intentionally i have added hard assert to failed the script the below line, we can remove it later 
		Assert.assertEquals(false, true);
		
		//Handle alert popup using random class to avoid duplicate
		/*Random r=new Random();
		int rnum = r.nextInt(5);*/
		
		//Handle alert popup by using generic utility(keeping common methods inside java_utility class)
		Java_Utility jlib=new Java_Utility();
		int rnum = jlib.getRanNum();
		
		
		//Fetching Data From Excel
		/*FileInputStream fise=new FileInputStream("src/test/resources/ExcelData.xlsx");
		Workbook book=WorkbookFactory.create(fise);
		Sheet sheetname = book.getSheet("Organization");
		Row rownum = sheetname.getRow(0);
		Cell cellnum = rownum.getCell(0);
		String orgName = cellnum.getStringCellValue()+rnum;*/
		Excel_Utility elib=new Excel_Utility();
		//String orgName = elib.getExcelData("Organization", 0, 0)+rnum;
		//By using DataFormatter i am calling method
		String orgName=elib.getExcelDataByUsingDataFormatter("Organization", 0, 0)+rnum;
		
		//enter orgname
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		orgpage.ClickinOrganizationName(orgName);
		
		
		//click on save button
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		orgpage.clickSaveButton();
		Thread.sleep(2000);
		
		//click on administrator image
		//driver.findElement(By.xpath("(//td[@class=\"small\"])[2]")).click();
		
		//validation
		//String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		/*if(actData.contains(orgName))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		
		//validayion using assertion fetching data from pom validation
		//String actData=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		Validation val=new Validation(driver);
		String actData=val.orgvalidate(driver, orgName);
		Assert.assertEquals(orgName, actData);		
		
		//click on logout button
		//driver.findElement(By.linkText("Sign Out")).click();
		
		//added in base class
		//home.clickSignoutLink(driver);
		
		
		
	}
	
	//Copied code of create product for regional regression testing
	@Test
	public void createProductTest()throws Throwable
	//public static void main(String[] args) throws Throwable 
	{
		/*String key="webdriver.chrome.driver";
		String value="src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();*/
		
		
		//added in base class
		Property_Utility plib=new Property_Utility();
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
		
		/*FileInputStream fis=new FileInputStream("src/test/resources/vtigerpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		
		//added in base class
		/*String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD =plib.getKeyValue("password");
		
		driver.get(URL);*/
		
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("(//input[@value='Login'])[2]")).click();*/
		
		//added in base class
		/*Login_Page lp=new Login_Page(driver);
		lp.loginToApp(USERNAME, PASSWORD);*/
		
		//driver.findElement(By.linkText("Products")).click();
		Home_Page home=new Home_Page(driver);
		home.clickProductLink();
		
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		ProductCreatePage productpage=new ProductCreatePage(driver);
		productpage.clickPlusIcon();
		
	  /*Random r=new Random();
		int rnum = r.nextInt(500);*/
		Java_Utility jlib=new Java_Utility();
		int rnum = jlib.getRanNum();
		
		//Fetching data from excel
		/*FileInputStream fise=new FileInputStream("src/test/resources/ExcelData.xlsx");
		Workbook book=WorkbookFactory.create(fise);
		 Sheet sh = book.getSheet("Product");
		 Row rownum = sh.getRow(0);
		 Cell cellnum = rownum.getCell(0);
		 String productname = cellnum.getStringCellValue()+rnum;*/
		Excel_Utility elib=new Excel_Utility();
		//String productname = elib.getExcelData("Product", 0, 0)+rnum;
		//By using DataFormatter i am calling method
		String productname = elib.getExcelDataByUsingDataFormatter("Product", 0, 0)+rnum;
		 
		 
		 //driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
		 productpage.ClickinProductName(productname);
		 
		 //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		 productpage.clickSaveButton();
		 
		// validation
		String actData = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		if (actData.contains(productname))
		{
			System.out.println("pass");
		} 
		else 
		{
			System.out.println("fail");
		}
		 
		 
		 
		 /*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 driver.findElement(By.linkText("Sign Out")).click();*/
		
		//added in base class
		 //home.clickSignoutLink(driver);
		 
		 
		 
		 
		
		
		
	}

		
	

}
