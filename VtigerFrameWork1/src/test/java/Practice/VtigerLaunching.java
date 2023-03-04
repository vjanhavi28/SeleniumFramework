package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerLaunching {

	public static void main(String[] args) 
	{
		String key = "webdriver.chrome.driver";
		String value = "src/main/resources/chromedriver.exe";
		System.setProperty(key,value);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/ ");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		

	}

}
