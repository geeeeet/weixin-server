package pers.lrf.weixinserver.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;

/**
 * Created by admin on 2016/10/9.
 */
@Slf4j
public class StringUtil {

    public static boolean isEmpty(String str) {
        if (null == str || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(@SuppressWarnings("rawtypes") List str) {
        if (null == str || str.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Integer str) {
        return str == null;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNum(String str) {
        return (str + "").trim().matches("\\d+");
    }


    public static boolean isMobile(String str) {
        if (isNum(str)) {
            if (str.trim().length() == 11) {
                return true;
            }
        }
        return false;
    }

    /**
     * 文件名拼接规则
     *
     * @param name
     * @return
     */
    public static String genarateFileName(String name, String postfix) {
        String random_str = TimeUtil.getCurrentDate("yyyyMMddHHmmss");
        return name.concat("_").concat(random_str).concat(postfix);
    }

    /**
     * 获取桩文件全路径
     *
     * @param stubFileName
     * @return
     */
    private static String getStubFilePath(String stubFileName) {
        return Thread.currentThread().getContextClassLoader().getResource("stub/".concat(stubFileName)).getPath();
    }

    /**
     * 从桩文件读取返回
     *
     * @param stubFileName
     * @return
     */
    public static String getResponseFromStub(String stubFileName) {
        String filePath = getStubFilePath(stubFileName);
        File file = new File(filePath);
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        String str = null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(isr);
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            reader.close();
            log.debug(">>>>>>>>>>>>读取桩文件成功：" + filePath);
        } catch (IOException e) {
            log.error(">>>>>>>>>>>>读取桩文件失败：" + filePath);
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("关闭IO流失败", e);
                }
            }
        }
        return sb.toString();
    }
}
