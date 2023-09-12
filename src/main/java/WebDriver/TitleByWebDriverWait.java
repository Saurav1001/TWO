package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitleByWebDriverWait {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		driver.findElement(By.linkText("Register")).click();
		
		String title=getTitleByWait("Register11");
		System.out.println(title);
		
	}
	public static String getTitleByWait(String value) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) );
		if(wait.until(ExpectedConditions.titleContains(value))){
			return driver.getTitle();
		}else {
			System.out.println("Title is not correct");
			return null;
		}
	}

}
