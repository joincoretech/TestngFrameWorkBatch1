package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties prop;

    public static Properties readProperties(String filePath){
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            prop=new Properties();
            prop.load(fileInputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
       return prop;
    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}
