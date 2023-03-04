package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreatePage 
{
	//initialization
	public  ContactCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement plusIcon;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement  firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement  lastName;
	
	@FindBy(xpath="//input[@name='mobile']")
	private WebElement  mobileNumber;
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;

	
	//getters method
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getMobileNumber() {
		return mobileNumber;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	
	//business logic for plus icon
	public void clickPlusIcon()
	{
		plusIcon.click();
	}
	//business logic for first name
	public void ClickinContactName(String firstname,String lastname,String mobnum )
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		mobileNumber.sendKeys(mobnum);
		
		
	}
	//business logic for SaveButton
	public void clickSaveButton()
	{
		saveButton.click();
	}
	

}
