package tests;

import models.HIS;
import pages.HomeIntegratedAssessmentsPage;
import pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.PropertyManager;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class SalesForceTest extends BaseTest {
    @Test
    public void loginAndCreateForm(){
        logIn(driver, props);
        createPage(driver);
    }
    public static void logIn (WebDriver driver, PropertyManager props){
        LogInPage login = new LogInPage(driver);
        login.isOpen();
        login.logInUser(props.get("username"),props.get("password"));
    }

    public static void createPage(WebDriver driver){
        String text = "Vad är Lorem Ipsum?" +
                "Lorem ipsum har varit standard ända sedan 1500-talet, när en okänd boksättare tog ";
        HIS his = HIS.builder()
                .assessmentDate(generateRandomDate().toString())
                .dateAssessorSigned(generateRandomDate().toString())
                .accessibilityConcernsExplained(text)
                .homeDescriptionComments(text)
                .homeMeaningComments(text)
                .energyAssistanceComments(text)
                .status("In Progress")
                .assessmentType("Update")
                .build();
        new HomeIntegratedAssessmentsPage(driver)
                .openPage()
                .clickNew()
                .clickNext()
                .clickYes()
                .completeForm(text, his)
                .clickSave();
    }

    private static LocalDate generateRandomDate(){
        LocalDate start = LocalDate.of(2020, Month.JANUARY, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDate.now());
        LocalDate randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return randomDate;
    }
}
