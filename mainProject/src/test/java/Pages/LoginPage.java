package Pages;

import org.openqa.selenium.By;

import static Utilities.BrowserDriver.getWebDriver;
import static Utilities.GlobalVariables.Context.USERNAME;
import static Utilities.GlobalVariables.ScenarioContext.setContext;

public class LoginPage {

    public static By enteremail = By.xpath("(//input[@type='email'])[2]");

    public static void enterEmail(String email) {
        getWebDriver().findElement(enteremail).sendKeys(email);
        setContext(USERNAME, email);
// To get string form context
// String email = (String) getContext(USERNAME);
    }
}