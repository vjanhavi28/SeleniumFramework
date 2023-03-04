package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicxpath {

	public static void main(String[] args) 
	{
		String key="webdriver.chrome.driver";
		String value="src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 1: close cookies or window
		driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		//step 2:click on departure
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		
		/* step 3: write path for month then write path for complete month,date,year window and the write path for particular date
		//div[text()='February 2023'
		/ancestor::div[@class='DayPicker-Month'
		/descendant::p[text()='22' */
		
		//driver.findElement(By.xpath("//div[text()='February 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='22']")).click();
		//OR
		String month = "March 2023";
		String date = "25";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
	}

}
