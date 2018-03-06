package testfrm1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UITest {
	@Test
	public void launchbrowser(){
		System.setProperty("webdriver.chrome.driver","E:\\Selenium Tutorial\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://twitter.com");
		driver.findElement(By.linkText("Log in")).click();;
		driver.findElement(By.xpath("//input[@class='js-username-field email-input js-initial-focus']")).sendKeys("svr_dheerendra@yahoo.co.in");
		driver.findElement(By.xpath("//input[@class='js-password-field']")).sendKeys("MOMICHAT123#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@class='btn js-tooltip settings dropdown-toggle js-dropdown-toggle']")).click();
		driver.findElement(By.xpath("//button[text()='Log out']")).click();
		driver.close();
	}
	

}
