package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    String textAreaLocator = "//div[@class='windowViewMode-maximized active lafPageHost']//span[text()='%s']/../..//textarea";

    public void write(WebDriver driver, String label, String text) {
        if(null != text) {
            By inputByLocator = By.xpath(String.format(textAreaLocator, label));
            driver.findElement(inputByLocator).sendKeys(text);
        }
    }
}
