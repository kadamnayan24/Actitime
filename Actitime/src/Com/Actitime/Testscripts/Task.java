package Com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.Actitime.GenericLibrary.Baseclass;
import Com.Actitime.GenericLibrary.FileLibrary;
import Com.Actitime.ObjectRepository.Homepage;
import Com.Actitime.ObjectRepository.Taskpage;

public class Task extends Baseclass {
	@Test
	public void createCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(5000);
		Homepage hp = new Homepage(driver);
		hp.getTask().click();

		Taskpage t = new Taskpage(driver);
		t.getAddbtn().click();
		t.getNewcustomr().click();
		FileLibrary f1 = new FileLibrary();
		String createcustomer = f1.readDataFromExcel("Sheet1", 4, 1);
		String value = f1.readDataFromExcel("Sheet1", 4, 2);
		t.getEncustname().sendKeys(createcustomer);
		String actualresult = createcustomer;
		Thread.sleep(5000);
		t.getEncusdescptn().sendKeys(value);
		t.getCreatecust().click();
		t.getCancelbtn().click();
		String expectedresult = driver.findElement(By.xpath("(//div[.='" + createcustomer + "'])[2]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualresult, expectedresult);
		sa.assertAll();

	}
}
