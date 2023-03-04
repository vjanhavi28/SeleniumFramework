package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static void main(String[] args) 
	{
		//Launch Empty Browser
		String key = "webdriver.chrome.driver";
		String value = "C:\\Users\\Vaishnavi Macharde\\Selenium\\VtigerFrameWork1\\src\\main\\resources\\chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		
		

	}

}
