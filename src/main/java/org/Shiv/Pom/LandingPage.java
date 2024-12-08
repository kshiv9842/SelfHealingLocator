package org.Shiv.Pom;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
@Data
@Getter
@Setter
public class LandingPage {
    private static final LandingPage LANDING_PAGE = new LandingPage ();

    public static LandingPage getLandingPage(){
        return LANDING_PAGE;
    }

    private By crossIconOnSignIn = By.className ("testcommonModal__close");
    private By parentCrossIconOnSignIn = By.xpath ("//div[@class='imageSlideContainer']");
    private By fromCity = By.id ("test-fromCity");
    private By parentFromCity = By.className ("minContainer");
    private By personalAccount = By.xpath ("//li[@data-cy='890personalLogin']");
}
