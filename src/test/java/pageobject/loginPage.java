package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	public WebDriver ldriver;
	
	public loginPage(WebDriver rdriver) {       //it is a constructor which will initiate the driver and for every element on the login page
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	@CacheLookup
	WebElement textEmail;

	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(@href,'/web/index.php/auth/logout')]")
	@CacheLookup
	WebElement LogoutBtn;
	
	public void setUserName(String name) {
		textEmail.click();
		textEmail.clear();
		textEmail.sendKeys(name);	
	}
	
	public void setPassword(String pswrd) {
		password.click();
		password.clear();
		password.sendKeys(pswrd);
	}
	
	public void clickLogin() {
		LoginBtn.click();
	}
	
	public void clickLogout() {
		LogoutBtn.click();
	}
	
}
