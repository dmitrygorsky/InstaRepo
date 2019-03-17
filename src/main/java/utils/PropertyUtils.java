package utils;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {

    private static Properties property = new Properties();

    public static String getProperties(String key, String source) {
        try {
            FileInputStream fis = new FileInputStream(source);
            property.load(fis);
        } catch (IOException e) {
            System.err.println("No such file");
        }
        return property.getProperty(key);
    }
}
