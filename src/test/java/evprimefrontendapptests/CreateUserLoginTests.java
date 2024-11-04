package evprimefrontendapptests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateUserLoginPage;
import pages.SidePanel;
import util.DateBuilder;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CreateUserLoginTests {

    private WebDriver driver;
    private SidePanel sidePanel;
    private CreateUserLoginPage createUserLoginPage;
    private DateBuilder dateBuilder = new DateBuilder();

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        sidePanel = new SidePanel(driver);
        createUserLoginPage = new CreateUserLoginPage(driver);
        sidePanel.navigateTo("http://localhost:3000");
        sidePanel.clickMenuIcon();
        Thread.sleep(2000);
        sidePanel.clickLoginButton();
    }

    @Test
    public void createUserTest() throws InterruptedException {
        createUserLoginPage.insertEmail("mail" + dateBuilder.currentTime() +"@mail.com");
        createUserLoginPage.insertPassword("pass12345pass");

        createUserLoginPage.clickChangeStateButton();
        assertEquals("Create new user", createUserLoginPage.getTextFromFormTitle());
        createUserLoginPage.clickGoButton();

        sidePanel.clickLoginButton();
        assertEquals("Log in", createUserLoginPage.getTextFromFormTitle());

        createUserLoginPage.clickGoButton();
        Thread.sleep(3000); // because there is a possible bug and the user is not logging in on the first try
        createUserLoginPage.clickGoButton(); // because there is a possible bug and the user is not logging in on the first try
        Thread.sleep(3000);

        assertFalse(sidePanel.isLoginButtonDisplayed());
        assertEquals("Log out", sidePanel.getTextFromLogOutButton());
    }

    @Test
    public void invalidMailErrorMessage() throws InterruptedException {
        createUserLoginPage.insertEmail("wrongMail@mail.com");
        createUserLoginPage.insertPassword("pass12345pass");
        createUserLoginPage.clickGoButton();

        assertEquals("Authentication failed.", createUserLoginPage.getErrorMessage());
    }

    @Test
    public void invalidPasswordErrorMessage() throws InterruptedException {
        String mail = "mail" + dateBuilder.currentTime() +"@mail.com";
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword("pass12345pass");

        createUserLoginPage.clickChangeStateButton();
        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);

        sidePanel.clickLoginButton();
        Thread.sleep(1000);
        createUserLoginPage.insertEmail(mail);
        createUserLoginPage.insertPassword("pass12345passs");

        createUserLoginPage.clickGoButton();
        Thread.sleep(1000);
        assertEquals("Invalid email or password entered.", createUserLoginPage.returnErrorList().get(0).getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}