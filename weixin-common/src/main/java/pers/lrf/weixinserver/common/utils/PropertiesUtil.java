package pers.lrf.weixinserver.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Properties;

/**
 * Created by admin on 2016/10/11.
 */
@Slf4j
public class PropertiesUtil {
    /**
     * 加载配置文件
     * @param properties
     * @param filePath
     */
    public static void reLoad(Properties properties, String filePath) {
        log.debug("加载配置文件:" + filePath);
        try {
            InputStream inputStream = new FileInputStream(filePath);
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
                properties.load(bf);
            } catch (IOException e) {
                log.error("加载配置文件出现IO异常!", e);
            }
        } catch (FileNotFoundException e) {
            log.error("读取配置信息出错!", e);
        }
    }

    /**
     * 获取配置文件路径
     * @param fileName
     * @return
     */
    public static String getFilePath(String fileName) {
        String path = Thread.currentThread().getContextClassLoader().getResource(fileName).getPath();
        return path;
    }

    /**
     * 通过配置文件中的key获取值（value）
     * 读取jar包外面的config文件夹的*.properties文件，即config文件夹
     * 在工程目录下，打包时，不会将该文件夹一起打包，需要自己在jar文加同级
     * 目录下条件该目录及里面的文件
     * @param fileName  文件名
     * @param key       配置文件中的key
     * @return          返回key对应的value
     */
    public static String getValueByKey(String fileName, String key) {
        String value = null;
        try {
            Properties properties = new Properties();
            String path = getFilePath(fileName);
            reLoad(properties,path);
            value = properties.getProperty(key);
        } catch (Exception e) {
            log.error("属性获取方法发生错误!",e);
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtil.getValueByKey("config.properties","appid"));
    }

}
