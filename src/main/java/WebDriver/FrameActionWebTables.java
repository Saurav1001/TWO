package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FrameActionWebTables {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops);
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("sauravtyagi1010");
		driver.findElement(By.name("password")).sendKeys("Bholenath@10");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement frames = driver.findElement(By.xpath("//frame[@name='mainpanel']"));

		driver.switchTo().frame(frames);
		Thread.sleep(2000);
		WebElement contacts = driver.findElement(By.linkText("CONTACTS"));
		//contacts.click();
		Actions act = new Actions(driver);
		act.moveToElement(contacts).build().perform();
		Thread.sleep(2000);
		WebElement newContacts = driver.findElement(By.linkText("New Contact"));
		act.click(newContacts).perform();

		WebElement title = driver.findElement(By.name("title"));
		Select select = new Select(title);
		select.selectByValue("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("Ritvik");
		driver.findElement(By.id("surname")).sendKeys("Sharma");
		//driver.findElement(By.id("image_file")).sendKeys("C:\\Users\\hp\\Desktop\\MACYS\\Resume");
		driver.findElement(By.xpath("//td[@colspan='2']//input[@type='submit']")).click();
		Thread.sleep(3000);

//		WebElement frames1 = driver.findElement(By.xpath("//frame[@name='mainpanel']"));
//
//		driver.switchTo().frame(frames1);
		WebElement contacts1 = driver.findElement(By.linkText("CONTACTS"));
		act.click(contacts1).perform();

		Thread.sleep(2000);
		driver.findElement(By
				.xpath("(//a[text()='saurav tyagi'])[2]/parent::td/preceding-sibling::" + "td/input[@type='checkbox']"))
				.click();

	}

}
