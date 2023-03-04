package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreatePage 
{
	//initialization
	public OrganizationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusIcon;
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;

	
	//getters method
	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	//business logic for plus icon
	public void clickPlusIcon()
	{
		plusIcon.click();
	}
	//business logic for organization name
	public void ClickinOrganizationName(String orgname)
	{
		OrganizationName.sendKeys(orgname);
	}
	//business logic for SaveButton
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	
	
	

}
