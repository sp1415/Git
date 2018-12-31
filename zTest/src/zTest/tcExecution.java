package zTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tcExecution {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			// Open Browser
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			testCases tC = new testCases(driver);
			tC.executeTC();

			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
