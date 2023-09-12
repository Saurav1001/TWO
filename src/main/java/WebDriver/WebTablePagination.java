package WebDriver;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTablePagination {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
	
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(3000);
		//String country="United States";
		driver.manage().window().maximize();
		//Single country
//		while(true) {
//			if(driver.findElements(By.xpath("//td[text()='United States']")).size()>0){
//				selectSingleCountry("United States");
//				break;
//			}
//				 WebElement next=driver.findElement(By.linkText("Next"));
//				if(next.getAttribute("class").contains("disabled")){
//					System.out.println("Country not found");
//					break;
//				}next.click();
//				Thread.sleep(3000);
//				
//		}
		
		//multicountry
		while(true) {
			if(driver.findElements(By.xpath("//td[text()='India']")).size()>0) {
				multipleCountry("India");
			}
			 WebElement next=driver.findElement(By.linkText("Next"));
			 if(next.getAttribute("class").contains("disabled")) {
				 System.out.println("Country not found");
				 break;
			 }next.click();
			 Thread.sleep(2000);
			
		}
}
	
	public static void multipleCountry(String country) {
		List<WebElement> eleList=driver.findElements
		(By.xpath("//td[text()='"+country+"']/preceding-sibling::td/input[@type='checkbox']"));
		for(WebElement e: eleList) {
			e.click();
		}
	}
	
	public static void selectSingleCountry(String country) {
		driver.findElement
		(By.xpath("//td[text()='"+country+"']/preceding-sibling::td/input[@type='checkbox']")).click();
		
	}
}
