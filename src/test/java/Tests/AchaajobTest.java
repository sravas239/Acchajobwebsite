package Tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AcchaJobsRegisterPage;
import Pages.Achaajobpage;
import Pages.AdminLoginPage;
import Pages.BaseTest;
import Pages.Superadminlogin;

public class AchaajobTest extends BaseTest {

    // Test Case 1: Search for a Job
    @Test(priority = 1)
    public void searchJobTest() {
        try {
            Achaajobpage jobsPage = new Achaajobpage(driver);

            // Enter search details
            jobsPage.enterSearchDetails("Software Developer | Bangalore | 2 years");

            // Handle overlapping element using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement overlappingElement = (WebElement) js.executeScript(
                "return document.elementFromPoint(arguments[0], arguments[1]);", 672, 260
            );
            if (overlappingElement.getAttribute("class").equals("option")) {
                js.executeScript("arguments[0].style.visibility='hidden';", overlappingElement);
            }

            // Click search button using JavaScript
            WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-button']"));
            js.executeScript("arguments[0].click();", searchButton);

            System.out.println("Search for job completed successfully.");
        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
            Assert.fail("Job search test failed.");
        }
    }

    // Test Case 2: Register a New User
    //@Test(priority = 2)
    public void registerNewUserTest() {
        try {
            AcchaJobsRegisterPage registerPage = new AcchaJobsRegisterPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait and click 'Register Now' button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Register Now')]")));
            registerPage.clickRegisterNow();

            // Wait for registration form to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fullName']")));

            // Fill the registration form
            registerPage.enterFullName("John Doe");
            registerPage.enterUsername("john.doe123");
            registerPage.enterEmail("john.doe@example.com");
            registerPage.selectGender("Male");
            registerPage.enterMobileNumber("9876543210");
            registerPage.enterPassword("Test@1234");
            registerPage.enterconfirmPassword("Test@1234");

            // Submit the form
            registerPage.clickRegister();

            System.out.println("Registration form submitted successfully.");
        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
            Assert.fail("User registration test failed.");
        }
    }

    // Test Case 3: Click Login Button
    //@Test(priority = 3)
    public void clickLoginTest() {
        try {
            Achaajobpage jobsPage = new Achaajobpage(driver);

            // Click Login button
            jobsPage.clickLogin();

            System.out.println("Clicked on Login button successfully.");
        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
            Assert.fail("Login button click test failed.");
        }
    }

    // Test Case 4: Admin Login and Post Job
    @Test(priority = 4)
    public void adminLoginTest() {
        try {
            AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

            // Open Admin Login Page
            driver.get("https://www.acchajobs.com/adminlogindynamic");

            // Wait for the login form to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your username']")));

            // Perform Login
            adminLoginPage.enterUsername("tester@123");
            adminLoginPage.enterPassword("Test@1234");
            adminLoginPage.clickLogin();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept(); // Accept the alert

            // Wait for URL redirection and validate
            wait.until(ExpectedConditions.urlContains("save-job"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("save-job"), "Redirected to unexpected URL: " + currentUrl);

            System.out.println("Admin login executed successfully.");
        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
            Assert.fail("Admin login test failed.");
        }
    }

    // Test Case 5: Super Admin Login
    @Test(priority = 5)
    public void superAdminLoginTest() {
        try {
            Superadminlogin superadminlogin = new Superadminlogin(driver);

            // Open Super Admin Login Page
            driver.get("https://www.acchajobs.com/superadminlogin");

            // Wait for Super Admin login form
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));

            // Perform Super Admin login
            superadminlogin.enterUsername("admin");
            superadminlogin.enterPassword("admin@123");
            superadminlogin.clickLogin();

            System.out.println("Superadmin login test executed successfully.");
        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
            Assert.fail("Super Admin login test failed.");
        }
    }
}
