package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverClasses {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.box.com/file/969473668052");
		
		String title=driver.getTitle();
		System.out.println(title);
		driver.close();
	}

}
