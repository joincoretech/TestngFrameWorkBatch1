package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

@FindBy(xpath = "//input[@class='name']")
    public WebElement  userNameBox;

@FindBy(id = "Psw")
    public WebElement passwordBox;

@FindBy(name = "submit")
    public WebElement submitButton;

@FindBy(xpath = "//div[@class='password-agileits']/following-sibling::h4")
public WebElement errorMessage;

public LoginPage(){
    PageFactory.initElements(driver, this);
}
}
