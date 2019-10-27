package pers.lrf.weixinserver.common.utils;

import java.util.Random;

public class RandomUtils {

    /**
     * 生成手机验证码
     */
    public static String generateVerifyCode(int length) {
        if (length < 1 || length > 10) {
            length = 10;
        }
        Random ran = new Random();
        if (length == 1) {
            return String.valueOf(ran.nextInt(10));
        }
        int bitField = 0;
        char[] chs = new char[length];
        for (int i = 0; i < length; i++) {
            while (true) {
                int k = ran.nextInt(10);
                if ((bitField & (1 << k)) == 0) {
                    bitField |= 1 << k;
                    chs[i] = (char) (k + '0');
                    break;
                }
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        System.out.println(generateVerifyCode(6));
    }
}
