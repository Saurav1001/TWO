package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MMTCalendarHandelling {

	static WebDriver driver; 
	static Actions act;
	public static void main(String[] args) throws Exception {
		
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		String parentId=driver.getWindowHandle();
		System.out.println(parentId);
		Thread.sleep(3000);
		 act = new Actions(driver);
		act.doubleClick().build().perform();
		Thread.sleep(1000);
		act.doubleClick().build().perform();

		
		
		String mon="November 2023";
		String day="Thu Nov 16 2023";
		//Thread.sleep(2000);

		
		next(day,mon);	
		
		}
	
	public static void selectDate(String date) {
		
		mediumTimeOut();
		WebElement day = driver.findElement(By.xpath("//div[@aria-label='"+date+"']"));
		String price = driver.findElement(By.xpath("//div[@aria-label='"+date+"']/div/p[2]")).getText();
		act.click(day).perform();
		System.out.println(price);
		
	}
	public static void next(String day, String month) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Departure']"))).click();
	
		while(true) {
			if(driver.findElements(By.xpath("//div[text()='"+month+"']")).size()>0) {
				selectDate(day);
				break;
			}mediumTimeOut();
			WebElement next = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
			if(next.getAttribute("class").contains("interactionDisabled")){
				break;
			}
				act.click(next).perform();
			
		}
	}
	 public static void mediumTimeOut() {
		 try {
		 Thread.sleep(2000);
	 }catch( Exception e) {
		 e.printStackTrace();
	 }
		
	}
}
