package pages;

import java.util.List;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class MailSettingsPage {

	public WebDriver driver;
	WebDriverWait wait;

	public MailSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@role='listbox']")
	private WebElement tenantListBox;

	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> tenantName;

	@FindBy(xpath = "//input[@formcontrolname='EmailId']")
	private WebElement sendingEmaiId;

	@FindBy(xpath = "//input[@formcontrolname='EmailPassword']")
	private WebElement sendingEmailPassword;

	@FindBy(xpath = "//input[@formcontrolname='SMTPHost']")
	private WebElement sMTPHostd;

	@FindBy(xpath = "//input[@formcontrolname='SMTPPort']")
	private WebElement sMTPPort;

	@FindBy(xpath = "//span[contains(text(),'Verify and Save')]")
	private WebElement saveAndVerifyButton;

	@FindBy(xpath = "//span[contains(text(),'Verified and updated Successfully')]")
	private WebElement VerifiedAndAdded;

	public void selectTenant(String Tenant) {
		tenantListBox.click();
		int tenCount = tenantName.size();
		for (int i = 0; i < tenCount; i++) {
			String tenName = tenantName.get(i).getText();
			if (tenName.equals(Tenant)) {
				tenantName.get(i).click();
				break;
			}

		}

	}

	public void enterEmailTD(String email) {
		 wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(sendingEmaiId));
		sendingEmaiId.clear();
		sendingEmaiId.sendKeys(email);
	}

	public void enterSendingEmailPassword(String pass) {
		sendingEmailPassword.clear();
		sendingEmailPassword.sendKeys(pass);
	}

	public void enterSMTPHost(String host) {
		sMTPHostd.clear();
		sMTPHostd.sendKeys(host);
	}

	public void enterSMTPort(String port) {
		sMTPPort.clear();
		sMTPPort.sendKeys(port);
	}

	public void clickOnSaveANDVerify() {

		saveAndVerifyButton.click();
	}
	
	public String validateMailSettingAddedSuccessMessage()
	{
		String succeMessage;
		 wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(VerifiedAndAdded));
		succeMessage=VerifiedAndAdded.getText();
		return succeMessage;
		
		
	}
}
