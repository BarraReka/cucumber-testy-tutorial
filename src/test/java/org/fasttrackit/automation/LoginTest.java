package org.fasttrackit.automation;
import com.sdl.selenium.web.WebLocator;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends TestBase{

    @Test
    public void validLoginTest() {
      doLogin(USER_NAME, PASSWORD);

        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    @Test(dataProvider = "invalidUsers")
    public void invalidLoginTest(String user, String pass, String expectedMessage){
        doLogin(user, pass);

        WebElement errorMsg = driver.findElement(By.className("error-msg"));


        String message = errorMsg.getText();
        System.out.println();

        assertThat(message, is (expectedMessage));

    }

    @DataProvider
    public Object[][] invalidUsers(){
        return new Object[][]{
                {"wrong@user", "wrong.pass", "Invalid user or password!"},
                {"empty.pass@user", "", "Please enter your password!"},
                {"", "empty.user", "Please enter your email!"},
                {"", "", "Please enter your email!"}
        };

    }

     // "wrong@user", "wrong.pass", "Invalid user or password!"

}