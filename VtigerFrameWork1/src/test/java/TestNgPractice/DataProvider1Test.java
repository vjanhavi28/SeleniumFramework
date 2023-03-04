package TestNgPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.Excel_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Property_Utility;
import Generic_utilities.WebDriver_Utility;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.OrganizationCreatePage;

public class DataProvider1Test
{
	@Test(dataProvider="dataProvider_test()")
	public void createOrgnizationTest(String name,String phoneno,String email)throws Throwable
	//public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/ ");
		
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
		Property_Utility plib=new Property_Utility();
		String URL =plib.getKeyValue("url");
		String USERNAME =plib.getKeyValue("username");
		String PASSWORD =plib.getKeyValue("password");
		
		driver.get(URL);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		Login_Page lp=new Login_Page(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
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
		
		//Handle alert popup using random class to avoid duplicate
		/*Random r=new Random();
		int rnum = r.nextInt(5);*/
		
		//Handle alert popup by using generic utility(keeping common methods inside java_utility class)
		Java_Utility jlib=new Java_Utility();
		int rnum = jlib.getRanNum();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phoneno);
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(email);
		
		//click on save button
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		orgpage.clickSaveButton();
		Thread.sleep(2000);
		
		
		//click on logout button
		//driver.findElement(By.linkText("Sign Out")).click();
		//home.clickSignoutLink(driver); 
		
		
		@DataProvider
		public Object[][] dataProvider_test() throws Throwable
		{
			Object[][] objArr=new Object[3][3];
			objArr[0][0]="AAA";
			objArr[0][1]="1234567861";
			objArr[0][2]="abc@gmail.com";
			
			objArr[1][0]="BBB";
			objArr[1][1]="1234567871";
			objArr[1][2]="bbc@gmail.com";
			
			objArr[2][0]="CCC";
			objArr[2][1]="1234567881";
			objArr[2][2]="cbc@gmail.com";
			
			return objArr;
			
		}
		
		
		
	

	
		
	}


}
