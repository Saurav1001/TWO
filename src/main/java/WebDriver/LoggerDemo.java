package WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggerDemo {
	
	public static Logger log;
	public static WebDriver driver;

	public static void main(String[] args) {
		log= LogManager.getLogger();
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.linkText("Register")).click();
		log.info("clicking on Register page");

	}

}
