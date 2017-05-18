package automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name="username")
    public WebElement userNameElement;
    @FindBy(id="password")
    public WebElement passwordElement;
    @FindBy(id="loginButton")
    public WebElement loginBtn;



}
