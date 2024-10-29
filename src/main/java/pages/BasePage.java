package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;


public abstract class BasePage {

    public WebDriver driver;
    Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickElement(By element){
        driver.findElement(element).click();
    }

    public String getTextFromElement(By element){
        return driver.findElement(element).getText();
    }

    public void insertText(By element, String text){
        driver.findElement(element).sendKeys(text);
    }

    public Boolean isElementDisplayed(By element){
        try{
            System.out.println(driver.findElement(element).getText());
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public List<WebElement> returnListOfElements(By element){
        return driver.findElements(element);
    }

    public void hoverElement(By locator){
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void clickInTheCenterOfAnElement(WebElement element){
        actions.moveToElement(element,0,0).click().build().perform();
    }

    public String getHrefFromElement(By locator){
        WebElement element = driver.findElement(locator);
        return element.getAttribute("href");
    }

    public void clearField(By element) {
        driver.findElement(element).clear();
    }

}
