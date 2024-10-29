package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventsPage extends BasePage {

    private By plusButton = By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    private By addEventButton = By.xpath("//*[@id=\"SpeedDial-actions\"]/button");
    private By eventTitle = By.name("title");
    private By eventImage = By.name("image");
    private By eventDate = By.name("date");
    private By eventLocation = By.name("location");
    private By eventDescription = By.name("description");
    private By createEventButton = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/form/div/button");
    private By firstEventImage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/ul/li");
    private By eventList = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/ul");
    private By eventListWhenLoggedIn = By.xpath("//*[@id=\"root\"]/div/div[1]/main/div[2]/ul");

    public EventsPage(WebDriver driver){
        super(driver);
    }

    public void hoverPlusButton(){
        hoverElement(plusButton);
    }

    public void clickAddEventButton(){
        clickElement(addEventButton);
    }

    public void insertEventTitle(String title){
        insertText(eventTitle, title);
    }

    public void insertEventImage(String image){
        insertText(eventImage, image);
    }

    public void insertEventDate(String date){
        insertText(eventDate, date);
    }

    public void insertEventLocation(String location){
        insertText(eventLocation, location);
    }

    public void clickEventDescription(){
        clickElement(eventDescription);
    }

    public void insertEventDescription(String description){
        insertText(eventDescription, description);
    }

    public void clickFirstEventImage(){
        clickElement(firstEventImage);
    }

    public List<WebElement> returnEventList(){
        return returnListOfElements(eventList);
    }

    public List<WebElement> returnEventListWhenLoggedIn(){
        return returnListOfElements(eventListWhenLoggedIn);
    }

    public void clickCreateEventButton(){
        clickElement(createEventButton);
    }

    public void chooseEvent(int index){
        List<WebElement> events = returnEventListWhenLoggedIn();
        clickInTheCenterOfAnElement(events.get(index));
    }
}
