package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.out;

public class Props {

    public static Properties environmentProps;
    public static Properties properties;
    public static String env;

    static {
        loadRunConfigProps("environmnt.properties");
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
            environmentProps.load(inputStream);
            environmentProps.list(out);
        } catch (IOException e) {
        }

        env = environmentProps.getProperty("env");
    }
}
