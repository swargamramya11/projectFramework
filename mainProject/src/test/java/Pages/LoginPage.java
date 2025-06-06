package Pages;

import org.openqa.selenium.By;

import static Utilities.GlobalVariables.Context.*;
import static Utilities.GlobalVariables.ScenarioContext.setContext;
import static Utilities.ReusableMethods.*;

public class LoginPage {

    public static By enteremail = By.xpath("(//input[@type='email'])[2]");

    public static void enterEmail(String email) {
        enterData(enteremail, getProp(email));
        setContext(USERNAME, email);
// To get string form context
// String email = (String) getContext(USERNAME);
    }
}