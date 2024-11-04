package evprimefrontendapptests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateUserLoginPage;
import pages.EventPage;
import pages.EventsPage;
import pages.SidePanel;
import util.DateBuilder;

import static org.junit.Assert.assertEquals;

public class EventsTests {

    private WebDriver driver;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    private EventsPage  eventsPage;
    private EventPage eventPage;
    private DateBuilder dateBuilder = new DateBuilder();

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        eventsPage = new EventsPage(driver);
        eventPage = new EventPage(driver);
        sidePanel.navigateTo("http://localhost:3000");
        sidePanel.clickMenuIcon();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();

    }

    @Test
    public void createAnEvent() throws InterruptedException{

        sidePanel.clickLoginButton();

        String mail = "mail" + dateBuilder.currentTime() +"@mail.com";
        String pass = "pass12345pass";

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(pass);
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickLoginButton();
        Thread.sleep(5000);
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(pass);
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);
        sidePanel.clickEventsButton();
        Thread.sleep(3000);
        eventsPage.hoverPlusButton();
        Thread.sleep(3000);
        eventsPage.clickAddEventButton();

        eventsPage.insertEventTitle("Test Event");
        eventsPage.insertEventImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsmOYmAVTiI17DEx9bUhoPsxp_mYrxqyqeFZt-5Wscdw&s");
        eventsPage.insertEventDate("2021-12-12");
        eventsPage.insertEventLocation("test location");
        eventsPage.insertEventDescription("test description");
        eventsPage.clickCreateEventButton();
    }

    @Test
    public void eventValidation() throws InterruptedException {

        Thread.sleep(2000);
        eventsPage.chooseEvent(0);

        assertEquals("Event 1", eventPage.getEventTitle());
        assertEquals("24.02.2005", eventPage.getEventDate());
        assertEquals("sddsfdsfds", eventPage.getEventLocation());
        assertEquals("dfsfdfdsfsdfsdf", eventPage.getEventDescription());

    }

    @Test
    public void backToEventsButtonTest() throws InterruptedException {
        Thread.sleep(2000);
        eventsPage.chooseEvent(0);


        assertEquals("http://localhost:3000/events", eventPage.getHrefFromBackToEventsButton());
        assertEquals("BACK TO EVENTS", eventPage.getTextFromBackToEventsButton());
    }

    @Test
    public void updateEventDateTest() throws InterruptedException {
        sidePanel.clickLoginButton();

        String mail = "mail" + dateBuilder.currentTime() +"@mail.com";
        String pass = "pass12345pass";

        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(pass);
        Thread.sleep(2000);
        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.clickGoButton();
        Thread.sleep(2000);

        sidePanel.clickLoginButton();
        Thread.sleep(2000);
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword(pass);
        Thread.sleep(5000);
        createUserLoginPage.clickGoButton();
        Thread.sleep(5000);
        sidePanel.clickEventsButton();
        Thread.sleep(2000);
        eventsPage.chooseEvent(0);

        assertEquals("EDIT EVENT", eventPage.getEditEventButtonText());
        eventPage.clickEditButton();
        Thread.sleep(2000);
        eventPage.eventTitleInsertText("- Football Match");
        Thread.sleep(2000);
        assertEquals("UPDATE EVENT", eventPage.getUpdateButtonText());
        eventPage.clickUpdateButton();
        Thread.sleep(2000);
        assertEquals("Event 1- Football Match", eventPage.getEventTitleFieldWhenLoggedIn());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}