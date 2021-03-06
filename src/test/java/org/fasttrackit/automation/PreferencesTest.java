package org.fasttrackit.automation;

import automation.PreferencesPage;
import automation.PreferencesView;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class PreferencesTest extends TestBase {

    private PreferencesView page = new PreferencesView();
//    private PreferencesPage page;
//    public PreferencesTest() {
//    page = PageFactory.initElements(driver, PreferencesPage.class);
//    }

    @Test
    public void preferencesWindowShouldCloseTest() {

        doLogin(USER_NAME, PASSWORD);

        page.open();

        page.close();

    }



    @Test
    public void tryToChangePasswordWithInvalidPreviousPasswordTest() {

        changePassword("wrong.pass", "new.pass", "new.pass");

        String message = page.getStatusMsg();
        assertThat(message, is("Your preview password is incorrect!"));
    }

    @Test
    public void tryToChangePasswordWithNewMismatchPasswordTest() {

        changePassword("eu.pass", "new.pass", "newmismatch.pass");

        String message = page.getStatusMsg();
        assertThat(message, is("Password does not match the confirm password!"));
    }

    @Test
    public void successChangePasswordTest() {

        changePassword(PASSWORD, "new.pass", "new.pass");

        String message = page.getStatusMsg();
        assertThat(message, is("Your password has been successfully changed."));



        page.close();
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

        PASSWORD="new.pass";
        doLogin(USER_NAME, PASSWORD);
        logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();

        //revert to old password
        changePassword(PASSWORD, "eu.pass", "eu.pass");
        PASSWORD="eu.pass";
    }

    private void changePassword(String pass, String newPass, String repeatPass) {
        doLogin(USER_NAME, PASSWORD);

        page.open();


       page.changePassword(pass, newPass, repeatPass);

    }

}


