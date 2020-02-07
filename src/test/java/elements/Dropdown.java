package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.JavascriptUtilities;


public class Dropdown {
    String clickDropdownLocator = "//span/span[text()='%s']/../..//a";
    String selectOption = "//div[contains(@class,'uiMenuList') and contains(@class, 'visible')]//a[contains(text(),'%s')]";

    public void clickSelectList(WebDriver driver, String label, String option) {
        By dropdownByLocator = By.xpath(String.format(clickDropdownLocator,label));
        driver.findElement(dropdownByLocator).click();
        By optionLocator = By.xpath(String.format(selectOption,option,label));
        JavascriptUtilities js = new JavascriptUtilities();
        js.clickJs(driver, driver.findElement(optionLocator));
    }
}
