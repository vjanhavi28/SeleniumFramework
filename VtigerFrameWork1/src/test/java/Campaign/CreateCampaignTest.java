package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utilities.Base_Class;
import Generic_utilities.Excel_Utility;
import Generic_utilities.Property_Utility;
import Generic_utilities.WebDriver_Utility;
import POM_Repo.CampaignCreatePage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateCampaignTest extends Base_Class {
	@Test(groups="SmokeTest")
	public void createCampaignTest()throws Throwable
	//public static void main(String[] args) throws Throwable 
	{
		/*String key="webdriver.chrome.driver";
		String value="src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();*/
		
		
		
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
		
		
		//Fetching data from property file
		/*FileInputStream fis=new FileInputStream("src/test/resources/vtigerpropertyfile.properties");
		Properties pro=new Properties();
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
		
		//click on more option
		//driver.findElement(By.linkText("More")).click();
		Home_Page home=new Home_Page(driver);
		home.clickMoreOption();
		
		//click on campaign
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		home.clickCampaignlink();
		
		//click on plus icon
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampaignCreatePage campaignpage=new CampaignCreatePage(driver);
		campaignpage.clickPlusIcon();
		
		Thread.sleep(2000);
		
		//Fetching data from excel
		 /*FileInputStream fise=new FileInputStream("src/test/resources/ExcelData.xlsx");
		 Workbook book=WorkbookFactory.create(fise);
		 Sheet sh = book.getSheet("Campaign");
		 Row rownum = sh.getRow(0);
		 Cell cellnum = rownum.getCell(0);
		 String campaignname = cellnum.getStringCellValue();*/
		 Excel_Utility elib=new Excel_Utility();
		 //String campaignname = elib.getExcelData("Campaign", 0, 0);
		 //By using dataformatter i am calling method
		 String campaignname = elib.getExcelDataByUsingDataFormatter("Campaign", 0, 0);
		 
		
		 
		 //driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaignname);
		 campaignpage.ClickinCampaignName(campaignname);
		 
		 //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		 campaignpage.clickSaveButton();
		 //Thread.sleep(2000);
		 
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
			
		 
		 
		 //click on administrator
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 //click on signout
		 driver.findElement(By.linkText("Sign Out")).click();*/
		
		
		//added in base class
		//home.clickSignoutLink(driver);
		

	}

}
