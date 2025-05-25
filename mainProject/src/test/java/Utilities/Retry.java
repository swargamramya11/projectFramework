package Utilities;

import org.testng.*;

public class Retry implements IRetryAnalyzer {
    int maxTry = 0;
    int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                return true;
            }
        }
        return false;
    }
}