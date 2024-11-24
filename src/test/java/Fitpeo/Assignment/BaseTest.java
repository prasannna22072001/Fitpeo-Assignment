package Fitpeo.Assignment;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


//Here I seperated this and created "BaseTest" and i included url in this class itself. And i also i added "BeforeMethod" where it run before every test method
public class BaseTest {

	static WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)

	public static WebDriver startDriver() {
 		
 		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\eclipse-workspace\\chromedriver131.exe");
 		driver = new ChromeDriver();
 		driver.get("https://www.fitpeo.com/"); 
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
 		driver.manage().window().maximize();
 		return driver;
 		
 	}
	
	}


