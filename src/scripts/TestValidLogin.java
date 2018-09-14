package scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{
	Logger log =LogManager.getLogger(TestValidLogin.class.getName());
	@Test
	public void testValidLogin() throws InterruptedException{
		log.debug("create the object of pom login page");
		LoginPage l = new LoginPage(driver);
		log.info("object created successfully");
		log.debug("Fetching user details from excel file");
			String username = Lib.getCellValue("ValidLogin",1,0);
			l.setUsername(username);
			log.info("Detials are fetched");
			Thread.sleep(5000);
			String password =Lib.getCellValue("ValidLogin",1,1);
			l.setPassword(password);
			Thread.sleep(5000);
			l.clickLogin();
			String expectedTitle =Lib.getCellValue("ProductVersion",1,0);
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.titleIs(expectedTitle));
		}
	}
