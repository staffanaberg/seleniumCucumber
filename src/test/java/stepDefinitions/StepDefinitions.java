package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.GenerateData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;
	GenerateData gd = new GenerateData();
	String generatedUser = gd.generateUsername();
	String generatedEmail = gd.generateEmail();
	// --- Methods used several times---//
	@Given("I have entered email into the form")
	public void i_have_entered_email_into_the_form() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver.exe");

		driver = new ChromeDriver(); 
		driver.get("https://login.mailchimp.com/signup/"); 
		Thread.sleep(1000); 
		WebElement email = driver.findElement(By.id("email")); 
		email.sendKeys(generatedEmail); 
		Thread.sleep(1000); 
	}

	@And("I have also entered username into the form")
	public void i_have_also_entered_username_into_the_form() {
		WebElement newUserName = driver.findElement(By.id("new_username"));
		newUserName.sendKeys(generatedUser);
	}
	
	

	@And("I have also entered password {string} into the form")
	public void i_have_also_entered_password_into_the_form(String password) {

		WebElement newPassword = driver.findElement(By.id("new_password"));
		newPassword.sendKeys("TestTestar1337!");
	}

	@When("I press Sign up")
	public void i_press_sign_up() {

		WebElement form = driver.findElement(By.id("signup-form"));
		form.submit();

	}

	// ---Unique methods--- //

	@And("I have also entered too long username {string} into the form")
	public void i_have_also_entered_too_long_username_into_the_form_test(String userEntered) {

		WebElement newUserName = driver.findElement(By.id("new_username"));
		newUserName.sendKeys(
				"TESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestarTESTtestar");
	}

	@And("I have also entered a busy username {string} into the form")
	public void i_have_also_entered_a_busy_username_into_the_form(String userEntered) {

		WebElement newUserName = driver.findElement(By.id("new_username"));
		newUserName.sendKeys("username");
	}

	@Given("I have entered no email into the form")
	public void i_have_entered_no_email_into_the_form() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\emmal\\Documents\\Eclipse\\mydrivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver(); 
		driver.get("https://login.mailchimp.com/signup/"); 
		Thread.sleep(2000); 
		WebElement email = driver.findElement(By.id("email")); 
		email.sendKeys(""); 
		Thread.sleep(2000); 

	}
	// --Error handling --///

	@Then("the confirmation message should be {string} displayed")

	public void the_confirmation_message_should_be_displayed(String error) throws InterruptedException {
		Thread.sleep(2000);
		String actualMessage = driver.getTitle();
		String expectedMessage = "Success | Mailchimp";
		assertEquals(expectedMessage, actualMessage);
		driver.quit();
	}

	@Then("the error message should be {string} displayed")

	public void the_error_message_should_be_displayed_test(String error) throws InterruptedException {

		WebElement errorMessage = driver.findElement(By.className("invalid-error"));
		String expectedMessage = errorMessage.getText();
		String actualMessage = "Enter a value less than 100 characters long";
		assertEquals(expectedMessage, actualMessage);
		driver.quit(); 
	}

	@Then("the error message for busy username should be {string} displayed")

	public void the_error_message_for_busy_username_should_be_displayed(String error) throws InterruptedException {

		WebElement errorMessage = driver.findElement(By.className("invalid-error"));
		String expectedMessage = errorMessage.getText();
		String actualMessage = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";
		assertEquals(expectedMessage, actualMessage);
		driver.quit(); 
	}

	@Then("the error message for no value should be {string} displayed")

	public void the_error_message_for_no_value_should_be_displayed(String error) {

		WebElement errorMessage = driver.findElement(By.className("invalid-error"));
		String expectedMessage = errorMessage.getText();
		String actualMessage = "Please enter a value";
		assertEquals(expectedMessage, actualMessage);
		driver.quit(); 
	}

}