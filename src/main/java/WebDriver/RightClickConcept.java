package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

	static WebDriver driver;
	public static void main(String[] args) throws Exception{
		driver= new EdgeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		//WebElement rightClick=driver.findElement(By.xpath("//span[text()='right click me']"));
		By rightClick=By.xpath("//span[text()='right click me']");
//		Thread.sleep(3000);
//		Actions act = new Actions(driver);
//		act.contextClick(rightClick).perform();
//		List<WebElement> options=driver.findElements
//				(By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span"));
		By options=By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span");
		doGetRightClickOption(rightClick, options)
		;
//		
//		System.out.println(options.size());
//		for(WebElement e: options) {
//			String text=e.getText();
//			System.out.println(text);
//			if(text.equals("Copy")) {
//				e.click();
//				break;
//			}
//		}
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator)
;	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator)
;	}
	
	public static void doRightClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();
	}
	
	public static void doGetRightClickOption(By locator, By optionLocator) throws Exception {
		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();
		Thread.sleep(3000);
		List<WebElement> options=getElements(optionLocator);
		System.out.println(options.size());
		for(WebElement e: options) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals("Copy")) {
				e.click();
				break;
			}
		}

		
	}

}
