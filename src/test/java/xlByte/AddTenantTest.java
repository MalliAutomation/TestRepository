package xlByte;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.testng.Assert;
import pages.SuperAdminPage;
import pages.TenantDetailsPage;
import pages.TenantsPage;
import resource.Base;
import utils.BrowserUtils;
import utils.ReadPropertyFile;

public class AddTenantTest extends Base {

	public static ReadPropertyFile tenantProperties;
	private String testTenantDataFilePath;
	public TenantsPage tp;
	TenantDetailsPage tdp;
	SoftAssert softAssertion;
	SuperAdminLoginTest sdlp;
	SuperAdminLoginTest salp;
	SuperAdminPage sap;
	BrowserUtils bru;
	

	@BeforeMethod(alwaysRun = true)
	public void loadProperty() throws IOException {
		// Load property file
		testTenantDataFilePath = configProperties.getValue("AddTenantPageDataFilePath");
		tenantProperties = new ReadPropertyFile();
		InputStream input = new FileInputStream(new File(projectPath + testTenantDataFilePath));
		tenantProperties.loadPropertyFile(input);
		softAssertion = new SoftAssert();
		tdp = new TenantDetailsPage(driver);
		tp = new TenantsPage(driver);
		sdlp = new SuperAdminLoginTest();
		salp = new SuperAdminLoginTest();
		sap = new SuperAdminPage(driver);
		bru=new BrowserUtils(driver);
	}

	@Test(alwaysRun = true, description = "verify tenat page field validation", priority = 1)
	public void verifyTenantValidation() throws InterruptedException, IOException {
		// login as suoperadmin
		sdlp.testSuperAdminLogin();
		// Click on menu icon
		sap.clickOnMenuIcon();
		// Click on Tenants
		sap.clickOnTenants();
		// Click on add
		tp.clickOnAddButtton();
		// Click on Save
		tdp.clickOnSave();
		String actFullNameErrMsg = tdp.fullNameErrorMessage();
		softAssertion.assertEquals(actFullNameErrMsg, tenantProperties.getValue("fullNameErrorMessage"));
		String actshortNameErrMsg = tdp.shortNameErrorMessage();
		softAssertion.assertEquals(actshortNameErrMsg, tenantProperties.getValue("shortNameErrorMessage"));
		String actTenIdErrMsg = tdp.tenantIdErrorMessage();
		softAssertion.assertEquals(actTenIdErrMsg, tenantProperties.getValue("tenantIdErrorMessage"));
		String actContactnameErrMsg = tdp.contactNameErrorMessage();
		softAssertion.assertEquals(actContactnameErrMsg, tenantProperties.getValue("contactNameErrorMessage"));
		String actContactPhoneErrMsg = tdp.contactPhoneErrorMessage();
		softAssertion.assertEquals(actContactPhoneErrMsg, tenantProperties.getValue("contactPhoneErrorMessage"));
		String actEmailIdErrMsg = tdp.eMailIdErrorMessage();
		softAssertion.assertEquals(actEmailIdErrMsg, tenantProperties.getValue("eMailIdErrorMessage"));
		String actOpenURLErrMsg = tdp.openUrlErrorMessage();
		softAssertion.assertEquals(actOpenURLErrMsg, tenantProperties.getValue("openJobUrlErrorMessage"));
		String actAddressErrMsg = tdp.addressErrorMessage();
		softAssertion.assertEquals(actAddressErrMsg, tenantProperties.getValue("addressErrorMessage"));
		// click on cancel
		tdp.clickOnCancel();
		softAssertion.assertAll();
	}

	/*
	 * @Test(alwaysRun = true, description = "Add tenant", priority = 2) public void
	 * addTenant() throws InterruptedException { sap.clickOnMenuIcon(); // Click on
	 * Tenants sap.clickOnTenants(); // Click on add tp.clickOnAddButtton(); //
	 * Click on Save tdp.enterFullName(tenantProperties.getValue("fullNmae"));
	 * tdp.enterShortName(tenantProperties.getValue("shortName"));
	 * tdp.enterContactPerson(tenantProperties.getValue("contactPerson"));
	 * tdp.enterContacPhone(tenantProperties.getValue("contactPhone"));
	 * tdp.enterContactEmail(tenantProperties.getValue("contactEmail"));
	 * tdp.enterAddress(tenantProperties.getValue("address")); tdp.clickOnSave(); //
	 * Verify added tenant displayed in the grid String String acTtenant =
	 * tp.getTenantName(tenantProperties.getValue("fullNmae"));
	 * softAssertion.assertEquals(acTtenant, tenantProperties.getValue("fullNmae"));
	 * softAssertion.assertAll();
	 

	}*/
	@Test(alwaysRun = true, description = "Verify Tenant", priority = 2)
	public void verifyTenant() throws InterruptedException {
		sap.clickOnMenuIcon();
		// Click on Tenants
		sap.clickOnTenants();
		// Verify added tenant displayed in the grid
		String actTenant = tp.getTenantName(tenantProperties.getValue("fullNmae"));
		softAssertion.assertEquals(actTenant, tenantProperties.getValue("fullNmae"));

	}
	
	@Test(alwaysRun = true, description = "Deactivate Tenant", priority = 3)
	public void deActivateTenant() throws InterruptedException {		
		tp.clickCheckBoxnTenantName(tenantProperties.getValue("fullNmae"));
		tp.clickDeactivateButton();
		String actDeactivatMsg = tp.validateDeactivationMessagee();
		// Validate deactivemessage
		softAssertion.assertEquals(actDeactivatMsg, tenantProperties.getValue("deActiveMessage"));
	}
	
	@Test(alwaysRun = true, description = "Activate Tenant", priority = 4)
	public void activateTenant() throws InterruptedException {

		// Click on inactive radio button to view the inactive tenants
		tp.clickOnInActiveRadio();
		tp.clickCheckBoxnTenantName(tenantProperties.getValue("fullNmae"));
		tp.clickOnActivateButton();
		String actAactivatMsg = tp.validateDeactivationMessagee();
		// Validate activemessage
		softAssertion.assertEquals(actAactivatMsg, tenantProperties.getValue("deActiveMessage"));
	}

	@AfterClass(alwaysRun = true)
	public void logOut() {
		salp.clickOnLogout();
		bru.quitDriver();
		

	}

}
