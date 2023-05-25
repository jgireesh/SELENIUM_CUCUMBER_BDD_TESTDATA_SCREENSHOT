package com.cucumber.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
public class ConfigUtils {
    private static Properties prop = null;
    public static String TargetWebEndPoint;

    public static Properties getProjectProperties() {
        if (prop == null) {
            try {
                String res = (new File("")).getAbsolutePath() + File.separatorChar + "src" + File.separatorChar + "test" + File.separatorChar + "resources" + File.separatorChar + "/test.properties";
                InputStream input = new FileInputStream(res);
                prop = new Properties();
                prop.load(input);
            } catch (Exception var2) {
                var2.printStackTrace();
            }
        }

        return prop;
    }

    public static String getASpecificProperty(String property) {
        String specifiedProperty = null;

        try {
            Properties prop = getProjectProperties();
            specifiedProperty = prop.getProperty(property);
        } catch (Exception var3) {
            specifiedProperty = null;
        }

        return specifiedProperty;
    }

    public static String getWebEndPoint() {
        if (TargetWebEndPoint == null) {
            try {
                Properties prop = getProjectProperties();
                TargetWebEndPoint = prop.getProperty("env.url");
            } catch (Exception var1) {
                var1.printStackTrace();
            }
        }

        return TargetWebEndPoint;
    }
}
