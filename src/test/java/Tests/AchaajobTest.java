package Tests;

import org.testng.annotations.Test;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AchaajobTest extends BaseTest {

    // Test Case 1: Search for a Job
    @Test(priority = 1)
    public void searchJobTest() {
        Achaajobpage jobsPage = new Achaajobpage(driver);

        // Enter job search details
        jobsPage.enterSearchDetails("Software Developer | Bangalore | 2 years");

        // Perform search
        jobsPage.clickSearch();

        System.out.println("Search for job completed successfully.");
    }

    // Test Case 2: Register a New User
    @Test(priority = 2)
    public void registerNewUserTest() throws Exception {
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
        Thread.sleep(1000);

        System.out.println("Registration form submitted successfully.");
    }

    // Test Case 3: Click Login Button
    @Test(priority = 3)
    public void clickLoginTest() throws InterruptedException {
        Achaajobpage jobsPage = new Achaajobpage(driver);

        // Click Login button
        jobsPage.clickLogin();
        Thread.sleep(1000);

        System.out.println("Clicked on Login button successfully.");
    }

    // Test Case 4: Admin Login and Post Job
    @Test(priority = 4)
    public void adminLoginTest() {
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);

        try {
            driver.get("https://www.acchajobs.com/adminlogindynamic");

            // Wait for login form
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your username']")));

            // Perform login
            adminLoginPage.enterUsername("john.doe123");
            adminLoginPage.enterPassword("Test@1234");
            adminLoginPage.clickLogin();
            Thread.sleep(2000);

            System.out.println("Admin login executed successfully.");

            // Navigate to job section
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link router-link-active']"))).click();

            // Wait for job posting form
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));

            // Fill job posting form
            adminLoginPage.fillJobDetails(
                "Software Engineer", "IT", "Remote", "Full-time", "Hybrid", "2 years", "100000",
                true, "Job description text.", "Java, Python, Selenium", "Accha Jobs Pvt Ltd",
                "12/19/2024", "12/31/2024", "5", "Health Insurance, Paid Time Off", "Leading tech company."
            );

            // Save job details
            adminLoginPage.saveJob();

            System.out.println("Job details saved successfully.");
        } catch (Exception e) {
            System.out.println("Admin login or job posting failed: " + e.getMessage());
        }
    }

    // Test Case 5: Super Admin Login
    @Test(priority = 5)
    public void superAdminLoginTest() {
        Superadminlogin superadminlogin = new Superadminlogin(driver);

        driver.get("https://www.acchajobs.com/superadminlogin");

        // Wait for Super Admin login form
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));

        // Perform Super Admin login
        superadminlogin.enterUsername("admin");
        superadminlogin.enterPassword("admin@123");
        superadminlogin.clickLogin();

        System.out.println("Superadmin login test executed successfully.");
    }
}
