package tapanhpandya.testUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	public static long IMPLICIT_WAIT = 10;
	public static int PAGE_LOAD_TIMEOUT = 20;
	
	public static boolean isElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println(element);
		System.out.println(element.isDisplayed() ? true : false);
		return element.isDisplayed() ? true : false;
	}
	
	public static boolean getTitle(WebDriver driver, String expectedTitle) {
		String title = driver.getTitle();
		System.out.println(title);
		return title.equalsIgnoreCase(expectedTitle) ? true : false;
//		return title;
	}
}
