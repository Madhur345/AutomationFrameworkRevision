package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin() throws InterruptedException{
		LoginPage l = new LoginPage(driver);
			String username = Lib.getCellValue("ValidLogin",1,0);
			l.setUsername(username);
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
