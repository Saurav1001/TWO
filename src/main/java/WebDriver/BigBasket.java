package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement category=driver.findElement(By.xpath("//a[@qa='categoryDD']"));
		Actions act = new Actions(driver);
		act.moveToElement(category).perform();
		Thread.sleep(3000);
		WebElement beverages=driver.findElement(By.linkText("Beverages"));
		act.moveToElement(beverages).perform();
		WebElement tea=driver.findElement(By.linkText("Tea"));
		act.moveToElement(tea).perform();
		WebElement exoticTea=driver.findElement(By.linkText("Exotic & Flavoured Tea"));
		act.click(exoticTea).perform();
		

	}

}
