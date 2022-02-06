package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenantDetailsPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	public TenantDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@formcontrolname='FullName']")
	private WebElement fullName;
	
	@FindBy(xpath = "//input[@formcontrolname='ShortName']")
	private WebElement shortName;
	
	@FindBy(xpath = "//input[@formcontrolname='ContactPerson']")
	private WebElement contactPerson;
	
	@FindBy(xpath = "//input[@formcontrolname='ContactPhone']")
	private WebElement contactPhone;
	
	@FindBy(xpath = "//input[@formcontrolname='ContactEmail']")
	private WebElement contactEmail;
	
	@FindBy(xpath = "//textarea[@formcontrolname='Address']")
	private WebElement address;
	
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//span[contains(text(),'Admins')]")
	private WebElement adminsButton;
	
	@FindBy(xpath = "//mat-error[contains(text(),'Full Name is required ')]")
	private WebElement fullNaameErrorMessage;
	
	@FindBy(xpath = "//mat-error[contains(text(),'Short Name is required ')]")
	private WebElement shortNaameErrorMessage;
	
	@FindBy(xpath = "//mat-error[contains(text(),'TenantId is required ')]")
	private WebElement tenantIDErrorMessage;
	
	@FindBy(xpath = "//mat-error[contains(text(),'Contact Name is required ')]")
	private WebElement contactNameErrorMessage;
	
	@FindBy(xpath = "//mat-error[contains(text(),'Contact Number is required ')]")
	private WebElement contactPhoneErrorMessage;
	
	@FindBy(xpath = "//mat-error[contains(text(),'Email-Id is required ')]")
	private WebElement eMailIdErrorMessage;
	
	@FindBy(xpath = "//mat-error[contains(text(),'OpenjobUrl is required ')]")
	private WebElement openUrlErrorMessage;
	
	@FindBy(xpath = "//mat-error[contains(text(),'Address is required ')]")
	private WebElement addressErrorMessage;
	
	
	
	
	
	
	
	public void enterFullName(String Name)
	{
		fullName.sendKeys(Name);
	}
	
	public void enterShortName(String sName)
	{
		shortName.sendKeys(sName);
	}
	
	public void enterContactPerson(String conPerson)
	{
		contactPerson.sendKeys(conPerson);
	}
	
	public void enterContactEmail(String conEmail)
	{
		contactEmail.sendKeys(conEmail);
	}
	public void enterContacPhone(String conPhone)
	{
		contactPhone.sendKeys(conPhone);
	}

	public void enterAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void clickOnSave() throws InterruptedException
	{
		 //wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOf(saveButton));
		Thread.sleep(5000);
		saveButton.click();
	}
	
	public void clickOnCancel()
	{
		
		cancelButton.click();
	}
	
	public void clickOnAdmins()
	{
		adminsButton.click();
	}
	
	public String fullNameErrorMessage() {
		String fullNameErrMsg=fullNaameErrorMessage.getText();
		return fullNameErrMsg;
	}
	
	public String shortNameErrorMessage() {
		String shortNameErrMsg=shortNaameErrorMessage.getText();
		return shortNameErrMsg;
	}
	public String tenantIdErrorMessage() {
		String tenantIdErrMsg=tenantIDErrorMessage.getText();
		return tenantIdErrMsg;
	}
	
	public String contactNameErrorMessage() {
		String contactnameErrMsg=contactNameErrorMessage.getText();
		return contactnameErrMsg;
	}
	
	public String contactPhoneErrorMessage() {
		String contactPhoneErrMsg=contactPhoneErrorMessage.getText();
		return contactPhoneErrMsg;
	}
		
		public String eMailIdErrorMessage() {
			String eMailIDErrMsg=eMailIdErrorMessage.getText();
			return eMailIDErrMsg;
	}
		
		public String openUrlErrorMessage() {
			String openURLErrMsg=openUrlErrorMessage.getText();
			return openURLErrMsg;
	}
		public String addressErrorMessage() {
			String addressErrMsg=addressErrorMessage.getText();
			return addressErrMsg;
	}
}
