package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws Throwable
	{
		String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Fetching Data From Notepad
		FileInputStream fis=new FileInputStream("src/test/resources/vtigerpropertyfile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click(); 
		
		//Fetching Data From Excel
		FileInputStream fise=new FileInputStream("src/test/resources/ExcelData.xlsx");
		Workbook book=WorkbookFactory.create(fise);
		Sheet sheetname = book.getSheet("Organization");
		Row rownum = sheetname.getRow(0);
		Cell cellnum = rownum.getCell(0);
		String orgName = cellnum.getStringCellValue();
		driver.findElement(By.name("accountname")).sendKeys(orgName);

	}

}
