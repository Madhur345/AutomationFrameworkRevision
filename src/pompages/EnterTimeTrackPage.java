package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {

	@FindBy(xpath="//div[contains(text(),'Help')]")
	WebElement helpMenu;

	@FindBy(xpath ="//a[contains(text(),'About your actiTIME')]")
	WebElement aboutActitimeLink;

	@FindBy(xpath ="(//span[contains(text(),'actiTIME')])[1]")
	WebElement prodVersion;

	@FindBy(id="aboutPopupCloseButtonId")
	WebElement closePopUpWindow;

	@FindBy(id="logoutLink")
	WebElement logoutBtn;

	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void clickHelpMenu(){
		helpMenu.click();
	}
	public void clickActitimeLink(){
		aboutActitimeLink.click();
	}
	public String verifyProductVersion(){
		return prodVersion.getText();
	}
	public void clickCloseWindowButton(){
		closePopUpWindow.click();
	}
	public void clickLogOutButton(){
		logoutBtn.click();
	}
}
