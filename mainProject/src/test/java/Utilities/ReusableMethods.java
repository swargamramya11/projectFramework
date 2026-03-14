package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.restassured.path.json.JsonPath;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;

import static Utilities.BrowserDriver.*;
import static Utilities.GlobalVariables.Context.*;
import static Utilities.GlobalVariables.ScenarioContext.setContext;
import static Utilities.Props.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.AssertJUnit.assertTrue;

public class ReusableMethods {

    //Screenshots

    public static byte[] takesScreenshotAsByte() {
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static File takesScreenshotAsFile() {
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        return screenshot;
    }

    public static String createRandomStringWithDateAndTime(int length) {
        String randomString = createRandomString(length);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddss");
        String FormattedNow = now.format(formatter);

        return randomString + FormattedNow;
    }

    public static String createRandomString(int length) {
        String alphabets = "abcdefghilmnopqrstuvwxxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabets.length());
            char randomChar = alphabets.charAt(index);
            sb.append(randomChar);
        }

        setContext(RANDOMSTRING, sb.toString());
        return sb.toString();
    }

    public static String createRandomNumbers(int size) {
        Random random = new Random();
        long randomNumber = Math.abs(random.nextLong());
        String randomString = Long.toString(randomNumber);
        return randomString.substring(0, size);
    }

    //Assertions

    public static void assertTrueExpectedTextContainsActualText(String expectedText, String actualText) {
        assertTrue("\n\n ******** ERROR ******** \n" +
                "\n NOT THE EXPECTED RESULT!! " + "\n EXPECTED : " + expectedText +
                "\n ACTUAL : " + actualText, actualText.contains(expectedText));
    }

    public static void assertTrueExpectedTextEqualsActualText(String expectedText, String actualText) {
        assertTrue("\n\n ******** ERROR ******** \n" +
                "\n NOT THE EXPECTED RESULT!! " + "\n EXPECTED : " + expectedText +
                "\n ACTUAL : " + actualText, actualText.equals(expectedText));
    }

// Scrolls

