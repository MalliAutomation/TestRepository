package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuperAdminPage {

	public WebDriver driver;

	public SuperAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//mat-icon[contains(@mattooltip,'Logout')]")
	private WebElement logOutIcon;

	@FindBy(xpath = "//mat-icon[contains(text(),'menu')]")
	private WebElement menuIcon;

	@FindBy(xpath = "//*[contains(text(),' Tenants ')]")
	private WebElement tenants;
	
	@FindBy(xpath = "//*[contains(text(),' Mail-Settings')]")
	private WebElement mailSettings;

	

	public String getLogoutText() {
		Actions act = new Actions(driver);
		act.moveToElement(logOutIcon).perform();
		return logOutIcon.getAttribute("mattooltip");
	}

	public void clickOnMenuIcon() {
		menuIcon.click();

	}

	public void clickOnTenants() {
		tenants.click();

	}
	
	public void clickOnLogout()
	{
		logOutIcon.click();
	}
	
	public void clickOnMailSettings() {
		mailSettings.click();

	}
	

	
}