package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.EnterTimeTrackPage;
import pompages.LoginPage;

public class TestVarifyProductVersion extends BaseTest {
	@Test

	public void testProductVersion() throws InterruptedException{
		LoginPage l = new LoginPage(driver);
		String username=Lib.getCellValue("ValidLogin", 1, 0);
		l.setUsername(username);
		String password=Lib.getCellValue("ValidLogin", 1, 1);
		l.setPassword(password);
		Thread.sleep(5000);
		l.clickLogin();
		Thread.sleep(5000);
		String expectedTilte=Lib.getCellValue("ProductVersion", 1, 0);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleIs(expectedTilte));
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		Thread.sleep(5000);
		e.clickHelpMenu();
		Thread.sleep(3000);
		e.clickAboutActiTimeLink();
		Thread.sleep(2000);
		String expectedProductVersion=Lib.getCellValue("ProductVersion", 1, 1);
		String actualProductVersion=e.getproductVersion();
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualProductVersion, expectedProductVersion);
		Thread.sleep(2000);
		/*WebElement element = driver.findElement(By.xpath("//td[@class='close-button']//div[@id ='aboutPopupCloseButtonId'][@class='closeButton']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='close-button']//div[@id ='aboutPopupCloseButtonId'][@class='closeButton']"))).click();
		Thread.sleep(2000);
		e.clickLogOut();
		s.assertAll();
	}
}