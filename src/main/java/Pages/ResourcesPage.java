package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResourcesPage {

    WebDriver driver;

    // Constructor to initialize page elements
    public ResourcesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for Resources menu
    @FindBy(linkText = "Blog")
    private WebElement blogOption;

    @FindBy(linkText = "Internship Tips")
    private WebElement internshipTipsOption;

    @FindBy(linkText = "Skills Development")
    private WebElement skillsDevelopmentOption;

    @FindBy(linkText = "Industry Trends")
    private WebElement industryTrendsOption;

    @FindBy(linkText = "Success Stories")
    private WebElement successStoriesOption;

    // Locators for Resume Generator submenu
    @FindBy(linkText = "Resume Generator")
    private WebElement resumeGeneratorOption;

    @FindBy(linkText = "Create Resume")
    private WebElement createResumeOption;

    @FindBy(linkText = "Edit Resume")
    private WebElement editResumeOption;

    // Locators for Career Guide submenu
    @FindBy(linkText = "Career Guide")
    private WebElement careerGuideOption;

    @FindBy(linkText = "Career Advice")
    private WebElement careerAdviceOption;

    @FindBy(linkText = "Guidance Articles")
    private WebElement guidanceArticlesOption;

    // Locators for Interview Tips submenu
    @FindBy(linkText = "Interview Tips")
    private WebElement interviewTipsOption;

    @FindBy(linkText = "Placement")
    private WebElement placementOption;

    @FindBy(linkText = "Mock Interview")
    private WebElement mockInterviewOption;

    // Actions
    public void clickBlog() {
        blogOption.click();
    }

    public void clickInternshipTips() {
        internshipTipsOption.click();
    }

    public void clickSkillsDevelopment() {
        skillsDevelopmentOption.click();
    }

    public void clickIndustryTrends() {
        industryTrendsOption.click();
    }

    public void clickSuccessStories() {
        successStoriesOption.click();
    }

    public void clickResumeGenerator() {
        resumeGeneratorOption.click();
    }

    public void clickCreateResume() {
        createResumeOption.click();
    }

    public void clickEditResume() {
        editResumeOption.click();
    }

    public void clickCareerGuide() {
        careerGuideOption.click();
    }

    public void clickCareerAdvice() {
        careerAdviceOption.click();
    }

    public void clickGuidanceArticles() {
        guidanceArticlesOption.click();
    }

    public void clickInterviewTips() {
        interviewTipsOption.click();
    }

    public void clickPlacement() {
        placementOption.click();
    }

    public void clickMockInterview() {
        mockInterviewOption.click();
    }
}
