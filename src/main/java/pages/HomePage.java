package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@formcontrolname='email']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@placeholder='OTP or Password']")
	private WebElement pass;
	
	@FindBy(xpath = "//span[contains(text(),'Login')]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='Yes']")
	private List<WebElement> overLay;
	
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement yesButton;
	
	
	
	
	public void Login(String un,String psw) throws InterruptedException  {
		
		userName.sendKeys(un);
		pass.click();
		Thread.sleep(5000);
		pass.sendKeys(psw);
		loginButton.click();
	}
	
	public int getPopUpSize() {
		return overLay.size();
	}
	
	public void clickONYesButton() throws InterruptedException
	{
		yesButton.click();
		Thread.sleep(5000);
	}
	
	

	
	
	

}
