package Generic_utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility 
{
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void switchToAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
}
