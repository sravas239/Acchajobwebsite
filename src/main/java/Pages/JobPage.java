package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobPage {
    WebDriver driver;

    // Locate elements using @FindBy
    
    @FindBy(xpath="//a[@class='nav-link router-link-active']")  // Replace with actual id or locator
    WebElement job;
    
    @FindBy(id = "title")  // Replace with actual id or locator
    WebElement titleInput;

    @FindBy(name = "category")  // Replace with actual name or locator
    WebElement categoryInput;

    @FindBy(xpath = "//input[@id='location']")
    WebElement locationInput;

    @FindBy(name = "employmentType")
    WebElement employmentTypeDropdown;

    @FindBy(id = "workModel")
    WebElement workModelDropdown;

    @FindBy(xpath = "//input[@id='experience']")  // Replace with actual class name
    WebElement experienceInput;
    
    @FindBy(id = "salary")  // Replace with the actual ID
    WebElement salaryInput;

    @FindBy(id = "status")  // Replace with the actual ID
    WebElement statusCheckbox;

    @FindBy(id = "jobDescription")  // Replace with the actual ID
    WebElement jobDescriptionInput;

    @FindBy(name = "skills")  // Replace with actual Name
    WebElement skillsInput;

    @FindBy(name = "company")  // Replace with actual Name
    WebElement companyInput;

    @FindBy(id = "openingStartDate")  // Replace with actual ID
    WebElement openingStartDateInput;

    @FindBy(id = "lastApplyDate")  // Replace with actual ID
    WebElement lastApplyDateInput;

    @FindBy(name = "numberOfOpenings")  // Replace with actual Name
    WebElement numberOfOpeningsInput;

    @FindBy(name = "perks")  // Replace with actual Name
    WebElement perksInput;

    @FindBy(id = "companyDescription")  // Replace with actual ID
    WebElement companyDescriptionInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveJobButton;

   

    // Constructor to initialize the elements
    public JobPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions to fill the form
    public void fillJobDetails( String title, String category, String location, String employmentType, 
                               String workModel, String experience, String salary, boolean isActive, 
                               String jobDescription, String skills, String company, String openingStartDate, 
                               String lastApplyDate, String numberOfOpenings, String perks, String companyDescription) {
    	
        titleInput.sendKeys(title);
        categoryInput.sendKeys(category);
        locationInput.sendKeys(location);
        employmentTypeDropdown.sendKeys(employmentType);
        workModelDropdown.sendKeys(workModel);
        experienceInput.sendKeys(experience);
        salaryInput.sendKeys(salary);
        if (isActive) statusCheckbox.click();  // Assuming it’s a checkbox
        jobDescriptionInput.sendKeys(jobDescription);
        skillsInput.sendKeys(skills);
        companyInput.sendKeys(company);
        openingStartDateInput.sendKeys(openingStartDate);
        lastApplyDateInput.sendKeys(lastApplyDate);
        numberOfOpeningsInput.sendKeys(numberOfOpenings);
        perksInput.sendKeys(perks);
        companyDescriptionInput.sendKeys(companyDescription);
    }
public void job()
{
	job.click();
}
    
    // Action to save job
    public void saveJob() {
        saveJobButton.click();
    }    
}

