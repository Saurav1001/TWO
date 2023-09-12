package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String title=driver.getTitle();
		System.out.println(title);
		//driver.quit();
		//after this Session ID will be null
		driver.close();
		//session id is maintained but it will become invalid
		//And we will be getting Exception
		//to avoid this exception we have to launch browser again
//		driver = new ChromeDriver();
//		System.out.println(driver.getTitle());
	}

}
