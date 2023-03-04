package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicxpath1 {

	public static void main(String[] args) throws Throwable
	{
		String key="webdriver.chrome.driver";
		String value="src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//handlinging three close button
		driver.findElement(By.xpath("//span[@class='arrow-icon gr-append-bottom3 down']")).click();
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 dRQhOp']")).click();
		//click on departure
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String month="February 2023";
		String date="18";
		
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		//click on done button
		driver.findElement(By.xpath("//span[text()='Done']")).click();

	}

}
