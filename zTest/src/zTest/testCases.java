package zTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//test cases created based on validations available on Sign Up page.

public class testCases extends superClass {

	public testCases(WebDriver driver1) {
		
		this.driver = driver1;
	}

	public void executeTC() {

		driver.get(baseUrl);
		wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ch_signup_icon")));

		verifyMandatoryFields();
		invalidEmailAddressValidation();
		invalidPhoneValidation();
		passwordValidations();
		accountAlreadyExist();
		// To execute below scenario, need to provide unique valid data, hence commented for now
		//signUpWithValidData();
	}

	// Verify mandatory fields
	public void verifyMandatoryFields() {

		try {
			driver.findElement(By.id("ch_signup_icon")).click();
			wait = new WebDriverWait(driver, 100);
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign up with MakeMyTrip']")));

			driver.findElement(By.id("ch_signup_btn")).click();
			String validation;
			
			//Email address validation
			validation = driver.findElement(By.xpath("//span[text()='Please enter an Email Address']")).getText();
			
			if (!validation.equals("Please enter an Email Address")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}
			
			//Phone number validation
			validation = driver.findElement(By.xpath("//span[text()='Please enter a valid Phone Number']")).getText();
			if (!validation.equals("Please enter a valid Phone Number")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}
			
			//Password validation
			validation = driver.findElement(By.xpath("//span[text()='Please enter a password']")).getText();
			if (!validation.equals("Please enter a password")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Verify validation for invalid email address
	public void invalidEmailAddressValidation() {

		try {

			driver.findElement(By.id("ch_signup_email")).sendKeys("abc123");
			driver.findElement(By.id("ch_signup_btn")).click();
			String validation = driver.findElement(By.xpath("//span[text()='Please enter a valid Email Address']"))
					.getText();

			if (!validation.equals("Please enter a valid Email Address")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Verify validation for invalid Phone number
	public void invalidPhoneValidation() {

		try {

			driver.findElement(By.id("ch_signup_phone")).sendKeys("abc123");
			driver.findElement(By.id("ch_signup_btn")).click();
			String validation = driver.findElement(By.xpath("//span[text()='Please enter a valid Phone Number']"))
					.getText();

			if (!validation.equals("Please enter a valid Phone Number")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Password validations
	public void passwordValidations() {

		try {

			driver.findElement(By.id("ch_signup_password")).sendKeys("abc");
			driver.findElement(By.id("ch_signup_btn")).click();
			String validation = driver
					.findElement(By.xpath("//span[text()='The password should be minimum of 8 characters']")).getText();

			if (!validation.equals("The password should be minimum of 8 characters")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}

			driver.findElement(By.id("ch_signup_password")).clear();
			driver.findElement(By.id("ch_signup_password")).sendKeys("abcajsdkjhas");
			driver.findElement(By.id("ch_signup_btn")).click();
			validation = driver.findElement(By.xpath(
					"//span[text()='The password should contain atleast 1 numeric & 1 special charatcer(@$!%*#?&)']"))
					.getText();

			if (!validation.equals("The password should contain atleast 1 numeric & 1 special charatcer(@$!%*#?&)")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Account already exist
	public void accountAlreadyExist() {

		try {

			// need to provide duplicate email address to check duplicate message
			driver.findElement(By.id("ch_signup_email")).clear();
			driver.findElement(By.id("ch_signup_email")).sendKeys("xyz@gmail.com");
			driver.findElement(By.id("ch_signup_phone")).clear();
			driver.findElement(By.id("ch_signup_phone")).sendKeys("8000175020");
			driver.findElement(By.id("ch_signup_password")).clear();
			driver.findElement(By.id("ch_signup_password")).sendKeys("Test@123");
			driver.findElement(By.id("ch_signup_btn")).click();

			String validation = driver
					.findElement(By.xpath(
							"//span[text()='Sorry!This Email is already Registered.Please choose a different email.']"))
					.getText();

			if (!validation.equals("Sorry!This Email is already Registered.Please choose a different email.")) {
				System.out.println("Status = Fail, Validation message is not as expected. Actual validation message = "
						+ validation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SignUp with valid data
	public void signUpWithValidData() {

		try {
			// Need to provide unique details(email & phone) in sendkeys to execute this
			// scenario
			driver.findElement(By.id("ch_signup_email")).clear();
			driver.findElement(By.id("ch_signup_email")).sendKeys("xyz@123.com");
			driver.findElement(By.id("ch_signup_phone")).clear();
			driver.findElement(By.id("ch_signup_phone")).sendKeys("8000175020");
			driver.findElement(By.id("ch_signup_password")).clear();
			driver.findElement(By.id("ch_signup_password")).sendKeys("Test@123");
			driver.findElement(By.id("ch_signup_btn")).click();
			Thread.sleep(2000);

			driver.get("https://supportz.makemytrip.com/MyAccount/User");

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile_editpersonal_img")));

			String phoneNum = driver.findElement(By.xpath("//span[text()='918000175020']")).getText();
			String emailAddress = driver.findElement(By.xpath("//span[text()='sahaj_1415@yahoo.com']")).getText();

			if (!phoneNum.equals("") && !emailAddress.equals("")) {
				System.out.println("Status = Fail, header title is not as expected.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
