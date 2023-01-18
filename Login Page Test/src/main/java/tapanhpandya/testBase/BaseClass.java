package tapanhpandya.testBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tapanhpandya.testUtils.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() {
		prop = new Properties();
		FileInputStream filepath;
		
		try {
			filepath = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/tapanhpandya/config/config.properties");
			prop.load(filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java//tapanhpandya//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//main//java//tapanhpandya//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		
		driver.get(prop.getProperty("url"));
	}
}
