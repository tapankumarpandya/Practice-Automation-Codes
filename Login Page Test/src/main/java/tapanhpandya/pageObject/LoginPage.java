package tapanhpandya.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tapanhpandya.testBase.BaseClass;

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
}
