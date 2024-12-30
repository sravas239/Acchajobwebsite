package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Viewmore {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver and initialize the driver
    
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the webpage
        driver.get("https://www.acchajobs.com/view-all-jobs");
    }

    @Test
    public void testViewMoreButton() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(05));

        // Locate the "View More" button and scroll into view if needed
		WebElement viewMoreButton = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//div[@class='job-cards-grid']//div[1]//button[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewMoreButton);

		// Click the "View More" button
		viewMoreButton.click();
		System.out.println("View More button clicked");

		// Wait for job details to appear (adjust locator as needed)
		WebElement jobDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jobDetails")));
		Assert.assertTrue(jobDetails.isDisplayed(), "Job details are not displayed after clicking View More");

		// Validate the contents of the job details
		String jobDescription = jobDetails.getText();
		Assert.assertTrue(jobDescription.contains("Job Description"), "Job description is not as expected");
		System.out.println("Job details verified successfully.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
