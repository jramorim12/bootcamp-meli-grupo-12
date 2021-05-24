package sorter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MyFactory {

    public Object getInstance(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String filePath = "./src/resources/MyFactory.properties";
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(filePath)){
            properties.load(is);
        } catch (IOException e) {
            System.out.println(e);
        }

        return Class.forName(properties.getProperty(className)).getConstructor().newInstance();
    }


}
