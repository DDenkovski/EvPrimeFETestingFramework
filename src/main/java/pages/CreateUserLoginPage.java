package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateUserLoginPage extends BasePage{

    private By formTitle = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[1]");
    private By emailTextBox = By.name("email");
    private By passwordTextBox = By.name("password");
    private By goButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[1]/button");
    private By changeStateButton = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/div[4]/div[2]/button");
    private By errorList = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/ul");
    private By errorMessage = By.xpath("//*[@id=\"root\"]/div/div/main/div[2]/div/div/form/div/span");

    public CreateUserLoginPage(WebDriver driver){
        super(driver);
    }

    public void insertEmail(String email){
        insertText(emailTextBox, email);
    }

    public void insertPassword(String password){
        insertText(passwordTextBox, password);
    }

    public void clickGoButton(){
        clickElement(goButton);
    }

    public void clickChangeStateButton(){
        clickElement(changeStateButton);
    }

    public String getTextFromFormTitle(){
        return getTextFromElement(formTitle);
    }

    public List<WebElement> returnErrorList(){
        return returnListOfElements(errorList);
    }

    public String getErrorMessage(){
        return getTextFromElement(errorMessage);
    }

}
