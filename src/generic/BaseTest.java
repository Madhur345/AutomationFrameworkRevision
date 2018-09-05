package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;

	static{
		System.setProperty(GECKO_KEY,GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	@BeforeMethod
	@Parameters({"browser"})
	public void openApplication(String browser){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1366,768");
		options.addArguments("window-size=1366,768");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");
		options.addArguments("--ignore-certificate-errors");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("geo.enabled", false);
		FirefoxOptions option = new FirefoxOptions() ;
		option.setProfile(profile);
		if(browser.equals("firefox")){
			driver = new FirefoxDriver(option);
		}
		else{
			driver = new ChromeDriver(options);
		}
		String url = Lib.getPropertyValue("URL");
		driver.get(url);
		String ITO = Lib.getPropertyValue("ImplicitWait");
		Long timeout = Long.parseLong(ITO);
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			Lib.captureScreenshots(driver,result.getName());
		}
		driver.quit();
	}
}