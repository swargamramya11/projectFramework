package Pages;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import static Utilities.GlobalVariables.Context.*;
import static Utilities.GlobalVariables.ScenarioContext.*;
import static Utilities.ReusableMethods.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "(//input[@type='email'])")
    WebElement enteremail;

    @FindBy(xpath = "//button[text()='Continue shopping']")
    WebElement continueShopping;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']//parent::div//parent::a")
    WebElement signIn;

    public void enterEmail(String email) {
        enterData(enteremail, getProp(email));
        setContext(USERNAME, email);
    }

    public void contineShopping() {
        clickElement(continueShopping);
    }

    public void clickSignIn() {
        clickElement(signIn);
    }
}