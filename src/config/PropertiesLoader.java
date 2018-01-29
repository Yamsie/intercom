package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private Properties prop;

    public PropertiesLoader() {
        prop = new Properties();
        setProperties();
    }
    private void setProperties() {
        InputStream input;

        try {
            input = new FileInputStream("config/config.properties");
            prop.load(input);
            input.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(String property) {
        return prop.getProperty(property);
    }
}
