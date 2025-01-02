package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcchaJobsRegisterPage {

    // Constructor to initialize PageFactory elements
    public AcchaJobsRegisterPage(WebDriver driver2) {
        SearchContext driver = null;
		PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy annotation for the Register Form
    @FindBy(xpath = "//a[contains(text(),'Register Now')]")
    private WebElement registerNowButton;
    
    @FindBy(xpath = "//input[@id='fullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//input[@id='userName']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='emailId']")
    private WebElement emailField;

    @FindBy(xpath = "//select[@id='gender']")
    private WebElement genderDropdown;

    @FindBy(xpath = "//input[@id='mobileNo']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPassword;
      
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    // Action Methods
    public void clickRegisterNow() {
        registerNowButton.click();
    }
    public void enterFullName(String fullName) {
       
        fullNameField.sendKeys(fullName);
    }

    public void enterUsername(String username) {
       
        usernameField.sendKeys(username);
    }

    public void enterEmail(String email) {
       
        emailField.sendKeys(email);
    }

    public void selectGender(String gender) {
        genderDropdown.sendKeys(gender); // Replace with Select class for dropdown interaction
    }

    public void enterMobileNumber(String mobileNumber) {
       
        mobileNumberField.sendKeys(mobileNumber);
    }

    public void enterPassword(String password) {
     
        passwordField.sendKeys(password);
    }

    public void enterconfirmPassword(String password) {
    	
    	confirmPassword.sendKeys(password);
    	
    }
    
    public void clickRegister() {
        registerButton.click();
    }
	public void fillRegistrationForm(String string, String string2, String string3, String string4, String string5,
			String string6, String string7) {
		// TODO Auto-generated method stub
		
	}
	public By getRegisterNowButtonLocator() {
		// TODO Auto-generated method stub
		return null;
	}
	public void enterName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void enterMobile(String string) {
		// TODO Auto-generated method stub
		
	}
}
