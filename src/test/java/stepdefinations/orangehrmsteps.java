package stepdefinations;

import io.cucumber.java.en.*;   //use star at the place of given so that we don't have to import different java class for when, then, etc
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class orangehrmsteps {

	WebDriver driver;

	@Given("I launch chrome browser")
	public void i_launch_chrome_browser() {
		ChromeDriverManager.getInstance().setup();   //we have added the dependancy in the pom.xml
		//		System.setProperty("webdriver.chrome.driver", "/Users/harshitabhardwaj/Downloads/chrome-mac-x64");
		driver = new ChromeDriver();
	}

	@When("I go to the orange hrm page")
	public void i_go_to_the_orange_hrm_page() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@SuppressWarnings("deprecation")
	@Then("I verify the logo")
	public void i_verify_the_logo() throws InterruptedException {

//		boolean status = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();  //xpath needs to be updated
//		Assert.assertEquals(true, status);  //first one is expected and the other one is actual
		
		
		//just for practicing different locators 
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		
		
		
	WebElement password =driver.findElement(By.name("password"));   // here we have store this element in a 'password' variable. variable type is WebElement as everything on the webpage is a webelement 
	           password.click();    //this is the advantage of storing the element in a variable.
	           password.clear();
	           password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
	}

	@Then("I close the browser")
	public void i_close_the_browser() {
		driver.quit();
	}
}
