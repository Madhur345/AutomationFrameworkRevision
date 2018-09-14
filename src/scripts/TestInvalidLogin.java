package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest {
	Logger log = LogManager.getLogger(TestValidLogin.class.getName());
	@Test
	public void testInvalid() throws InterruptedException{
		LoginPage l = new LoginPage(driver);
		int rowCount = Lib.getRowCount("InvalidLogin");
		for(int i=1;i<=rowCount;i++){
			log.debug("Fetching details of username");
			String username =Lib.getCellValue("InvalidLogin", i, 0);
			log.info("username fetched");
			l.setUsername(username);
			Thread.sleep(5000);
			String password =Lib.getCellValue("InvalidLogin", i, 1);
			l.setPassword(password);
			Thread.sleep(5000);
			l.clickLogin();
			Thread.sleep(3000);
			String expectedText =Lib.getCellValue("ExpectedText",i,0);
			String xp_errMsgObj ="//span[contains(text(),'invalid')]";
			log.debug("checking for error message");
			WebElement errMsgObj=driver.findElement(By.xpath(xp_errMsgObj));
			System.out.println(errMsgObj.isDisplayed());
			log.info("Error message is dispaled");
			String actualErrorText =errMsgObj.getText();
			log.info(actualErrorText);
			SoftAssert s = new SoftAssert();
			s.assertEquals(actualErrorText,expectedText);
		}
	}
}