package tapanhpandya.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tapanhpandya.pageObject.HomePage;
import tapanhpandya.pageObject.LoginPage;
import tapanhpandya.testBase.BaseClass;

public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void init() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void loginTest() {
		loginPage.setUser(prop.getProperty("correctusername"));
		loginPage.setPassword(prop.getProperty("correctpassword"));
		homePage = loginPage.login();
		Assert.assertTrue(homePage.isHomePage());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
