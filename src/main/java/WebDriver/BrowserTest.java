package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	static WebDriver driver;

	public static void main(String[] args) {
		
//		BrowserUtil br=new BrowserUtil();
//		br.launchBrowser("CHROME");
//		br.launchUrl("https://www.amazon.com");
//		br.getPageUrl();
//		br.getTitle();
//		br.close();
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//1. 
//		driver.findElement(By.id("input-email")).sendKeys("sauravTygai@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("Test123");
		
		//2.
//		WebElement email=driver.findElement(By.id("input-email"));
//		WebElement pass=driver.findElement(By.id("input-password"));
//		email.sendKeys("sauravTygai@gmail.com");
//		pass.sendKeys("sauravTygai@gmail.com");
		
		//3.
//		By email=By.id("input-email");
//		By pass=By.id("input-password");
//		getElement(email).sendKeys("saurav Tyagi");
//		getElement(pass).sendKeys("saurav Tyagi");
		
//		driver.findElement(email).sendKeys("sauravtyagi");
//		driver.findElement(pass).sendKeys("SauravTyagi");
		
		//String locator
//		String email_ID="input-email";
//		String password_ID="input-password";
//		String login_Btn="Login";
//		By ID_String=By.id(email_ID);
//		By Password=By.id(password_ID);
////		driver.findElement(ID_String).sendKeys("SauravTyagi");
////		driver.findElement(Password).sendKeys("TEST!@#");
//		
//		doSendKeys("id", email_ID, "SauravTyagi1212");
//		doSendKeys("ID", password_ID, "Test123");
		
		String text=driver.findElement(By.id("input-firstname")).getText();
		System.out.println(text);
		driver.close();
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static By getBy(String locatorType, String selector) {
		By locator=null;
		switch (locatorType.toLowerCase()) {
		case "id":
			 locator=By.id(selector);
			break;

		default:
			break;
		}return locator;
		
	}
	
	public static void doSendKeys(String locatorType, String selector, String value) {
		
	By locator=getBy(locatorType, selector);
	getElement(locator).sendKeys(value);
	
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(String locatorType, String selector) {
		By locator=getBy(locatorType, selector);
		getElement(locator).click();
	}
	
	public static String doGetTextElement(By locator) {
		String element_text=getElement(locator).getText();
		return element_text;
	}
	
	public static String doGetAttribute(By locator, String attributeName) {
		 return getElement(locator).getAttribute(attributeName)
;	}
	

}
