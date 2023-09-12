package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginPage {

	public static void main(String[] args) {
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver =new ChromeDriver(ops);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Vishnu");
		driver.findElement(By.id("input-lastname")).sendKeys("Shri");
		driver.findElement(By.id("input-email")).sendKeys("sv@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("test@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("test@1234");
		driver.findElement(By.xpath("(//label[@class='radio-inline'])[1]/input")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

	}

}
