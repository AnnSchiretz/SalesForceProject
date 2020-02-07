package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Input {
    String inputLocator = "//div[@class='windowViewMode-maximized active lafPageHost']//span[text()='%s']/../..//input";

    public void write(WebDriver driver, String label, String text) {
        if(null != text){
            try {
                By inputByLocator = By.xpath(String.format(inputLocator, label));
                driver.findElement(inputByLocator).sendKeys(text);
            }catch (Exception ex){
                Assert.fail(String.format("Cannot write test %s input with label %s", text, label));
                ex.printStackTrace();
            }
        }
    }
}
