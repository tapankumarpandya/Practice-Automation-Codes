package tapanhpandya.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tapanhpandya.testBase.BaseClass;
import tapanhpandya.testUtils.TestUtil;

public class HomePage extends BaseClass {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="//td[@style='color: green']")
	private WebElement designationId;
	
	public boolean isElementPresent() {
		return TestUtil.isElementVisible(driver, designationId);
	}
	
	public boolean isHomePage() {
		String expectedTitle = "Guru99 Bank Manager HomePage";
		return TestUtil.getTitle(driver, expectedTitle);
	}
}
