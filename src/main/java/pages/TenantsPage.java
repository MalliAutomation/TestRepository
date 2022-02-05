package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenantsPage {

	public WebDriver driver;
	WebDriverWait wait;

	public TenantsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Add')]")
	private WebElement addButton;

	@FindBy(xpath = "//mat-table")
	private WebElement table;

	@FindBy(xpath = "//button[@aria-label='Next page']")
	private WebElement nextPage;

	@FindBy(xpath = "//mat-icon[contains(text(),'edit')]")
	private WebElement editButton;
	
	@FindBy(xpath = "//span[contains(text(),'Deactivate')]")
	private WebElement deActivateButton;
	
	@FindBy(xpath = "//span[contains(text(),'Activate')]")
	private WebElement activateButton;

	@FindBy(xpath = "//span[contains(text(),'Successfully')]")
	private WebElement statusMessage;
	
	@FindBy(xpath = "//mat-radio-button[@value='inactive']")
	private WebElement inActiveRadio;
	
	@FindBy(xpath = "//mat-radio-button[@value='active']")
	private WebElement activeRadio;
	
	
	public void clickOnAddButtton() throws InterruptedException {
		
		addButton.click();
		Thread.sleep(5000);
	}

	
	public String getTenantName(String tenantName) {
		String tenName = null;

		List<WebElement> colValue = table.findElements(By.xpath("//mat-cell[3]"));
		int colCount = colValue.size();
		for (int i = 0; i < colCount; i++) {
			tenName = colValue.get(i).getText();
			if (tenName.equals(tenantName))
				break;

		}

		return tenName;

	}

	public void clickEditIconTenantName(String tenantName) {

		List<WebElement> colValue = table.findElements(By.xpath("//mat-cell[3]"));
		int colCount = colValue.size();
		for (int i = 0; i < colCount; i++) {
			String tenName = colValue.get(i).getText();
			if (tenName.equals(tenantName)) {
				table.findElement(By.xpath(
						"//mat-cell[contains(text(),'" + tenName + "')]//preceding-sibling::mat-cell[2]//mat-icon"))
						.click();
				break;
			}

		}
	}
	
	public void clickCheckBoxnTenantName(String tenantName) {

		List<WebElement> colValue = table.findElements(By.xpath("//mat-cell[3]"));
		int colCount = colValue.size();
		for (int i = 0; i < colCount; i++) {
			String tenName = colValue.get(i).getText();
			if (tenName.equals(tenantName)) {
				table.findElement(By.xpath(
						"//mat-cell[contains(text(),'" + tenName + "')]//following-sibling::mat-cell[5]/mat-checkbox/label/div"))
						.click();
				break;
			}

		}
	}
	
	public void clickDeactivateButton()
	{
		deActivateButton.click();
	}
	
	public String validateDeactivationMessagee()
	{
		wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOf(statusMessage));
		String succeMessage = statusMessage.getText();
		return succeMessage;
		
		
	}
	
	public void clickOnInActiveRadio()
	{
		inActiveRadio.click();
	}
	
	public void clickOnActiveRadio()
	{
		activeRadio.click();
	}
	
	public void clickOnActivateButton()
	{
		activateButton.click();
	}
	

}
