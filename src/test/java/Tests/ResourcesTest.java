package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class ResourcesTest {

    WebDriver driver;
    Pages.ResourcesPage resourcesPage;

    @BeforeClass
    public void setup() {
        // Set up WebDriver (update with your driver path)
       
        driver = new ChromeDriver();
     
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://www.acchajobs.com/");

        // Initialize the page class
        resourcesPage = new Pages.ResourcesPage(driver);
    }

    @Test(priority = 1)
    public void testBlogNavigation() {
        resourcesPage.clickBlog();
        System.out.println("Navigated to Blog page successfully.");
    }

    @Test(priority = 2)
    public void testInternshipTipsNavigation() {
        resourcesPage.clickInternshipTips();
        System.out.println("Navigated to Internship Tips page successfully.");
    }

    @Test(priority = 3)
    public void testSkillsDevelopmentNavigation() {
        resourcesPage.clickSkillsDevelopment();
        System.out.println("Navigated to Skills Development page successfully.");
    }

    @Test(priority = 4)
    public void testResumeGeneratorNavigation() {
        resourcesPage.clickResumeGenerator();
        System.out.println("Navigated to Resume Generator page successfully.");
    }

    @Test(priority = 5)
    public void testInterviewTipsNavigation() {
        resourcesPage.clickInterviewTips();
        System.out.println("Navigated to Interview Tips page successfully.");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
