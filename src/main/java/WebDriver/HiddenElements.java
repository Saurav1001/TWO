package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HiddenElements {
static WebDriver driver;
	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		driver.get(
				"https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		driver.findElement(By.id("hide-textbox")).click();
		
		Thread.sleep(2000);
		WebElement showbtn=driver.findElement(By.id("show-textbox"));
		WebElement textBox=driver.findElement(By.id("displayed-text"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", showbtn);
		
		js.executeScript("arguments[0].value='tyagiji'", textBox);

//		 js.executeScript("document.getElementById('displayed-text').click");



}
} 
