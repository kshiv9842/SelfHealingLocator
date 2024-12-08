package org.Shiv.tests;

import java.io.IOException;
import java.net.URISyntaxException;
import static org.Shiv.Pom.LandingPage.getLandingPage;
import org.Shiv.driver.SeleniumActions;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest{
    @Test
    public void getLandingPageTest() throws IOException, URISyntaxException, InterruptedException {
        SeleniumActions.verifyIsDisplayed (getLandingPage ().getCrossIconOnSignIn (),getLandingPage ().getParentCrossIconOnSignIn ());
        SeleniumActions.verifyIsDisplayed (getLandingPage ().getPersonalAccount (),getLandingPage ().getParentCrossIconOnSignIn ());
        SeleniumActions.click (getLandingPage ().getCrossIconOnSignIn (),getLandingPage ().getParentCrossIconOnSignIn ());
        SeleniumActions.verifyIsDisplayed (getLandingPage ().getFromCity (),getLandingPage ().getParentFromCity ());
        Thread.sleep (2000);
        System.out.println ("----"+"updated SuccessFully");
    }
}


