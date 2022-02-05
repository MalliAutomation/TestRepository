package utils;

import org.openqa.selenium.WebDriver;

import pages.PageBase;

public class BrowserUtils {

	WebDriver driver;
	 public BrowserUtils (WebDriver driver){
	        this.driver = driver;
	 }
	
	public void quitDriver() {
		driver.quit();
	}

}
