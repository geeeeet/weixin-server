package pers.lrf.weixinserver.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

/**
 * @author lirufeng
 * @date 2019/10/16 10:24
 **/
public class AccessTokenUtil {

    public static String accessToken;

    public static void getAccessToken(String url) {
        RestTemplate restTemplate = new RestTemplate();
        JSONObject accessToken0 = restTemplate.getForObject(url,JSONObject.class);
        accessToken = (String) accessToken0.get("access_token");
    }
}
