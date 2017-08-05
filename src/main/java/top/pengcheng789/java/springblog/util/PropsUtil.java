package top.pengcheng789.java.springblog.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pen on 17-7-2.
 */
public final class PropsUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String filename){
        Properties properties = null;
        InputStream inputStream = null;

        try{
            inputStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(filename);
            if (inputStream == null){
                LOGGER.error(filename + " file is not found.");
                throw new FileNotFoundException(filename + " file is not found.");
            }

            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e){
            LOGGER.error("load props failure", e);
            throw new RuntimeException(e);
        } finally {
            try{
                inputStream.close();
            } catch (IOException e){
                LOGGER.error("close input stream failure", e);
                throw new RuntimeException(e);
            }
        }

        return properties;
    }

    public static String getString(Properties properties, String key){
        return getString(properties, key, "");
    }

    public static String getString(Properties properties, String key, String defaultValue){
        String value = defaultValue;
        if(properties.containsKey(key)){
            value = properties.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties properties, String key){
        return getInt(properties, key, 0);
    }

    public static int getInt(Properties properties, String key, int defaultValue){
        int value = defaultValue;
        if(properties.containsKey(key)){
            value = CastUtil.castInt(properties.getProperty(key));
        }

        return value;
    }

    public static boolean isTrue(Properties properties, String key){
        return isTrue(properties, key, false);
    }

    public static boolean isTrue(Properties properties, String key, boolean defaultValue){
        boolean value = defaultValue;
        if(properties.containsKey(key)){
            value = CastUtil.castBoolean(properties.getProperty(key));
        }

        return value;
    }

    /**
     * 获取 boolean 类型属性（默认值为 false）
     */
    public static boolean getBoolean(Properties props, String key) {
        return getBoolean(props, key, false);
    }

    /**
     * 获取 boolean 类型属性（可指定默认值）
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)) {
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
