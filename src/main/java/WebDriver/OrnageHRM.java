package WebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrnageHRM {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/try-it-free/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.findElement(By.id("Form_getForm_subdomain")).sendKeys(Keys.SHIFT,"saurav");
		driver.findElement(By.id("Form_getForm_Name")).sendKeys("Tyagi");
		driver.findElement(By.id("Form_getForm_Contact")).sendKeys("9560033644");
		driver.findElement(By.id("Form_getForm_Email")).sendKeys("styag@gmail.com");
	WebElement list=driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
		//System.out.println(list.size());
//		for(WebElement e : list) {
//			String text=e.getText();
//			System.out.println(text);
//			if(text.equalsIgnoreCase("India")) {
//				e.click();
//			}
//		}
		Select select = new Select(list);
		int li=select.getOptions().size();
		System.out.println(li);
		//driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
		
		//driver.findElement(By.id("Form_getForm_action_submitForm")).click();

	}

}
