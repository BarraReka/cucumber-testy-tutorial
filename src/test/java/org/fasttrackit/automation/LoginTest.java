package org.fasttrackit.automation;
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
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        driver.findElement(By.name("username")).sendKeys("eu@fast.com");

        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("eu.passrererere");
        passwordElement.clear();
        passwordElement.sendKeys("eu.pass");

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }

    @Test
    public void invalidUserAndPasswordTest(){

        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");

        driver.findElement(By.name("username")).sendKeys("wrong@user");
        driver.findElement(By.id("password")).sendKeys("wrong.pass");
        driver.findElement(By.id("loginButton")).click();

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        String message = errorMsg.getText();
        System.out.println();

       assertThat(message, is ("Invalid user or password!"));

    }



}