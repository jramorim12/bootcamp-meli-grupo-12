import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MyFactory{
        public static Object getInstance (String objName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            Properties properties = new Properties();

                try{
                    properties.load(new FileInputStream("./src/MyFactory.properties"));
                }catch (IOException e){
                    System.out.println(e.getStackTrace());
                }

            return (Sorter) Class.forName(properties.get(objName).toString()).getConstructor().newInstance();

        }
}
