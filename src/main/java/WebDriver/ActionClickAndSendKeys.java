package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClickAndSendKeys {

	static WebDriver driver;
	public static void main(String[] args) throws Exception{
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		WebElement email=driver.findElement(By.id("input-email"));
//		WebElement pwd=driver.findElement(By.id("input-password"));
//		WebElement login=driver.findElement(By.xpath("//input[@value='Login']"));
		
		By email=By.id("input-email");
		By pwd=By.id("input-password");
		By login=By.xpath("//input[@value='Login']");
		
//		Actions act = new Actions(driver);
//		act.sendKeys(email, "SauravTyagi1212@gmail.com");
//		act.sendKeys(pwd, "Testing123");
//		act.click(login).perform();
		doSendKeysByAction(email, "SauravTyagi1212@gmail.com");
		doSendKeysByAction(pwd, "SauravTyagi1212@gmail.com");
		//doClickByAction(login)
;		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeysByAction(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	public static void doClickByAction(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

}
