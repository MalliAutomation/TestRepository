package xlByte;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import pages.MailSettingsPage;
import pages.SuperAdminPage;
import resource.Base;
import utils.BrowserUtils;
import utils.ReadPropertyFile;

public class MailSettingToTenantTest extends Base {
	
	public static ReadPropertyFile mailSettingsProperties;
	String testMailSettingDataFilePath;	
	SoftAssert softAssertion;	
	SuperAdminLoginTest salp;
	SuperAdminPage sap;
	MailSettingsPage msp;
	BrowserUtils bru;

	@BeforeMethod(alwaysRun = true)
	public void loadProperty() throws IOException {
		// Load property file
		testMailSettingDataFilePath = configProperties.getValue("mailSettingDetailsFilepath");
		mailSettingsProperties = new ReadPropertyFile();
		InputStream input = new FileInputStream(new File(projectPath + testMailSettingDataFilePath));
		mailSettingsProperties.loadPropertyFile(input);
		softAssertion = new SoftAssert();		;
		salp = new SuperAdminLoginTest();
		sap = new SuperAdminPage(driver);
		msp = new MailSettingsPage(driver);
		bru=new BrowserUtils(driver);
	}

	@Test(alwaysRun = true, description = "Add mail settings")
	public void addMailSetttings() throws InterruptedException {
		// Login as super admin
		salp.testSuperAdminLogin();
		sap.clickOnMenuIcon();
		// Click on Tenants
		sap.clickOnMailSettings();
		// Select tenant
		msp.selectTenant(mailSettingsProperties.getValue("fullNmae"));
		msp.enterEmailTD(mailSettingsProperties.getValue("eMail"));
		msp.enterSendingEmailPassword(mailSettingsProperties.getValue("sendEmailPass"));
		msp.enterSMTPHost(mailSettingsProperties.getValue("smtpHost"));
		msp.enterSMTPort(mailSettingsProperties.getValue("smtpPort"));
		msp.clickOnSaveANDVerify();
		// Validate mail added message
		String addMessage = msp.validateMailSettingAddedSuccessMessage();
		softAssertion.assertEquals(addMessage, mailSettingsProperties.getValue("sucessMessage"));
		softAssertion.assertAll();
		
	}
	
	@AfterClass(alwaysRun = true)
	public void logOut() {
		salp.clickOnLogout();
		bru.quitDriver();
		

	}

}
