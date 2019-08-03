package utility;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

public class readConfigFile {
    String result = "";
    InputStream inputStream;

    public String getPropValue(String key) throws Exception {
        try {
            Properties prop = new Properties();
            String propFileName = "\\TestData\\config.properties";
            System.out.println(getClass());
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            result = prop.getProperty(key);
            System.out.println(result + "\nProgram Ran on " + time + " by user=" + result);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;

    }
}