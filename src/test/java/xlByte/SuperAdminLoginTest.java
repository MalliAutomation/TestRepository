package xlByte;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import org.testng.Assert;
import pages.HomePage;
import pages.SuperAdminPage;
import resource.Base;
import utils.BrowserUtils;


public class SuperAdminLoginTest extends Base {
	BrowserUtils bru;
	SoftAssert softAssertion;
	
	@BeforeMethod(alwaysRun = true)
	public void loadProperty() throws IOException {
		bru=new BrowserUtils(driver);
		softAssertion=new SoftAssert();
	}
	

	@Test(alwaysRun = true, description = "Verify Tenant", priority = 1)
	public void testSuperAdminLogin() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.Login(configProperties.getValue("username"), configProperties.getValue("password"));
		if (hp.getPopUpSize() > 0) {
			hp.clickONYesButton();
		}
		SuperAdminPage sap = new SuperAdminPage(driver);
		String userEmail = sap.getLogoutText();
		Assert.assertEquals(userEmail, configProperties.getValue("logout"));
		

	}

	

	@Test(alwaysRun = true, description = "Log out", priority = 2)
	public void clickOnLogout() {
		SuperAdminPage sap = new SuperAdminPage(driver);
		sap.clickOnLogout();
		
	}
	@AfterClass(alwaysRun = true)
	public void quitDriver()
	{
		bru.quitDriver();	

	}

}
