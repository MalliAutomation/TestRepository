import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mailcreation {
	public static  WebDriver driver;
	
	@Test	
	public void login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#inbox");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]")).click();
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("testvap47@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Vaptest@123");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		List<WebElement> values=driver.findElements(By.xpath("//table[@id=':23']/tbody/tr/td[5]"));
		int tvalues=values.size();
		for(int i=0;i<tvalues;i++)
		{
			String str = values.get(i).getText();
			System.out.println(str);
			if(values.get(i).getText().contains("VAP - Registration Confirmed"))
			{
				values.get(i).click();
				break;
			}
		}
		WebElement ele=driver.findElement(By.xpath("//*[text()='VAP application']"));
		
		act.click(ele).build().perform();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("testvap47@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Request Password')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		driver.switchTo().window(tabs.get(0));		
		driver.navigate().back();
		driver.navigate().refresh();
	    Thread.sleep(15000);
	    driver.navigate().refresh();
	    List<WebElement> values1=driver.findElements(By.xpath("//table[@id=':23']/tbody/tr/td[5]"));
		int tvalues1=values1.size();
		for(int j=0;j<tvalues1;j++)
		{
			String str = values1.get(j).getText();
			System.out.println(str);
			if(values1.get(j).getText().contains("VAP - Reset Password"))
			{
				values1.get(j).click();
				break;
			}
		}
		Thread.sleep(2000);
		
		String otp=driver.findElement(By.xpath("//span[@style='background-color:yellow;font-size:1.875em']/b")).getText();
		System.out.println(otp);
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("//input[@formcontrolname='Passcode']")).sendKeys(otp);
		driver.findElement(By.xpath("//input[@formcontrolname='Password']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@formcontrolname='ConfirmPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		
	
		
		
	    
		
		
		
		
		
		
		
	}
	
	


		
	}


