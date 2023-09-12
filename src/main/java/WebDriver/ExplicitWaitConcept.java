package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		By email=By.id("input-email");
		By password=By.id("input-password");
		By login=By.xpath("//input[@type='submit12']");
		doSendKeysByWait(email, "SauravTyagi@gmail.com", 5);
		doSendKeysByWait(password, "SauravTyagi@gmail.com", 5);
		doClickByWait(login, 1);
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(email));
//		wait.until(ExpectedConditions.presenceOfElementLocated(password));
//		wait.until(ExpectedConditions.presenceOfElementLocated(login));
		
	}
	public static void doClickByWait(By locator , int timeout) {
		doSelectElementByWait(locator, timeout).click();
	}
	public static void doSendKeysByWait(By locator , String value, int timeout) {
		doSelectElementByWait(locator, timeout).sendKeys(value);
	}
	
	public static WebElement doSelectElementByWait(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
