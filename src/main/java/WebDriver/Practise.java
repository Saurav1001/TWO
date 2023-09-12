package WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Practise {
   
    
    
	static WebDriver driver;
	

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
	
		driver.get("https://selectorshub.com/xpath-practice-page/");
		String parentID=driver.getWindowHandle();
		Thread.sleep(3000);
		//String country="United States";
		driver.manage().window().maximize();
		List<WebElement> list=driver.findElements(By.xpath("//*[local-name()='svg']/parent::a"));
		System.out.println(list.size());
		//Log.info(list.size());
		for(WebElement e : list) {
			e.click();
		}
		Set<String> wins=driver.getWindowHandles();
		
		Iterator<String> it=wins.iterator();
		while(it.hasNext()) {
			String childID=it.next();
			driver.switchTo().window(childID);
			if(!childID.equals(parentID)) {
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		driver.quit();
		
	}
	
	
	}
	
	

