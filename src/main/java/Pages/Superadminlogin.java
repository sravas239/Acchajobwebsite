package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Superadminlogin {
    WebDriver driver;

    // Constructor to initialize PageFactory elements
    public Superadminlogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy annotation
    @FindBy(xpath = "//input[@id='username']")  // Replace placeholder or attributes if necessary
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")  // Replace placeholder or attributes if necessary
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")  // Login button
    private WebElement loginButton;

   
    

    // Actions
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

	

	public WebElement getUsernameFieldLocator() {
		// TODO Auto-generated method stub
		return null;
	}

	
}


