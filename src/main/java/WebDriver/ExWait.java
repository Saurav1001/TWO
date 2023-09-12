package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExWait {

	static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By email=By.id("input-email");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys("Tyagi");
		if(wait.until(ExpectedConditions.titleContains("account"))) {
			System.out.println(driver.getTitle());
		}
		
		//wait.until(ExpectedConditions.a);

	} 
	
	public static WebElement waitElementPresent(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void doClickWait(By locator , int timeout) {
		waitElementPresent(locator, timeout).click();
	}
	public static void doSendKeysWait(By locator, int timeout, String input) {
		waitElementPresent(locator, timeout).sendKeys(input);
	}

}
