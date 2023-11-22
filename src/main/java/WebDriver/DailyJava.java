package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DailyJava {
	
	 static WebDriver driver;
	
	public static void main(String[] args) {
		

		


		 driver= new ChromeDriver();
		
		
		driver.get("https://www.t-mobile.com/tablets");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		selectOptions("brands", "apple", "samsung");
//		driver.findElement(By.xpath("//legend[text()=' Deals ']/parent::mat-panel-title/tmo-icon")).click();
//		Thread.sleep(2000);
//		WebElement d=driver.findElement
//		(By.xpath("//span[text()=' New ']/parent::span/parent::label/span/input[@type='checkbox']"));
//		Actions act= new Actions(driver);
//		act.click(d).build().perform();
		
		
			
							
		}
	
	public static void selectOptions(String s, String b, String c) {
		s=s.toLowerCase().replaceAll("\\s", "");
		b=b.toLowerCase().replaceAll("\\s", "");
		c=c.toLowerCase().replaceAll("\\s", "");
		Actions act = new Actions(driver);
		if(s.equals("deals")) {
			driver.findElement(By.xpath("//legend[text()=' Deals ']/parent::mat-panel-title/tmo-icon")).click();
			if(c.equals("specialoffer") && b.equals("new")) {
				WebElement n=driver.findElement
						(By.xpath("//span[text()=' New ']/parent::span/parent::label/span/input[@type='checkbox']"));
				act.click(n).build().perform();
				WebElement d=driver.findElement
						(By.xpath("//span[text()=' Special offer ']/parent::span/parent::label/span/input[@type='checkbox']"));
				act.click(d).build().perform();
			}
			
			
			
			
		}else if(s.equals("brands")) {
			driver.findElement(By.xpath("//legend[text()=' Brands ']/parent::mat-panel-title/tmo-icon")).click();
			if(b.equals("apple") && c.equals("samsung")) {
				WebElement n=driver.findElement
						(By.xpath("//span[text()=' Apple ']/parent::span/parent::label/span/input[@type='checkbox']"));
				act.click(n).build().perform();
				WebElement d=driver.findElement
						(By.xpath("//span[text()=' Samsung ']/parent::span/parent::label/span/input[@type='checkbox']"));
				act.click(d).build().perform();
				
			}
		}else if(s.equals("operating system"))
		{
			driver.findElement(By.xpath("//legend[text()=' Deals ']/parent::mat-panel-title/tmo-icon")).click();
		}

		
		
	}
		
				
			}
	

	
		

	
	

