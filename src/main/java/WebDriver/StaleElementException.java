package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebElement email=	driver.findElement(By.id("input-email"));
		
		email.sendKeys("TyagiJI123");
		
		driver.navigate().refresh();
		
		//email.sendKeys("Saurav");
		//Stale Element Exception
		
		//to Overcome this use below method
		
		email=driver.findElement(By.id("input-email"));
		email.sendKeys("Saurav");
		

	}

}
