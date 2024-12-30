package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Achaajobpage {

    // Constructor to initialize PageFactory elements
    public Achaajobpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy annotation
    @FindBy(xpath = "//input[@placeholder='Enter skills/designations | Enter location | Enter Experience']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),'Register Now')]")
    private WebElement registerNowButton;

    @FindBy(xpath = "//button[@class='login-button']")
    private WebElement loginButton;

    // Actions/Methods to interact with elements
    public void enterSearchDetails(String details) {
        searchField.clear();
        searchField.sendKeys(details);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public void clickRegisterNow() {
        registerNowButton.click();
    }

    public void clickLogin() {
        loginButton.click();
    }
}
