package org.fasttrackit.automation;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends TestBase{

    @Test
    public void validLoginTest() {
      doLogin("eu@fast.com","eu.pass" );

        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    @Test
    public void invalidUserAndPasswordTest(){
        doLogin("wrong@user", "wrong.pass");

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();
        System.out.println();

       assertThat(message, is ("Invalid user or password!"));

    }





}