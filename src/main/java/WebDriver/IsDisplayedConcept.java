package WebDriver;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayedConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
//		boolean flag=driver.findElement(By.linkText("Login")).isDisplayed();
//		System.out.println(flag);
//		
//		List<WebElement> linkList=driver.findElements(By.linkText("Login"));
//		System.out.println(linkList.size());
//		
//		if(linkList.size()>1) {
//			System.out.println("Element is present more than once");
//		}
		By login=By.linkText("Login");
		boolean flag=doIsDisplayed(login);
		System.out.println(flag);
		doMultiCountElementExits(login)
;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public static int getElementCount(By locator) {
		List<WebElement> elementList=driver.findElements(locator);
		return elementList.size();
	}
	
	public static void doSingleCountElementExits(By locator) {
		if(getElementCount(locator)==1) {
			System.out.println("Webelement exits for single time only");
		}
	}
	public static void doMultiCountElementExits(By locator) {
		if(getElementCount(locator)>1) {
			System.out.println("Webelement exits for multiple time ");
		}
	}

}
