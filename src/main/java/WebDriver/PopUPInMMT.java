package WebDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class PopUPInMMT {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://www.makemytrip.com/");
		System.out.println(driver.getWindowHandle());
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		WebElement click=driver.findElement(By.xpath("//p[@data-cy='LoginHeaderText']"));
		act.click(click).perform();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		System.out.println(it.next());
		driver.findElement(By.id("username")).sendKeys("Sauravtyagi");
		
		
	}

}
