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

public class WindowHandlesAllInOne2 {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		String parentid=driver.getWindowHandle();
		
		//for all the svg elements
		List<WebElement> elemenet=driver.findElements(By.xpath("//*[local-name()='svg']/*[name()='g']"));
		Actions act=new Actions(driver);
		for(WebElement e: elemenet) {
			act.click(e).perform();
		}
		Set<String> childid=driver.getWindowHandles();
		Iterator<String> it=childid.iterator();
		while(it.hasNext()) {
			String text=it.next();
			driver.switchTo().window(text);
			if(!text.equals(parentid)) {
				System.out.println(driver.getTitle());
				driver.close();
			}Thread.sleep(2000);
		}driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());
		driver.close();
		
		

}
}