    public static void scrollToElement(By by) {
        WebElement webElement = getDriver().findElement(by);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static void scrollDownByCoordinator(int y) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + y + ")", "");
    }

    public static void scrollUpByCoordinator(int y) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, -" + y + ")", "");
    }

    public static void scrollDownByCoordinatorInTable(String cssSelector) {
        ((JavascriptExecutor) getDriver()).executeScript("document.activeElement.querySelector(\"" + cssSelector + "\").scrollTop=document.activeElement.querySelector(\"" + cssSelector + "\").scrollHeight");
    }

    public static void scrollDownThePage() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public static void scrollUpThePage() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0,document.body.scrollHeight, 0);");
    }

    //Clicks

    public static void javaScriptExecutorClick(By by) {
        WebElement we = getDriver().findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click;", we);
    }

    public static void clickElement(WebElement we) {
        we.click();
    }

    public static void clickElementWithIndex(List<WebElement> we, int index) {
        we.get(index).click();
    }

    public static void clickByActions(By by) {
        WebElement we = getDriver().findElement(by);
        Actions builder = new Actions(getDriver());
        builder.moveToElement(we).click(we);
        builder.perform();
    }

    public static void doubleClickByActions(By by) {
        WebElement we = getDriver().findElement(by);
        Actions builder = new Actions(getDriver());
        builder.doubleClick(we).perform();
    }

    //Enter data

    public static void enterData(final WebElement we, String data) {
        we.sendKeys(data);
    }

    public static void enterDataLetterByLetter(final By by, final By by1, String data) {
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            String s = new StringBuilder().append(c).toString();
            try {
                getDriver().findElement(by1).sendKeys(s);
            } catch (Exception e) {
                getDriver().findElement(by).sendKeys(s);
            }
        }
    }

    //getText

    public static String getText(WebElement we) {
        return we.getText();
    }

    public static String getTextWithIndex(By by, int index) {
        return getDriver().findElements(by).get(index).getText();
    }

    public static String getAttribute(WebElement we, String key) {
        return we.getAttribute(key);
    }

    public static String getAttributeWithIndex(By by, String key, int index) {
        return getDriver().findElements(by).get(index).getAttribute(key);
    }

    //select dropdowns

    public static void selectByValue(By by, String value) {
        Select sc = new Select(getDriver().findElement(by));
        sc.selectByValue(value);
    }

    public static void selectByVisibleText(By by, String value) {
        Select sc = new Select(getDriver().findElement(by));
        sc.selectByVisibleText(value);
    }

    public static void selectByIndex(By by, int value) {
        Select sc = new Select(getDriver().findElement(by));
        sc.selectByIndex(value);
    }

    //Keyboard operations

    public static void clickEnter(WebElement we) {
        we.sendKeys(Keys.ENTER);
    }

    public static void clickDownArrowInKeyboard(By by) {
        getDriver().findElement(by).sendKeys(Keys.DOWN);
    }

    public static void clickUpArrowInKeyboard(By by) {
        getDriver().findElement(by).sendKeys(Keys.UP);
    }

    public static void clickTABInKeyboard(By by) {
        getDriver().findElement(by).sendKeys(Keys.TAB);
    }

    public static void clickDownArrowUsingActions() {
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.DOWN).perform();
    }

    public static void clickUpArrowUsingActions() {
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.UP).perform();
    }

    public static void clickEnterArrowUsingActions() {
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.ENTER).perform();
    }

    //mouse operations

    public static void moveToElement(By by) {
        WebElement we = getDriver().findElement(by);
        Actions builder = new Actions(getDriver());
        builder.moveToElement(we).perform();
    }
    //Waits

    public static void threadSleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }

    public static void waitForExpectedElement(By by) {
        webDriverWait.until(visibilityOfElementLocated(by));
    }

    public static void waitForPresenceOfElement(By by) {
        webDriverWait.until(presenceOfElementLocated(by));
    }

    public static void waitForExpectedElement(By by, long waitTimeInSeconds) {
        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTimeInSeconds));
        try {
            webDriverWait.until(visibilityOfElementLocated(by));
        } catch (Exception e) {

        }
    }

    //Date and time

    public static String getCurrentDate(String format) {
        Date currentDate = new Date();
        SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
        return simpleFormat.format(currentDate);
    }

    public static String addDaysToCurrentDate(int numberOfDasToBeAdded, String format) {
        return LocalDate.parse(getCurrentDate(format)).plusDays(numberOfDasToBeAdded).toString();
    }

    public static String convertDateToParticularFormat(String inputFormat, String outputFormat, String date) {
        SimpleDateFormat inputformat = new SimpleDateFormat(inputFormat);
        SimpleDateFormat outputformat = new SimpleDateFormat(outputFormat);
        Date date1;

        try {
            date1 = inputformat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return outputformat.format(date1);
    }

    //Encrypt and decrypt password

    public static String decryptPassword(String password) {
        byte[] decrypt = Base64.getDecoder().decode(password);
        return new String(decrypt);
    }

    public static String encryptPassword(String password) {
        byte[] encrypt = Base64.getEncoder().encode(password.getBytes());
        return new String(encrypt);
    }

    //Iframes

    public static void switchToFrameByXpath(By by) {
        WebElement iframe = getDriver().findElement(by);
        getDriver().switchTo().frame(iframe);
    }

    //Window Handle

    public static String storeMainWindow() {
        String mainWidow = getDriver().getWindowHandle();
        setContext(MAINWINDOW, mainWidow);
        return mainWidow;
    }

    public static void switchToNewWindow(int tabNumber) {
        ArrayList<String> tab = new ArrayList<>(getDriver().getWindowHandles());
        String tabName = tab.get(tabNumber);
        getDriver().switchTo().window(tabName);
    }

    public static void switchToMainWindow(String mainWindowHandle) {
        getDriver().switchTo().window(mainWindowHandle);
    }

    //Extra methods

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }

    public static void clearTextBox(By by) {
        getDriver().findElement(by).clear();
    }

    public static void resizeScreen(String size) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.body.style.zoom'" + size + "';");
    }

    public static String getProp(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public static void deleteRequiredFolder(String path) throws IOException {
        String filePath = System.getProperty("user.dir") + path;
        File file = new File(filePath);
        FileUtils.deleteDirectory(file);
        file.delete();
    }

    public static void longPressAction(WebElement ele) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
                        "duration", 2000));
    }

    public static void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        } while (canScrollMore);
    }

    public static void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

    public static void dragAndDropAction(WebElement source, int x, int y) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", x,
                "endY", y
        ));
    }

    public static void pressEnter() {
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public static void pressHome() {
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public static void pressBack() {
        ((AndroidDriver) getDriver()).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void landScape() {
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        ((AndroidDriver) getDriver()).rotate(landScape);
    }

    public static String getClipBoardData() {
        return ((AndroidDriver) getDriver()).getClipboardText();
    }

    public static void setClipBoardData(String text) {
        ((AndroidDriver) getDriver()).setClipboardText(text);
    }

    public static void startActivity(String activity) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: startActivity", ImmutableMap.of("intent", activity));
    }

    public static void hideKeyBoard() {
        ((AndroidDriver) getDriver()).hideKeyboard();
    }

    public static void scrollDownToParticularElement(String elementName) {
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementName + "\"));"));
    }

    public static Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public static Set getContextHandles() {
        return ((AndroidDriver) getDriver()).getContextHandles();
    }

    public static void navigateToContext(String context) {
        ((AndroidDriver) getDriver()).context(context);
    }

    public static JsonPath rawToJson(String response) {
        return new JsonPath(response);
    }

    public static void fluentWait() {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(driver -> getDriver().findElement(By.id("username")));
    }

    public static void navigateToChildWindows() {
        Set<String> windows = getDriver().getWindowHandles();
        Iterator it = windows.iterator();
        String window1 = it.next().toString();
        String window2 = it.next().toString();
        String window3 = it.next().toString();
        getDriver().switchTo().window(window2);
    }

    public static void deleteCookies() {
        getDriver().manage().deleteAllCookies();
    }
}