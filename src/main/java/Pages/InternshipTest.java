package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InternshipTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for form fields
    private static final By TITLE_FIELD = By.xpath("//input[@formcontrolname='title']");
    private static final By COMPANY_FIELD = By.xpath("//input[@formcontrolname='company']");
    private static final By LOCATION_FIELD = By.xpath("//input[@formcontrolname='location']");
    private static final By DURATION_FIELD = By.xpath("//input[@formcontrolname='duration']");
    private static final By STIPEND_FIELD = By.xpath("//input[@formcontrolname='stipend']");
    private static final By QUALIFICATIONS_FIELD = By.xpath("//input[@formcontrolname='qualifications']");
    private static final By SKILLS_FIELD = By.xpath("//input[@formcontrolname='skills']");
    private static final By DESCRIPTION_FIELD = By.xpath("//textarea[@formcontrolname='description']");
    private static final By STATUS_FIELD = By.xpath("//select[@class='ng-dirty ng-valid ng-touched']");
    private static final By START_DATE_FIELD = By.xpath("//input[@formcontrolname='openingStartDate']");
    private static final By LAST_DATE_FIELD = By.xpath("//input[@formcontrolname='lastApplyDate']");
    private static final By OPENINGS_FIELD = By.xpath("//input[@type='number']");
    private static final By PERKS_FIELD = By.xpath("//textarea[@formcontrolname='perks']");
    private static final By COMPANY_DESCRIPTION_FIELD = By.xpath("//textarea[@formcontrolname='companyDescription']");
    private static final By CREATE_BUTTON = By.xpath("//button[@type='submit']");
    private static final By SUCCESS_MESSAGE = By.id("successMessage");

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("https://www.acchajobs.com/adminlogindynamic");
            loginAsAdmin("tester@123", "Test@1234");
            navigateToInternshipPage();
        } catch (Exception e) {
            Assert.fail("Setup failed: " + e.getMessage());
        }
    }

    @Test
    public void fillInternshipForm() {
        try {
            fillField(TITLE_FIELD, "Software Engineer Intern");
            fillField(COMPANY_FIELD, "Tech Company");
            fillField(LOCATION_FIELD, "New York");
            fillField(DURATION_FIELD, "6 months");
            fillField(STIPEND_FIELD, "1000");
            fillField(QUALIFICATIONS_FIELD, "Bachelor's in Computer Science");
            fillField(SKILLS_FIELD, "Java, Selenium, TestNG");
            fillField(DESCRIPTION_FIELD, "Work on exciting projects with a talented team.");
            fillField(STATUS_FIELD, "Active");
            fillField(START_DATE_FIELD, "12/30/2024");
            fillField(LAST_DATE_FIELD, "12/31/2024");
            fillField(OPENINGS_FIELD, "10");
            fillField(PERKS_FIELD, "Free snacks, Flexible hours");

            clickButton(CREATE_BUTTON);

            Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    SUCCESS_MESSAGE, "Internship posted successfully.")), 
                    "Internship form submission failed.");
        } catch (Exception e) {
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void fillField(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    private void clickButton(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void loginAsAdmin(String username, String password) {
        fillField(By.xpath("//input[@placeholder='Enter your username']"), username);
        fillField(By.xpath("//input[@placeholder='Enter your password']"), password);
        clickButton(By.xpath("//button[@type='submit']"));

        try {
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (TimeoutException e) {
            // No alert present, continue
        }
    }

    private void navigateToInternshipPage() {
        clickButton(By.xpath("//a[normalize-space()='Internship']"));
    }
}