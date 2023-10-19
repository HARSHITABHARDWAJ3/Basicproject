package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import junit.framework.Assert;
import pageobject.loginPage;

public class LocatorsPractice {
	
	
	public WebDriver driver;
	public loginPage lp;
	
	@Given("Launch Chrome browser")
	public void launch_chrome_browser() {
		ChromeDriverManager.getInstance().setup(); 
		driver = new ChromeDriver();
		 lp = new loginPage(driver);
		
	}

	@When("opens URL {string}")
	public void opens_url(String url) throws InterruptedException {
	   driver.get(url);
	   driver.manage().window().maximize();
	   Thread.sleep(2000);
		
	}

	@When("enters Username as {string} and Password as {string}")
	public void enters_username_as_and_password_as(String username, String password) throws InterruptedException {
	   lp.setUserName(username);
	   lp.setPassword(password);
	   lp.clickLogin();
	   Thread.sleep(2000);
		
	}

	@SuppressWarnings("deprecation")
	@Then("perform the tests")
	public void perform_the_tests() throws InterruptedException {
	   //get all the tabs on the dashboard from the menu option
		int number= driver.findElements(By.className("oxd-main-menu-item-wrapper")).size();
		System.out.print("Total options "+number);
		Assert.assertEquals(12, number);  //(expected,actual)
		
		
		//get all the links on the page
		int link = driver.findElements(By.tagName("a")).size();     //imp:- if we use findelements the we can use the "size" but if use findelement the we can use "getsize" 		
	System.out.println("Total Links "+link);
	
	//cssSelectors
	driver.findElement(By.cssSelector("[title=\"Assign Leave\"]")).click();
	Thread.sleep(2000); //it is important to wait for the page to load completely, only then the other step will work.
	
	//xpath different options
	WebElement usename = driver.findElement(By.xpath("//input[@placeholder='Type for hints...' or @class='oxd-autocomplete-text-input--before']")); //using 'or' also we can use 'and' if both the attributes and their values are true.
	usename.click();   
	usename.clear();
	usename.sendKeys("yo yo");
	
	
	WebElement comment = driver.findElement(By.xpath("//textarea[contains(@class,'oxd-textarea')]")); //using 'contains'
	comment.click();    
	comment.clear();
	comment.sendKeys("yo yo");
	
	driver.findElement(By.xpath("//div[starts-with(@tabindex,'0')]")).click(); //using 'starts-with'
	driver.findElement(By.xpath("//div[text(),'CAN - Bereavement']")).click();
	
	Thread.sleep(2000);
	}
	

	@When("click on Log out link")
	public void click_on_log_out_link() {
		driver.findElement(By.xpath("//img[@alt='profile picture']")).click();
	  lp.clickLogout();
		
	}

	@When("User close browser")
	public void user_close_browser() {
	    driver.close();
		
	}


}
