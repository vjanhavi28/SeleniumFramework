package Generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class 
{
	public WebDriver driver;
	public static WebDriver sdriver;
	public Property_Utility plib=new Property_Utility();
	
	
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void BS()
	{
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups= {"SmokeTest","RegressionTest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void BC() throws Throwable
	{
		//public void BC(String BROWSER)throws Throwable
		//{
		//Property_Utility plib=new Property_Utility();
		String BROWSER = plib.getKeyValue("browser");
		//WebDriver driver;
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
		}
		
		System.out.println("Launching Browser");
		sdriver=driver;
	}
	
	
	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void BM() throws Throwable
	{
		Property_Utility plib=new Property_Utility();
		String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
		
		
		driver.get(URL);
		Login_Page lp=new Login_Page(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("Login To Application");
	}
	
	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void AM() throws Throwable
	{
		Home_Page home=new Home_Page(driver);
		home.clickSignoutLink(driver);
		System.out.println("Logout To Application");
	}
	
	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void AC() throws Throwable
	{
		System.out.println("Close Browser");
	}
	
	@AfterTest(groups= {"SmokeTest","RegressionTest"})
	public void AT()
	{
		System.out.println("Parallel Exceution Done");
	}
	
	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void AS()
	{
		System.out.println("DataBase Closed");
	}
}
