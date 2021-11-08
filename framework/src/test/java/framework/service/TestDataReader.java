package framework.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle;

    public static void setEnvironment() {
        if (System.getProperty("environment") == null) {
            resourceBundle = ResourceBundle.getBundle("dev");
        } else {
            resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
        }
    }

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
