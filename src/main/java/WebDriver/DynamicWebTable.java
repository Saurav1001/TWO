package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();

		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/49570/nz-vs-sl-1st-test-sri-lanka-tour-new-zealand-2023");

//		String runScored = driver
//				.findElement(By.xpath("//a[text()=' Angelo Mathews ']/parent::div/following-sibling::div[2]")).getText();

		System.out.println(getRun(" Angelo Mathews "));
	}
	
	public static String getRun(String playerName) {
		System.out.println(playerName);
		String runScored = driver
				.findElement(By.xpath("//a[text()='"+playerName+"']/parent::div/following-sibling::div[2]")).getText();

		return runScored;
	}

}
