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
		loginPage.setUser(prop.getProperty("username"));
		loginPage.setPassword(prop.getProperty("password"));
		homePage = loginPage.login();
//		System.out.println(homePage.isHomePage());
		Assert.assertTrue(homePage.isHomePage());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
