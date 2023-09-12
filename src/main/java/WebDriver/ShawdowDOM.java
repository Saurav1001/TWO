package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShawdowDOM {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.switchTo().frame("pact");
		Thread.sleep(2000);
		driver.findElement(By.id("tea")).sendKeys("GreenTEA");
//		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		WebElement tea=(WebElement)jse.executeScript("return document.querySelector('#snacktime').shadowRoot.querySelector('#tea')");
//		
//		tea.sendKeys("Chai");
	}

}
