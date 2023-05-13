package Com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Com.Actitime.ObjectRepository.Homepage;
import Com.Actitime.ObjectRepository.Loginpage;

public class Baseclass {
	public WebDriver driver;
	FileLibrary f = new FileLibrary();

	@BeforeSuite
	public void databaseConnection() {
		Reporter.log("database Connected", true);
	}

	@BeforeClass
	public void lauchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.readDataFromPropertyFile("url");
		driver.get(url);
		Reporter.log("Browser launched", true);
	}

	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		String un = f.readDataFromPropertyFile("username");
		String pwd = f.readDataFromPropertyFile("password");
		Thread.sleep(5000);
		Loginpage lp = new Loginpage(driver);
		lp.getUntb().sendKeys(un);
		lp.getPwtb().sendKeys(pwd);
		lp.getLgbtn().click();
		Reporter.log("login Succesfully", true);
	}

	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		Homepage hp = new Homepage(driver);
		hp.getLogoutlink().click();
		Reporter.log("Logout Successfully", true);
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser Closed", true);
	}

	@AfterSuite
	public void databaseDisconnected() {
		Reporter.log("Database Disconnected", true);
	}

	@Test
	public void succesfull() {
		Reporter.log("The Above Process is Successful", true);
	}
}
