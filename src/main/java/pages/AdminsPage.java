package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminsPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	public AdminsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadButton;
	
	@FindBy(xpath = "//span[contains(text(),'Close')]")
	private WebElement closeButton;
	
	
	
	
	public void uploadFile(String filePath)
	{
		 
		uploadButton.sendKeys(filePath);
	}
	
	public void clickOnClose()
	{
		closeButton.click();
		
	}
	
	
	
	

	
	
	

}
