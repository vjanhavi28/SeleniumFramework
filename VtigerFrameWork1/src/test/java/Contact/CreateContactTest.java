package Contact;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_utilities.Base_Class;
import Generic_utilities.Excel_Utility;
import Generic_utilities.Property_Utility;
import Generic_utilities.WebDriver_Utility;
import POM_Repo.ContactCreatePage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;

@Test
public class CreateContactTest extends Base_Class
{

	public void createContactTest()throws Throwable
	//public static void main(String[] args) throws Throwable 
	{
		/*String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();*/
		
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

		// click on contact
		//driver.findElement(By.linkText("Contacts")).click();
		Home_Page home=new Home_Page(driver);
		home.clickContactsLink();
		
		// click on plus icon
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		ContactCreatePage contactpage=new ContactCreatePage(driver);
		contactpage.clickPlusIcon();
		
		// Fetching data from excel
		/*FileInputStream fise = new FileInputStream("src/test/resources/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sh = book.getSheet("Contact");
		Row rownum = sh.getRow(0);
		Cell cellnum = rownum.getCell(0);
		String firstname = cellnum.getStringCellValue();*/

		/*Row rownumm = sh.getRow(0);
		Cell cellnumm = rownumm.getCell(1);
		String lastname = cellnumm.getStringCellValue();

		/*Row rownummm = sh.getRow(0);
		Cell cellnummm = rownummm.getCell(2);
		int mobnum = cellnummm.getNumericCellValue();*/
		
		Excel_Utility elib=new Excel_Utility();
		String firstname = elib.getExcelDataByUsingDataFormatter("Contact", 0, 0);
		String lastname = elib.getExcelDataByUsingDataFormatter("Contact", 0, 1);
		String mobnum = elib.getExcelDataByUsingDataFormatter("Contact", 0, 2);
		
		
		/*driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobnum);*/
		contactpage.ClickinContactName(firstname, lastname, mobnum);
		

		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		contactpage.clickSaveButton();
		
		Thread.sleep(2000);

		/*
		  //Direct signout 
		  //click on administrator
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click(); 
		  //click on signout
		  driver.findElement(By.linkText("Sign Out")).click();
		 */
		
		
		//validation
		String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		Assert.assertEquals(firstname, actData);
		/*if(actData.contains(firstname))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}*/
		

		// signout using mouseover
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("Sign Out"))).click().perform();*/
		
		//added in base class
		//home.clickSignoutLink(driver);
		
		

	}

}
