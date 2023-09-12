package WebDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WindowHandlesOneByOne {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		
//		String parentID=driver.getWindowHandle();
//		System.out.println(parentID);
		WebElement element=driver.findElement(By.xpath("//*[local-name()='svg']/*[name()='g']"));
		Actions act=new Actions(driver);
		act.click(element).perform();
		Set<String> win=driver.getWindowHandles();
		Iterator<String> it=win.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}

}
