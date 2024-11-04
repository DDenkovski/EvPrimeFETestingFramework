package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventPage extends BasePage {

    private By eventTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[1]/h2");
    private By eventTitleWhenLoggedIn = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[1]/div[1]/h2");
    private By eventDate = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[2]/h6");
    private By eventLocation = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[1]/div[3]/h6");
    private By eventDescription = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[2]/span");
    private By backToEventsButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div[1]/div[2]/button/a");
    private By editButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/div[1]/div[2]/button[1]");

    private By eventTitleField = By.name("title");

    private By eventDateField = By.name("date");
    private By updateButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");

    public EventPage(WebDriver driver){
        super(driver);
    }

    @Override
    public CreateUserLoginPage newInstance(WebDriver driver) {
        return new CreateUserLoginPage(driver);
    }

    public String getEventTitle(){
        return getTextFromElement(eventTitle);
    }

    public String getEventDate(){
        return getTextFromElement(eventDate);
    }

    public String getEventLocation(){
        return getTextFromElement(eventLocation);
    }

    public String getEventDescription(){
        return getTextFromElement(eventDescription);
    }

    public String getHrefFromBackToEventsButton(){
        return getHrefFromElement(backToEventsButton);
    }

    public String getTextFromBackToEventsButton(){
        return getTextFromElement(backToEventsButton);
    }

    public void clickEditButton(){
        clickElement(editButton);
    }

    public void eventTitleInsertText(String title){
        insertText(eventTitleField, title);
    }

    public void clickUpdateButton(){
        clickElement(updateButton);
    }

    public String getEventTitleFieldWhenLoggedIn(){
        return getTextFromElement(eventTitleWhenLoggedIn);
    }

    public String getEditEventButtonText(){
        return getTextFromElement(editButton);
    }

    public String getUpdateButtonText(){
        return getTextFromElement(updateButton);
    }
}