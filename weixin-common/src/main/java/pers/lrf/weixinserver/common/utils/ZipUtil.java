package pers.lrf.weixinserver.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 *
 */
public class ZipUtil {
    private ZipOutputStream zip;

    public ZipUtil(OutputStream out) {
        zip = new ZipOutputStream(out);
        //zip.setLevel(level);
    }


    public void addUrlFileToZip(String url, String fileName) {
        try {
            zip.putNextEntry(new ZipEntry(fileName));
            downUrl(url, zip);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zip.flush();
                zip.closeEntry();
                zip.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            zip.finish();
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 从网络Url中获取流字节写到OUT
     *
     * @param out
     * @throws IOException
     */
    public static void downUrl(String url, OutputStream out) throws IOException {
        if (url == null || url == "") {
            return;
        }
        try {/*内网*/
            URL U = new URL("https:www.xxx.com");
            HttpURLConnection conn = (HttpURLConnection) U.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(5 * 1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //得到输入流  （文件不存在 这里会 异常）
            InputStream in = conn.getInputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            try {/*公网*/
                URL U = new URL("https:www.xxx.com");
                HttpURLConnection conn = (HttpURLConnection) U.openConnection();
                //设置超时间为3秒
                conn.setConnectTimeout(5 * 1000);
                //防止屏蔽程序抓取而返回403错误
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                //得到输入流  （文件不存在 这里会 异常）
                InputStream in = conn.getInputStream();
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
                in.close();
                conn.disconnect();
            } catch (Exception ee) {
                ee.printStackTrace();
                try {/*校内网*/
                    URL U = new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) U.openConnection();
                    //设置超时间为3秒
                    conn.setConnectTimeout(5 * 1000);
                    //防止屏蔽程序抓取而返回403错误
                    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
                    //得到输入流  （文件不存在 这里会 异常）
                    InputStream in = conn.getInputStream();
                    int len = 0;
                    byte[] buffer = new byte[1024];
                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    conn.disconnect();
                } catch (Exception eee) {
                    eee.printStackTrace();
                }
            }
        }
    }


}
