import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mm on 2020/10/18.
 */
public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Class<?>  clazz = new MyClassLoader().findClass("Hello");
            Method method = clazz.getDeclaredMethod("hello");
            method.invoke(clazz.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        String filePath = "Hello.xlass";
        byte[] bytes = getBytesFromFile(filePath);
        return defineClass(className, bytes, 0, bytes.length);
    }

    /**
     * 从文件中获取bytes
     * @param filePath
     * @return
     */
    private byte[] getBytesFromFile(String filePath) {
        InputStream in = null;
        byte[] bytes = null;
        try {
            in = MyClassLoader.class.getClassLoader().getResourceAsStream(filePath);
            bytes = new byte[in.available()];
            in.read(bytes);

            for (int i = 0; i < bytes.length; i ++) {
                bytes[i] = (byte)(255 - bytes[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }


}
