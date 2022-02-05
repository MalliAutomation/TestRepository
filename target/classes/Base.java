package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadPropertyFile;

public class Base {

	public static  WebDriver driver;
	public static ReadPropertyFile configProperties;
	public String configFilePath = "\\src\\main\\java\\resource\\data.properties";
	public static String projectPath = System.getProperty("user.dir");
	public String browserName;

	
	@BeforeClass
	public void launchDriver() throws IOException {

		configProperties = new ReadPropertyFile();
		InputStream input = new FileInputStream(new File(projectPath + configFilePath));
		configProperties.loadPropertyFile(input);
		browserName = configProperties.getValue("browser");
		if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configProperties.getValue("url"));		
		driver.manage().window().maximize();
		

	}
	
	@BeforeSuite(alwaysRun=true)
	public void deleteFolder() throws IOException
	{
		if(new File(projectPath+"\\reports\\").exists())
		{
			FileUtils.deleteDirectory(new File(projectPath+"\\reports\\"));
		}
		
		if(new File(projectPath+"\\screenshots\\").exists())
		{
			FileUtils.deleteDirectory(new File(projectPath+"\\screenshots\\"));
		}
	}
	
	
	public String getScreenSHotPath(String testCaseName) throws IOException
	{
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File src=screenShot.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir") + "./screenshots/"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
		
	}
	/*
	 * @AfterTest(alwaysRun=true) public void tearDown() { driver.quit();; }
	 */

}
