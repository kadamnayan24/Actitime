package Com.Actitime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Taskpage {
	// deceleration
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement taseuser;

	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addbtn;

	@FindBy(xpath = "(//div[@style='display: block;'])[14]")
	private WebElement newcustomr;

	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement encustname;

	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement encusdescptn;

	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createcust;

	@FindBy(xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement cancelbtn;

	// initialization
	public Taskpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// utilization

	public WebElement getTaseuser() {
		return taseuser;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getNewcustomr() {
		return newcustomr;
	}

	public WebElement getEncustname() {
		return encustname;
	}

	public WebElement getEncusdescptn() {
		return encusdescptn;
	}

	public WebElement getCreatecust() {
		return createcust;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

}
