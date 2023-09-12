package WebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xxx {

	static WebDriver driver;
	static Actions act;
	public  Xxx( WebDriver driver) {
		this.driver=driver;
	}

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		driver.get(
				"https://www.myntra.com/?utm_source=dms_google&utm_medium=searchbrand_cpc&utm_campaign=dms_google_searchbrand_cpc_Search_Brand_Myntra_Brand_India_BM_TROAS_SOK&gclid=EAIaIQobChMIlaO79rbv_gIV1PRMAh21lgZIEAAYASAAEgJoCPD_BwE");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().window().maximize();


		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Tshirt");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='desktop-group']/li"));
		System.out.println(list.size());

		for (WebElement e : list) {
			String test = e.getText();
			System.out.println(test);
			if (test.contains("Men")) {
				act= new Actions(driver);
				act.click(e).perform();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Louis Philippe Sport Polo Collar T-shirt']")).click();

		Set<String> hs=driver.getWindowHandles();
		Iterator<String> it=hs.iterator();
		String parentID=it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='size-buttons-size-buttons']/div[4]")).click();
		driver.findElement(
				By.xpath("//span[@class='myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Bag']")).click();
		Thread.sleep(2000);
		
		WebElement po=driver.findElement(By.xpath("//button[@role='button']/div[text()='PLACE ORDER']"));
		act.click(po).perform();
		//driver.findElement(By.xpath("//button[@role='button']/div[text()='PLACE ORDER']"));

		act.click(po).perform();
	}
}
