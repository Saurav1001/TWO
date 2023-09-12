package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class BigBasketMiltipleOptionsPrint {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		
		WebElement selectCat=driver.findElement(By.linkText("SHOP BY CATEGORY"));
		
		Actions act = new Actions(driver);
		act.moveToElement(selectCat).build().perform();
		Thread.sleep(2000);
		WebElement beverages=driver.findElement(By.linkText("Beverages"));
		act.moveToElement(beverages).perform();
		Thread.sleep(1000);
//		WebElement tea=driver.findElement(By.linkText("Tea"));
//		act.moveToElement(tea).perform();
		Thread.sleep(2000);
		//List<WebElement> level2Options=driver.findElements(By.xpath("(//ul[@class='nav nav-pills nav-stacked'])[last()]/li"));
		List<WebElement> level3Options=driver.findElements(By.xpath("//ul[@class='list-unstyled']"));
		//WebElement LevelOption = driver.findElement(By.xpath("(//ul[@class='nav nav-pills nav-stacked'])[last()]"));
		
//		for(WebElement e: level2Options) {
//			String text=e.getText();
//			System.out.println(text);
			for(WebElement e1: level3Options) {
				act.moveToElement(e1.findElement(By.xpath("(//ul[@class='nav nav-pills nav-stacked'])[last()]"))).perform();
				String text1=e1.getText();
				System.out.print(text1);
			}
//		for(WebElement e: level3Options) {
//			String text=e.getText();
//			System.out.println(text);
//		}

	}

}
