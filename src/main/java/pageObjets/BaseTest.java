package pageObjets;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	public static void goToMainPage (WebDriver driver) {
		driver.get("https://www.despegar.com.ar/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	public static WebDriver iniciarDriver (String browserName) {
		WebDriver driver=null;
		switch(browserName) {
		case "CHROME": {
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\recursos\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case "FIREFOX": {
			System.setProperty("webdriver.geckodriver.driver", "src\\main\\java\\recursos\\geckodriver.exe");
			driver = new ChromeDriver();
			break;
		}
		}
		return driver;
	}
}


