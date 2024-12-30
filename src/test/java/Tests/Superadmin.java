package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Superadmin {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the super admin login page
            driver.get("https://www.acchajobs.com/superadminlogin");

            // Log in as super admin
            loginAsSuperAdmin(driver, wait, "admin", "admin@123");

            // Handle login alert
            handleAlert(wait, "Login successful!");

            // Approve the job post
            String jobId = "19";
            approveJobPost(driver, wait, jobId);

            // Validate approval
            validateApproval(driver, wait, jobId);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void loginAsSuperAdmin(WebDriver driver, WebDriverWait wait, String username, String password) {
        // Enter username
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
        usernameField.sendKeys(username);

        // Enter password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys(password);

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for login to complete
        wait.until(ExpectedConditions.urlContains("super-admin"));
    }

    private static void handleAlert(WebDriverWait wait, String expectedText) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        if (alertText.equals(expectedText)) {
            alert.accept();
            System.out.println("Alert handled: " + expectedText);
        } else {
            System.err.println("Unexpected alert text: " + alertText);
            alert.accept();
        }
    }

    private static void approveJobPost(WebDriver driver, WebDriverWait wait, String jobId) {
        // Locate the job card by ID
        WebElement jobCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(text(), 'ID: " + jobId + "')]/ancestor::div[contains(@class, 'card')]")
        ));

        // Click the "Approve" button
        WebElement approveButton = jobCard.findElement(By.xpath(".//button[contains(text(), 'Approve')]"));
        approveButton.click();
        System.out.println("Job post with ID: " + jobId + " has been approved.");
    }

    private static void validateApproval(WebDriver driver, WebDriverWait wait, String jobId) {
        // Check for approval status
        WebElement jobCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(text(), 'ID: " + jobId + "')]/ancestor::div[contains(@class, 'card')]")
        ));
        WebElement statusElement = jobCard.findElement(By.xpath(".//span[contains(text(), 'Approved')]"));

        if (statusElement.isDisplayed()) {
            System.out.println("Approval confirmed for Job ID: " + jobId);
        } else {
            System.err.println("Approval status not updated for Job ID: " + jobId);
        }
    }
}
