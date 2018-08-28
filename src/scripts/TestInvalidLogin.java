package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest {
	@Test
	public void testInvalid() throws InterruptedException{
		LoginPage l = new LoginPage(driver);
		int rowCount = Lib.getRowCount("InvalidLogin");
		for(int i=1;i<=rowCount;i++){
			String username =Lib.getCellValue("InvalidLogin", i, 0);
			l.setUsername(username);
			Thread.sleep(5000);
			String password =Lib.getCellValue("InvalidLogin", i, 1);
			l.setPassword(password);
			Thread.sleep(5000);
			l.clickLogin();
			Thread.sleep(3000);
			String expectedText =Lib.getCellValue("ExpectedText",i,0);
			String xp_errMsgObj ="//span[contains(text(),'invalid')]";
			WebElement errMsgObj=driver.findElement(By.xpath(xp_errMsgObj));
			System.out.println(errMsgObj.isDisplayed());
			String actualErrorText =errMsgObj.getText();
			System.out.println(actualErrorText);
			SoftAssert s = new SoftAssert();
			s.assertEquals(actualErrorText,expectedText);
		}
	}
}