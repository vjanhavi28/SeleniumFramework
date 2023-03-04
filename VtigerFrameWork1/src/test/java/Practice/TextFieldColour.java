package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFieldColour {

	public static void main(String[] args) 
	{
		String key="webdriver.chrome.driver";
		String value="src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement username = driver.findElement(By.xpath("//input[@name='user_name']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
		username.getCssValue("color");
		password.getCssValue("color");
		System.out.println(username.getCssValue("color"));

	}

}
