package Practice;

import java.io.FileInputStream;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrg {

	public static void main(String[] args) throws Throwable 
	{
		String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Fetching Data From Notepad
		FileInputStream fis = new FileInputStream("src/test/resources/vtigerpropertyfile.properties");
		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//click on contact module
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		//click on plus icon
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//click on orgname plus icon
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();

		// Handle window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		// Fetching Data From Excel
		FileInputStream fise = new FileInputStream("src/test/resources/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sheetname = book.getSheet("Organization");
		Row rownum = sheetname.getRow(0);
		Cell cellnum = rownum.getCell(0);
		String orgName = cellnum.getStringCellValue();
		
		

		//click on search textfield
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
		
		
		
		//click on search button
		driver.findElement(By.xpath("//input[@name='search']")).click();
		//write dynamic xpath for the name which you want to select
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().window(parentId);
		
		//fetching data from excel for last name
		Sheet sheetname1 = book.getSheet("Contact");
		Row rownum1 = sheetname1.getRow(0);
		Cell cellnum1 = rownum1.getCell(1);
		String lastName = cellnum1.getStringCellValue();
		
		//enter last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		
		// click on save button
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(2000);
		// click on administrator image
		driver.findElement(By.xpath("(//td[@class=\"small\"])[2]")).click();
		// click on logout button
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
