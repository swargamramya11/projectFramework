package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Utilities.BrowserDriver.*;
import static Utilities.GlobalVariables.ScenarioContext.*;
import static Utilities.GlobalVariables.Context.*;
import static Utilities.Props.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.AssertJUnit.assertTrue;

public class ReusableMethods {

    //Screenshots

    public static byte[] takesScreenshotAsByte() {
        byte[] screenshot = ((TakesScreenshot) BrowserDriver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static File takesScreenshotAsFile() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
        WebElement webElement = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static void scrollDownByCoordinator(int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ")", "");
    }

    public static void scrollUpByCoordinator(int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -" + y + ")", "");
    }

    public static void scrollDownByCoordinatorInTable(String cssSelector) {
        ((JavascriptExecutor) driver).executeScript("document.activeElement.querySelector(\"" + cssSelector + "\").scrollTop=document.activeElement.querySelector(\"" + cssSelector + "\").scrollHeight");
    }

    public static void scrollDownThePage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");
    }

    public static void scrollUpThePage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight, 0);");
    }

    //Clicks

    public static void javaScriptExecutorClick(By by) {
        WebElement we = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click;", we);
    }

    public static void clickElement(By by) {
        driver.findElement(by).click();
    }

    public static void clickElementWithIndex(By by, int index) {
        driver.findElements(by).get(index).click();
    }

    public static void clickByActions(By by) {
        WebElement we = driver.findElement(by);
        Actions builder = new Actions(driver);
        builder.moveToElement(we).click(we);
        builder.perform();
    }

    public static void doubleClickByActions(By by) {
        WebElement we = driver.findElement(by);
        Actions builder = new Actions(driver);
        builder.doubleClick(we).perform();
    }

    //Enter data

    public static void enter(final By by, String data) {
        driver.findElement(by).sendKeys(data);
    }

    public static void enterDataLetterByLetter(final By by, final By by1, String data) {
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            String s = new StringBuilder().append(c).toString();
            try {
                driver.findElement(by1).sendKeys(s);
            } catch (Exception e) {
                driver.findElement(by).sendKeys(s);
            }
        }
    }

    //getText

    public static String getText(By by) {
        return driver.findElement(by).getText();
    }

    public static String getTextWithIndex(By by, int index) {
        return driver.findElements(by).get(index).getText();
    }

    public static String getAttribute(By by, String key) {
        return driver.findElement(by).getAttribute(key);
    }

    public static String getAttributeWithIndex(By by, String key, int index) {
        return driver.findElements(by).get(index).getAttribute(key);
    }

    //select dropdowns

    public static void selectByValue(By by, String value) {
        Select sc = new Select(driver.findElement(by));
        sc.selectByValue(value);
    }

    public static void selectByVisibleText(By by, String value) {
        Select sc = new Select(driver.findElement(by));
        sc.selectByVisibleText(value);
    }

    public static void selectByIndex(By by, int value) {
        Select sc = new Select(driver.findElement(by));
        sc.selectByIndex(value);
    }

    //Keyboard operations

    public static void clickEnter(By by) {
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public static void clickDownArrowInKeyboard(By by) {
        driver.findElement(by).sendKeys(Keys.DOWN);
    }

    public static void clickUpArrowInKeyboard(By by) {
        driver.findElement(by).sendKeys(Keys.UP);
    }

    public static void clickTABInKeyboard(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
    }

    public static void clickDownArrowUsingActions() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.DOWN).perform();
    }

    public static void clickUpArrowUsingActions() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.UP).perform();
    }

    public static void clickEnterArrowUsingActions() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ENTER).perform();
    }

    //mouse operations

    public static void moveToElement(By by) {
        WebElement we = driver.findElement(by);
        Actions builder = new Actions(driver);
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
        WebDriverWait wait1 = new WebDriverWait(getWebDriver(), Duration.ofSeconds(waitTimeInSeconds));
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
        WebElement iframe = driver.findElement(by);
        driver.switchTo().frame(iframe);
    }

    //Window Handle

    public static String storeMainWindow() {
        String mainWidow = driver.getWindowHandle();
        setContext(MAINWINDOW, mainWidow);
        return mainWidow;
    }

    public static void switchToNewWindow(int tabNumber) {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        String tabName = tab.get(tabNumber);
        driver.switchTo().window(tabName);
    }

    public static void switchToMainWindow(String mainWindowHandle) {
        driver.switchTo().window(mainWindowHandle);
    }

    //Extra methods

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void clearTextBox(By by) {
        driver.findElement(by).clear();
    }

    public static void resizeScreen(String size) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom'" + size + "';");
    }

    public static String getProp(String propertyName) {
        return environmentProps.getProperty(propertyName);
    }

    public static void deleteRequiredFolder(String path) throws IOException {
        String filePath = System.getProperty("user.dir") + path;
        File file = new File(filePath);
        FileUtils.deleteDirectory(file);
        file.delete();
    }
}