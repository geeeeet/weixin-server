package pers.lrf.weixinserver.common.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class DESEncrypt {

    private static final byte[] DESkey = "95245053".getBytes();// 设置密钥，略去

    private static final byte[] DESIV = "59246315".getBytes();// 设置向量，略去

    // 加密算法的参数接口，IvParameterSpec是它的一个实现

    static AlgorithmParameterSpec iv = null;

    private static Key key = null;

    public DESEncrypt() {

        this(DESkey, DESIV);

    }

    public DESEncrypt(String DESkey, String DESIV) {

        this(DESkey.getBytes(), DESIV.getBytes());

    }

    private DESEncrypt(byte[] DESkey, byte[] DESIV) {
        try {
            // 设置密钥参数

            DESKeySpec keySpec = new DESKeySpec(DESkey);

            // 设置向量

            iv = new IvParameterSpec(DESIV);

            // 获得密钥工厂

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

            key = keyFactory.generateSecret(keySpec);// 得到密钥对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param data
     * @return
     * @throws 加密
     */

    public String encode(String data) {
        try {
            // 得到加密对象Cipher

            Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

            // 设置工作模式为加密模式，给出密钥和向量

            enCipher.init(Cipher.ENCRYPT_MODE, key, iv);

            byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));

            return Base64.encodeBase64String(pasByte).replaceAll("\\+", "_")
                    .replaceAll("\\/", "@");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @param data
     * @return
     * @throws 解密
     */

    public String decode(String data) throws Exception {

        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        deCipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] pasByte = deCipher.doFinal(Base64.decodeBase64(data.replaceAll(
                "_", "+").replaceAll("@", "/")));

        return new String(pasByte, "UTF-8");

    }

    public static void main(String[] args) throws Exception {

        DESEncrypt tools = new DESEncrypt();

        System.out
                .println("加密:"
                        + tools.encode("http://file.zhihuishu.com/zhs_yufa_150820/myuni/studentScore/201803/ba1c03d1bbe44a2aa76516c296e38d68.xlsx"));

        System.out
                .println("解密:"
                        + tools.decode(tools
                        .encode("http://file.zhihuishu.com/zhs_yufa_150820/myuni/studentScore/201803/ba1c03d1bbe44a2aa76516c296e38d68.xlsx")));

    }

}