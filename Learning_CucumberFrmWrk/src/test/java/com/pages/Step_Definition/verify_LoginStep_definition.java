package com.pages.Step_Definition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class verify_LoginStep_definition {

	private WebDriver driver;

	@Given("I am on the OrangeHRM login page")
	public void i_am_on_the_orange_hrm_login_page() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\drivers(C)\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://192.168.11.75:8002/login/");
		System.out.println("orangehrm page is displayed");
	}

	@When("I enter valid username {string} and valid password {string}")
	public void i_enter_valid_username_and_valid_password(String string, String string2) {
		System.out.println(driver);
		System.out.println(string);

		WebElement user = driver.findElement(By.xpath("//*[@id='userid\']"));
		user.sendKeys(string);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(string2);
		WebElement logintypeDropdown = driver.findElement(By.xpath("//*[@id='validationCustom05']"));
		Select obj = new Select(logintypeDropdown);
		obj.selectByValue("L2 Interface");

	}

	@When("I click the Login button")
	public void i_click_the_login_button() {
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='enter_credential']/div[4]"));
		loginButton.click();
		System.out.println("Clicked the login button");
	}

	@Then("I should be redirected to the OrangeHRM dashboard")
	public void i_should_be_redirected_to_the_orange_hrm_dashboard() {

		Assert.assertTrue("Howe page is not displayed", driver.getTitle().contains("Mieruka"));
		System.out.println("dashboard page is displayed");
	}
}
