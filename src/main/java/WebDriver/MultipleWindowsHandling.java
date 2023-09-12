package WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindowsHandling {

	
	static WebDriver driver;
	public static void main(String[] args) throws Exception{
		
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String parentID=driver.getWindowHandle();
		System.out.println(parentID);
		Thread.sleep(2000);
		
		
		
		getHandles(openAllPage(), "Secaucus NJ");
		closeAllPage(openAllPage(), parentID);
		
	}
	
	public static List<String> openAllPage() {
		List<WebElement> hs=driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g']"));
		
		Actions act = new Actions(driver);
		for(WebElement e: hs) {
			act.click(e).perform();
		}
		
		Set<String> win=driver.getWindowHandles();
		List<String> hsList= new ArrayList<String>(win);
		return hsList;
	}
	
	public static void getHandles(List<String> hsList, String value) {
		for(String e : hsList) {
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(value)) {
				System.out.println(driver.getTitle());
				break;
			}
		}
	}
	
	public static void closeAllPage(List<String> hsList, String parentID ) throws Exception {
		for(String e : hsList) {
			driver.switchTo().window(e);
			String childID=driver.getWindowHandle();
			if(!childID.contains(parentID)) {
				driver.close();
			}
			Thread.sleep(2000);
	}

}
}
