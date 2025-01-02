package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InternshipPage {
    WebDriver driver;

    // Locators for form fields
    By titleField = By.id("title"); // Replace with actual locator
    By companyField = By.id("company"); // Replace with actual locator
    By locationField = By.id("location"); // Replace with actual locator
    By durationField = By.id("duration"); // Replace with actual locator
    By stipendField = By.id("stipend"); // Replace with actual locator
    By qualificationsField = By.id("qualifications"); // Replace with actual locator
    By skillsField = By.id("skills"); // Replace with actual locator
    By descriptionField = By.id("description"); // Replace with actual locator
    By statusDropdown = By.id("status"); // Replace with actual locator
    By openingDateField = By.id("openingDate"); // Replace with actual locator
    By lastApplyDateField = By.id("lastApplyDate"); // Replace with actual locator
    By numberOfOpeningsField = By.id("numberOfOpenings"); // Replace with actual locator
    By perksField = By.id("perks"); // Replace with actual locator
    By companyDescriptionField = By.id("companyDescription"); // Replace with actual locator
    By createButton = By.xpath("//button[text()='Create']");
    By resetButton = By.xpath("//button[text()='Reset']");

    // Constructor
    public InternshipPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with web elements
    public void enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void enterCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void enterLocation(String location) {
        driver.findElement(locationField).sendKeys(location);
    }

    public void enterDuration(String duration) {
        driver.findElement(durationField).sendKeys(duration);
    }

    public void enterStipend(String stipend) {
        driver.findElement(stipendField).sendKeys(stipend);
    }

    public void enterQualifications(String qualifications) {
        driver.findElement(qualificationsField).sendKeys(qualifications);
    }

    public void enterSkills(String skills) {
        driver.findElement(skillsField).sendKeys(skills);
    }

    public void enterDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
    }

    public void selectStatus(String status) {
        driver.findElement(statusDropdown).sendKeys(status); // Replace with Select if dropdown
    }

    public void enterOpeningDate(String date) {
        driver.findElement(openingDateField).sendKeys(date);
    }

    public void enterLastApplyDate(String date) {
        driver.findElement(lastApplyDateField).sendKeys(date);
    }

    public void enterNumberOfOpenings(String openings) {
        driver.findElement(numberOfOpeningsField).sendKeys(openings);
    }

    public void enterPerks(String perks) {
        driver.findElement(perksField).sendKeys(perks);
    }

    public void enterCompanyDescription(String companyDescription) {
        driver.findElement(companyDescriptionField).sendKeys(companyDescription);
    }

    public void clickCreate() {
        driver.findElement(createButton).click();
    }

    public void clickReset() {
        driver.findElement(resetButton).click();
    }
}
