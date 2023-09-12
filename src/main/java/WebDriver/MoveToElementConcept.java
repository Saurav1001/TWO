package WebDriver;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws  Exception {
		
		driver=new EdgeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		Thread.sleep(3000);
		//WebElement content=driver.findElement(By.xpath("//a[@class='menulink']"));
		By content=By.xpath("//a[@class='menulink']");
		By courses=By.linkText("COURSES");
		moveToElement(content, courses);
//		Actions act = new Actions(driver);
//		act.moveToElement(content).perform();
//		
//		WebElement courses=driver.findElement(By.linkText("COURSES"));
//		
//		act.click(courses).click().perform();
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void moveToElement(By locator, By targetElement) throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
		Thread.sleep(3000);
		
		act.click(getElement(targetElement)).perform();
	}
	
}
