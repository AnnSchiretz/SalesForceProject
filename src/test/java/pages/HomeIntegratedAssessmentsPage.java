package pages;

import elements.Dropdown;
import elements.Input;
import elements.TextArea;
import models.HIS;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeIntegratedAssessmentsPage extends BasePage {
    private static final String URL = "https://seniorlink--staging.lightning.force.com/lightning/r/0064F000006lAKhQAM/related/Home_Assessments__r/view?ws=%2Flightning%2Fr%2FOpportunity%2F0064F000006lAKhQAM%2Fview";
    private static final By NEW_BUTTON = By.xpath("//div[contains(text(), 'New')]");
    private static final By NEXT_BUTTON = By.xpath("//span[contains(text(), 'Next')]");
    private static final By DUPLICATE_YES = By.xpath("//button[contains(@class,'slds-button slds-button') and text()='Yes']");
    private static final By SAVE_BUTTON = By.xpath("//div[@class='windowViewMode-maximized active lafPageHost']//span[text()='Save']");

    public HomeIntegratedAssessmentsPage(WebDriver driver) {
        super(driver);
    }

    public HomeIntegratedAssessmentsPage openPage(){
        driver.get(URL);
        isPageOpened();
        return this;
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        } catch (TimeoutException ex) {
            System.out.println("Page is not opened");
        }
    }

    public HomeIntegratedAssessmentsPage clickNew() {
        driver.findElement(NEW_BUTTON).click();
        return this;
    }

    public HomeIntegratedAssessmentsPage clickNext() {
        driver.findElement(NEXT_BUTTON).click();
        return this;
    }

    public HomeIntegratedAssessmentsPage clickYes() {
        driver.findElement(DUPLICATE_YES).click();
        return this;
    }

    public HomeIntegratedAssessmentsPage writeDate(HIS his) {
        new Input().write(driver, "Assessment Date", his.getAssessmentDate());
        new Input().write(driver, "Date Assessor Signed", his.getDateAssessorSigned());
        return this;
    }

    public HomeIntegratedAssessmentsPage writeTextInField(HIS his,String text) {
        TextArea fieldText = new TextArea();
        fieldText.write(driver, "Accessibility Concerns Explained", his.getAccessibilityConcernsExplained());
        fieldText.write(driver, "Home Description Comments", his.getHomeDescriptionComments());
        fieldText.write(driver, "Home Meaning Comments", his.getHomeMeaningComments());
        fieldText.write(driver, "Home Story Comments", text);
        fieldText.write(driver, "Home Stability Comments", text);
        fieldText.write(driver, "Energy Assistance Comments", his.getEnergyAssistanceComments());
        fieldText.write(driver, "Food Assistance Comments", text);
        fieldText.write(driver, "Smokers Comments", text);
        fieldText.write(driver, "Pets Comments", text);
        fieldText.write(driver, "Life Essentials General Comments", text);
        fieldText.write(driver, "Neighborhood Safety Comments", text);
        fieldText.write(driver, "General Security Comments", text);
        fieldText.write(driver, "Consumer Safety Comments", text);
        fieldText.write(driver, "Caregiver Safety Comments", text);
        fieldText.write(driver, "Home/Environment Comments", text);
        return this;
    }

    public HomeIntegratedAssessmentsPage select(HIS his){
        Dropdown dropdown = new Dropdown();
        dropdown.clickSelectList(driver,"Status" ,his.getStatus());
        dropdown.clickSelectList(driver, "Assessment Type", his.getAssessmentType());
        dropdown.clickSelectList(driver, "Dwelling Type","Single (Detached) dwelling");
        dropdown.clickSelectList(driver, "Family Living On","Single Level -- Upper");
        dropdown.clickSelectList(driver, "Accessibility Concerns", "No");
        dropdown.clickSelectList(driver, "Number of Bedrooms","2 Bedrooms");
        dropdown.clickSelectList(driver, "Internet in Home", "Yes");
        dropdown.clickSelectList(driver, "Stairs Required to Consumer Bedroom", "No");
        dropdown.clickSelectList(driver, "Wifi in Home","Yes");
        dropdown.clickSelectList(driver, "Number of Bathrooms","2 Bathrooms");
        dropdown.clickSelectList(driver, "Computer / Tablet in Home","Yes");
        dropdown.clickSelectList(driver, "Stairs Required to Consumer Bathroom","Yes");
        dropdown.clickSelectList(driver, "Caregiver Smart Phone","Yes");
        dropdown.clickSelectList(driver, "Caregiver Smart Phone Brand", "Android");
        dropdown.clickSelectList(driver, "Caregiver Technology Proficiency", "Poor");
        dropdown.clickSelectList(driver, "Home Ownership (Current Status)", "Owned by Other");
        dropdown.clickSelectList(driver, "Home Stability", "Appears Stable");
        dropdown.clickSelectList(driver, "Life Essentials", "Yes - Adequate");
        dropdown.clickSelectList(driver, "Food Assistance","Yes");
        dropdown.clickSelectList(driver, "Referral for Food Assistance", "Yes");
        dropdown.clickSelectList(driver, "Energy Assistance", "Yes");
        dropdown.clickSelectList(driver, "Referral for Energy Assistance", "Yes");
        dropdown.clickSelectList(driver, "Pets In Home?","Yes");
        dropdown.clickSelectList(driver, "Smokers in the Home", "No");
        dropdown.clickSelectList(driver, "Problems with Pets","No");
        dropdown.clickSelectList(driver, "Overall Safety Concerns","Deferred");
        dropdown.clickSelectList(driver, "Does Consumer Feel Safe?","Deferred");
        return this;
    }

    public HomeIntegratedAssessmentsPage completeForm(String text, HIS his){
        writeDate(his);
        writeTextInField(his,text);
        select(his);
        return this;
    }
    public void clickSave(){
        driver.findElement(SAVE_BUTTON).click();
    }
}
