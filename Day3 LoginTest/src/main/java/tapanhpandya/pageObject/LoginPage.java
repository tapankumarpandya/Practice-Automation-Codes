package tapanhpandya.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tapanhpandya.testBase.BaseClass;
import tapanhpandya.testUtils.TestUtil;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='uid']")
	private WebElement user;
	
	@FindBy(css="input[name='password']")
	private WebElement password;
	
	@FindBy(css="input[name='btnLogin']")
	private WebElement loginButton;
	
	public void setUser(String username) {
		user.sendKeys(username);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public HomePage login() {
		loginButton.click();
		return new HomePage();
	}
	
	public String getAlertMessage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		try {
			String message = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			return message;
		} catch(Exception e) {
			e.printStackTrace();
			return "Alert is not present";
		}
	}
	
	
}
