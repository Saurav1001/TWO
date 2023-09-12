package WebDriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertByWait {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
//		ChromeOptions options = new ChromeOptions();
//		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		getAlertByWait(5);

	}
	
	public static Alert getAlertByWait(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	    return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public static void acceptAlertByWait(int timeout) {
		getAlertByWait(timeout).accept();
	}
	public static String getTextAlertByWait(int timeout) {
		return getAlertByWait(timeout).getText();
	}
	public static void dismissAlertByWait(int timeout) {
		getAlertByWait(timeout).dismiss();
	}
	public static void sendKeysAlertByWait(int timeout ,String value) {
		getAlertByWait(timeout).sendKeys(value);
	}

}
