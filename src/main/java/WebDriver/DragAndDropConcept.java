package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceEle=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetEle=driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		//act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
		
		act.dragAndDrop(sourceEle, targetEle).perform();
	}

}
