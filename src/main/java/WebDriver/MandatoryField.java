package WebDriver;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MandatoryField {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String text=
				js.executeScript("return window.getComputedStyle"
						+ "(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')")
				.toString();
		System.out.println(text);
		
		
		
	}

}
