package WebDriver;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSuggestions {

	static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);

		driver.get("https:/WWW.GOOGLE.COM");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("APjFqb")).sendKeys("naveen automation labs");
		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		System.out.println(list.size());
		for(WebElement e : list) {
			String text=e.getText();
			System.out.println(text);
			if(text.contains("youtube")) {
			e.click();
			break;
		} 

		//suggestionList(serachLocator, "naveen automation labs", suggLocator, "youtube");

	}
	}
}

	

