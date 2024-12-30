package Tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
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

public class ManageInternshipsTest {

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
    private static final By STATUS_FIELD = By.xpath("//input[@formcontrolname='status']");
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
            // Navigate to admin login page
            driver.get("https://www.acchajobs.com/adminlogindynamic");

            // Log in as admin
            fillField(By.xpath("//input[@placeholder='Enter your username']"), "john.doe123");
            fillField(By.xpath("//input[@placeholder='Enter your password']"), "Test@1234");
            clickButton(By.xpath("//button[@type='submit']"));

            // Handle pop-up alert (if displayed)
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
                System.out.println("Admin logged in successfully.");
            } catch (TimeoutException e) {
                System.out.println("No alert displayed.");
            }

            // Navigate to the internship posting page
            clickButton(By.xpath("//a[normalize-space()='Internship']"));
            System.out.println("Navigated to internship page.");
        } catch (Exception e) {
            System.err.println("Setup failed: " + e.getMessage());
        }
    }

    @Test
    public void fillInternshipForm() {
        try {
            // Fill in the internship form
            fillField(TITLE_FIELD, "Software Engineer Intern");
            fillField(COMPANY_FIELD, "Tech Company");
            fillField(LOCATION_FIELD, "New York");
            fillField(DURATION_FIELD, "6 months");
            fillField(STIPEND_FIELD, "1000");
            fillField(QUALIFICATIONS_FIELD, "Bachelor's in Computer Science");
            fillField(SKILLS_FIELD, "Java, Selenium, TestNG");
            fillField(DESCRIPTION_FIELD, "Work on exciting projects with a talented team.");
            fillField(STATUS_FIELD, "Open");
            fillField(START_DATE_FIELD, "12/30/2024");
            fillField(LAST_DATE_FIELD, "12/31/2024");
            fillField(OPENINGS_FIELD, "10");
            fillField(PERKS_FIELD, "Free snacks, Flexible hours");
            fillField(COMPANY_DESCRIPTION_FIELD, "A company focused on delivering quality software solutions.");

            // Submit the form
            clickButton(CREATE_BUTTON);

            // Validate form submission
            boolean isSuccess = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    SUCCESS_MESSAGE, "Internship posted successfully."));
            Assert.assertTrue(isSuccess, "Internship form submission failed.");
            System.out.println("Internship form submitted successfully.");
        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            Assert.fail("Exception occurred during test execution.");
        }
    }

    @Test(priority = 1)
    public void handlePopUp() {
        try {
            // Wait for the alert to be present
            wait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Get the text of the alert
            String alertText = alert.getText();
            System.out.println("Alert text is: " + alertText);

            // Accept the alert (click "OK")
            alert.accept();

            // Verify the alert text if needed
            Assert.assertEquals(alertText, "Waiting for Super-Admin Approval", "Alert text does not match.");
            System.out.println("Pop-up handled successfully.");
        } catch (TimeoutException e) {
            System.err.println("No pop-up appeared.");
            Assert.fail("Pop-up not found.");
        } catch (NoSuchElementException e) {
            System.err.println("Failed to handle the pop-up: " + e.getMessage());
            Assert.fail("Pop-up handling failed.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Utility method to fill input fields
    private void fillField(By locator, String value) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
        } catch (NoSuchElementException e) {
            System.err.println("Field not found: " + locator);
            throw e;
        }
    }

    // Utility method to click buttons
    private void clickButton(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Button not found: " + locator);
            throw e;
        }
    }
}
