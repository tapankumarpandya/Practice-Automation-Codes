package tapanhpandya.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tapanhpandya.pageObject.HomePage;
import tapanhpandya.pageObject.LoginPage;
import tapanhpandya.testBase.BaseClass;

public class LoginPageTestDay3 extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTestDay3() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test (priority = 1)
	public void correctCredentialLoginTest() {
		loginPage.setUser(prop.getProperty("correctusername"));
		loginPage.setPassword(prop.getProperty("correctpassword"));
		homePage = loginPage.login();
		Assert.assertTrue(homePage.isHomePage());
	}
	
	@Test (priority = 2)
	public void incorrectUserAndCorrectPasswordTest() {
		loginPage.setUser(prop.getProperty("wrongusername"));
		loginPage.setPassword(prop.getProperty("correctpassword"));
		loginPage.login();
		String message = loginPage.getAlertMessage();
		Assert.assertEquals(message, prop.getProperty("invalidMessage"));
	}
	
	@Test (priority = 3)
	public void validUserAndInvalidPasswordTest() {
		loginPage.setUser(prop.getProperty("correctusername"));
		loginPage.setPassword(prop.getProperty("wrongpassword"));
		loginPage.login();
		String message = loginPage.getAlertMessage();
		Assert.assertEquals(message, prop.getProperty("invalidMessage"));
	}
	
	@Test (priority = 4)
	public void invalidUserAndInvalidPasswordTest() {
		loginPage.setUser(prop.getProperty("wrongusername"));
		loginPage.setPassword(prop.getProperty("wrongpassword"));
		loginPage.login();
		String message = loginPage.getAlertMessage();
		Assert.assertEquals(message, prop.getProperty("invalidMessage"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
