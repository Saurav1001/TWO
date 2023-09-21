package WebDriver;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CustomWaits {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//waitForPageLoad(10);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		By amazonDevices = By.linkText("Login ");

		WebElement ele=retryingElement(amazonDevices, 10);
		Actions act = new Actions(driver);
		
		act.click(ele).perform();
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement retryingElement(By locator, int timeOut) {

		WebElement element = null;
		int attempts = 0;

		while (timeOut > attempts) {

			try {
				element = getElement(locator);
				 System.out.println(element.getText());
				System.out.println("element is found....in attempt: " + (attempts + 1));
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt: " + attempts + " for locator: " + locator);
				try {
					Thread.sleep(500);// default interval time
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			attempts++;

		}

		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println("element is not found....tried for :" + timeOut + " secs "
						+ "with the interval of : " + 500 + " ms");
			}
		}
		System.out.println(element);

		return element;

	}
	
}








