package Utilities;

import java.io.*;
import java.util.Properties;

import static java.lang.System.out;

public class Props {

    public static Properties environmentProps;
    public static Properties properties;
    public static String env;
    public static String deviceType;
    public static String apkPath;
    public static String testingType;

    static {
        loadRunConfigProps("/environment.properties");
    }

    public static void loadRunConfigProps(String configPropertyFileLocation) {
        environmentProps = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream(configPropertyFileLocation)) {
            environmentProps.load(inputStream);
            environmentProps.list(out);
        } catch (IOException e) {
        }

        properties = new Properties();
        try (InputStream inputStream = Props.class.getResourceAsStream(environmentProps.getProperty("properties.path"))) {
            properties.load(inputStream);
            properties.list(out);
        } catch (IOException e) {
        }

        env = environmentProps.getProperty("env");
        deviceType = environmentProps.getProperty("deviceType");
        apkPath = System.getProperty("user.dir") + "\\src\\test\\resources\\apkFiles\\" + environmentProps.getProperty("apk.path");
        testingType = environmentProps.getProperty("testingType");
    }
}