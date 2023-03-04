package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDeletePage
{
	//initialization
	public  ProductDeletePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement plusIcon;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement  productName;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;
	
	@FindBy(xpath="(//input[@name='Delete'])[1]")
	private WebElement deleteButton;

	
	//getters method
	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getProductName() {
		return  productName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	
	//business logic for plus icon
	public void clickPlusIcon()
	{
		plusIcon.click();
	}
	//business logic for Product name
	public void ClickinProductName(String productname)
	{
		productName.sendKeys(productname);
	}
	//business logic for SaveButton
	public void clickSaveButton()
	{
		saveButton.click();
	}
	//business logic for deletebutton
	public void clickDeleteButton()
	{
		deleteButton.click();
	}
	

}
