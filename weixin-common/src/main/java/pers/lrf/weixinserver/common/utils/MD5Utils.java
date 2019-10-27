package pers.lrf.weixinserver.common.utils;

import java.security.MessageDigest;

public class MD5Utils {
    /**
     * MD5加密(32位)
     *
     * @param instr 要加密的字符串
     * @return 返回加密后的字符串
     */
    private final static String encoderByMd5With32Bit(String instr, String charset) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            if (instr != null && !"".equals(instr)) {
                byte[] strTemp = instr.getBytes();
                if (charset != null) {
                    strTemp = instr.getBytes(charset);
                }
                // MD5计算方法
                MessageDigest mdTemp = MessageDigest.getInstance("MD5");
                mdTemp.update(strTemp);
                byte[] md = mdTemp.digest();
                int j = md.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = md[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    str[k++] = hexDigits[byte0 & 0xf];
                }
                return new String(str);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * MD5加密(32位)
     *
     * @param instr 要加密的字符串
     * @return 返回加密后的字符串
     */
    public final static String encoderByMd5With32Bit(String instr) {
        return encoderByMd5With32Bit(instr, "UTF-8") + instr;
    }

    public static void main(String[] args) {
//		System.out.println(encoderByMd5With32Bit("zhs2018"));
        System.out.println(encoderByMd5With32Bit("zhs2019"));
    }
}
