package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BigBasketPractise {

	static WebDriver driver;
	
	public static void main(String[] args) throws Exception{
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		////td[text()='Hong Kong']/preceding-sibling::td/input[@type='checkbox']
		Thread.sleep(2000);
		
		By con=By.xpath("//td[text()='India']/preceding-sibling::td/input[@type='checkbox']");
		
		while(true) {
			if(driver.findElements(By.xpath("//td[text()='India']")).size()>0) {
				//singleCountry("India");
				//break;
				multiCountry(con);
			}
			WebElement next=driver.findElement(By.linkText("Next"));
			if(next.getAttribute("class").contains("disabled")) {
				System.out.println("Country not found");
				break;
			}next.click();
			Thread.sleep(2000);
		}
		
}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static void multiCountry(By locaotor) throws Exception {
		List<WebElement> list=getElements(locaotor);
		for(WebElement e: list) {
			e.click();
		}Thread.sleep(2000);
	}
	public static void singleCountry(String country) {
		driver.findElement
		(By.xpath("//td[text()='"+country+"']/preceding-sibling::td/input[@type='checkbox']")).click();
		
	}
}
