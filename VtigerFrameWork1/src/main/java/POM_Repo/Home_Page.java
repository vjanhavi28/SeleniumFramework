package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page 
{
	//initialization
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//declaration
	@FindBy(xpath= "//a[@name='Campaigns']")
	private WebElement campaignLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreOption;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	

	//getters method
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}
	
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	//business logic for more option
	public void clickMoreOption()
	{
		moreOption.click();
	}
	//business logic for campaign
	public void clickCampaignlink()
	{
		campaignLink.click();
	}
	//business logic for organization
	public void clickOrganizationLink()
	{
		organizationLink.click();
	}
	//business logic for product
	public void clickProductLink()
	{
		productLink.click();
	}
	//business logic for contacts
	public void clickContactsLink()
	{
		contactsLink.click();
	}
	
	//business logic for administrator and signout
	public void clickSignoutLink(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(administratorImg).perform();
		signoutLink.click();
	}

}
