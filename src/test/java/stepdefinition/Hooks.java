package stepdefinition;

import base.BasePage;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        BasePage.initializeDriver();
    }

    @After
    public void tearDown() {
        BasePage.quitDriver();
    }
}
