package WebDriver;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HashMapUseCase {
static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get(
				"https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		driver.findElement(By.id("input-email")).sendKeys(username("customer"));
		driver.findElement(By.id("input-password")).sendKeys(password("customer"));
	}
	 public static HashMap<String, String> isHashMap() {
		 HashMap<String, String> hs = new HashMap<String, String>();
		 hs.put("customer", "cust:cust@123");
		 hs.put("seller", "seller:seller@123");
		 hs.put("buyer", "buyer:buyer@123");
		 hs.put("admin", "admin:admin@123");
		 
		 return hs;
	 }
	 
	 public static String username(String role) {
		 role=role.toLowerCase();
		 String user=isHashMap().get(role);
		 String username=user.split(":")[0];
		return username;
	 }
	 
	 public static String password(String role) {
		 role=role.toLowerCase();	 
		 String user=isHashMap().get(role);
		String password=user.split(":")[1];
		return password;
	 }

}
