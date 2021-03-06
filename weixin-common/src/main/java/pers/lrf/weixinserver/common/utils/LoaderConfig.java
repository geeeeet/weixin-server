package pers.lrf.weixinserver.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @author admin
 */
@Slf4j
public class LoaderConfig {

    private static final String fileName = "system.properties";
    private static Properties properties = new Properties();

    static {
        PropertiesUtil.reLoad(properties, PropertiesUtil.getFilePath(fileName));
    }

    /**
     * @param preKey
     * @return
     */
    public static String getObject(String preKey) {
        if (properties.containsKey(preKey)) {
            return properties.get(preKey).toString();
        } else {
            log.error("{} not exists in properties", preKey);
        }
        return null;
    }

    /**
     * @param preKey
     * @param defaultValue
     * @return
     */
    public static String getObjectStr(String preKey, String defaultValue) {
        if (!properties.containsKey(preKey) || StringUtil.isEmpty(properties.get(preKey).toString())) {
            return defaultValue;
        }
        return properties.get(preKey).toString();
    }

    /**
     * @param preKey
     * @param defaultValue
     * @return
     */
    public static int getObjectInt(String preKey, int defaultValue) {
        if (!properties.containsKey(preKey) || StringUtil.isEmpty(properties.get(preKey).toString())) {
            return defaultValue;
        }
        return Integer.valueOf(properties.get(preKey).toString());
    }
}
