package WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WindowHandlesAllInOne {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String parentId=driver.getWindowHandle();
		Thread.sleep(3000);
		//for all the svg elements
		List<WebElement> elemenet=driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g']"));
		System.out.println(elemenet.size());
		Actions act = new Actions(driver);
		for(WebElement e:elemenet ) {
			act.click(e).perform();
		}
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it=handles.iterator();
		
		while(it.hasNext()) {
			String windowsId=it.next();
			driver.switchTo().window(windowsId);
			
			if(!windowsId.equals(parentId)) {
				System.out.println(driver.getTitle());
			driver.close();
			
		}Thread.sleep(2000);

	}driver.switchTo().window(parentId);
	System.out.println(driver.getTitle());
	driver.quit();

}
}
