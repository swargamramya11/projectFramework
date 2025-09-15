package Pages;

import Utilities.listeners;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static Utilities.GlobalVariables.Context.*;
import static Utilities.GlobalVariables.ScenarioContext.*;
import static Utilities.ReusableMethods.*;
import org.testng.annotations.*;

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

    //Single Method data provider
    @DataProvider(name = "ProvideSearch")
    public Object[][] getDataFromProvider() {
        return new Object[][]{
                {"Test"}, {"Automation"},
                {"Test1"}, {"Automation1"}
        };
    }

    @Test(dataProvider = "ProvideSearch")
    public void Userenters(String username, String password) {
        System.out.println(username);
        System.out.println(password);
    }

    //passing data depending on method names
    @DataProvider(name = "dynamic-data-provider")
    public Object[][] dynamicDpMethod(Method m) {
        if (m.getName().equals("testSum")) {
            return new Object[][]{{1, 2, 3}, {4, 5, 9}};
        } else if (m.getName().equals("testDiff")) {
            return new Object[][]{{5, 3, 2}, {10, 7, 3}};
        }
        return null;
    }

    @Test(dataProvider = "dynamic-data-provider")
    public void numbers(String x1, String x2, String x3) {
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);
    }

    //enable/disable test
    @Test(enabled=false)
    public void browser() {
        System.out.println("Url");
    }

//    @Ignore
//    public class IgnoredClass {
//
//        @Test
//        public void ignoredTest() {
//            System.out.println("This test is ignored.");
//        }
//    }

    //Priorotize tests
    @Test(priority = 1)
    public void openBrowser() {
        System.out.println("Opening Browser");
    }

    @Test(priority = 2)
    public void launchGoogle() {
        System.out.println("Launching Google");
    }

    @Test(priority = 3)
    public void performSearch() {
        System.out.println("Performing Search");
    }

    @Test(priority = 4)
    public void verifyTitle() {
        System.out.println("Verifying Title");
    }

    //Listeners at class level
    @Listeners(listeners.class)
    public class TestClass {
        @Test
        public void testMethod1() {
            System.out.println("Executing testMethod1");
        }

        @Test
        public void testMethod2() {
            System.out.println("Executing testMethod2");
        }
    }

    //Groups
    @Test(groups = "Sanity")
    public void grouping() {
        System.out.println("Verifying Groups");
    }
}