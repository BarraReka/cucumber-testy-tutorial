package org.fasttrackit.automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import org.fasttrackit.util.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class ExamplesTest extends TestBase{


    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    static WebLocator firstName =  new WebLocator().setText("John");
    static WebLocator lastName = new WebLocator().setText("Moore");

    static WebLocator email = new WebLocator().setText("nickwhite@mail.com");
    static WebLocator row = new WebLocator().setTag("tr").setChildNodes(email);

    static CheckBox select = new CheckBox(row);


    @Test
    public void selectRowTest() {
        //doLogin(USER_NAME, PASSWORD);


        select.click();
        System.out.println(select.getSelector());

        row.setChildNodes(firstName,lastName);

        select.click();
        LOGGER.debug(select.getSelector().toString());


    }

    public static void main(String[] args) {


        System.out.println(select.getSelector());

        row.setChildNodes(firstName,lastName);

        LOGGER.debug(select.getSelector().toString());
    }
}
