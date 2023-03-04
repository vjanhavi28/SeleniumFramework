package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreatePage 
{
	    //initialization
		public  CampaignCreatePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//declaration
		@FindBy(xpath="//img[@alt='Create Campaign...']")
		private WebElement plusIcon;
		
		@FindBy(xpath="//input[@name='campaignname']")
		private WebElement  campaignName;
		
		@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
		private WebElement saveButton;
		
		@FindBy(xpath="//img[@alt='Select']")
		private WebElement productplusIcon;
		
		@FindBy(xpath="//input[@name='search_text']")
		private WebElement searchProductName;
		
		@FindBy(xpath="//input[@name='search']")
		private WebElement searchButton;

		
		//getters method
		public WebElement getPlusIcon() {
			return plusIcon;
		}

		public WebElement getCampaignName() {
			return  campaignName;
		}
		
		public WebElement getProductplusIcon() {
			return productplusIcon;
		}
		public WebElement getSearchProductName() {
			return searchProductName;
		}
		public WebElement getSearchButton() {
			return searchButton;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		
		//business logic for plus icon
		public void clickPlusIcon()
		{
			plusIcon.click();
		}
		//business logic for Campaign name
		public void ClickinCampaignName(String campaignname)
		{
			 campaignName.sendKeys(campaignname);
		}
		
		//business logic for product plus icon
		public void clickproductPlusIcon()
		{
			productplusIcon.click();
		}
		
		//business logic for searchProductName
		public void clickSearchProductName(String productname )
		{
			searchProductName.sendKeys(productname);
		}
		
		//business logic for searchButton
		public void clickSearchButton()
		{
			searchButton.click();
		}
		
		
		//business logic for SaveButton
		public void clickSaveButton()
		{
			saveButton.click();
		}
		
		

}
