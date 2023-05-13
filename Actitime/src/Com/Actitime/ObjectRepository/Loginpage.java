package Com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	// Declaration
	@FindBy(name = "username")
	private WebElement untb;

	@FindBy(name = "pwd")
	private WebElement pwtb;

	@FindBy(xpath = "//div[.='Login ']")
	private WebElement lgbtn;

	// initialization
	public Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getUntb() {
		return untb;
	}

	public WebElement getPwtb() {
		return pwtb;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}

}
