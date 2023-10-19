package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import junit.framework.Assert;
import pageobject.loginPage;


public class login{
	
	public WebDriver driver;
	public loginPage lp;
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		ChromeDriverManager.getInstance().setup(); 
		driver = new ChromeDriver();
		
	    lp = new loginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
	    
		driver.get(url);
		driver.manage().window().maximize();     
		Thread.sleep(1000);
	}

	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) throws InterruptedException {
	     
		lp.setUserName(username);
		lp.setPassword(password);
		Thread.sleep(1000);
		
	}


	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	    
		lp.clickLogin();
		Thread.sleep(1000);
		
	}

	@SuppressWarnings("deprecation")
	@Then("login Page Title should be {string}")
	public void login_page_title_should_be(String title) {
	
	WebElement val =	driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            Assert.assertEquals(title, val);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	   
		driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).click();
		lp.clickLogout();
		Thread.sleep(1000);
		
	}

	@SuppressWarnings("deprecation")
	@Then("logout Page Title should be {string}")
	public void logout_page_title_should_be(String title) throws InterruptedException {
	    
		boolean val = driver.findElement(By.xpath("//h5[text()='Login']")).isDisplayed();
		Assert.assertEquals(true, val);
		Thread.sleep(1000);
	}

	@Then("close browser")
	public void close_browser() {
	  driver.quit();
		
		
	}

}
