package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {
		
		BrowserUtil br=new BrowserUtil();
		WebDriver driver=br.launchBrowser("CHROME");
		br.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		br.getTitle();
		
		By email=By.id("input-email");
		By pass=By.id("input-password");
		
		ElementUtil elm=new ElementUtil(driver);
		elm.doSendKeys(email, "sauravTyagi");
		elm.doSendKeys(pass, "Test1234");
		br.close();

	}

}
