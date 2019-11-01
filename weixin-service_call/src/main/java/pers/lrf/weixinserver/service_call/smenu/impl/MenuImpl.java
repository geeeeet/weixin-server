package pers.lrf.weixinserver.service_call.smenu.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pers.lrf.weixinserver.common.exception.WxException;
import pers.lrf.weixinserver.service_call.smenu.interfaces.IMenu;

/**
 * @author lirufeng
 * @date 2019/10/18 12:36
 **/
@Service
public class MenuImpl implements IMenu {
    @Override
    public void crateMenu(String url, String data) throws WxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("application/json;charset=utf-8"));
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(data,headers);
        ResponseEntity<JSONObject> re = restTemplate.postForEntity(url,httpEntity,JSONObject.class);
        JSONObject o = (JSONObject) JSONObject.toJSON(re.getBody());
        if(!"0".equals(o.getString("errcode"))){
            throw new WxException(re.getBody().toJSONString());
        }
    }

    @Override
    public String getMenu(String url) throws WxException {
        RestTemplate restTemplate = new RestTemplate();
        JSONObject menu = restTemplate.getForObject(url,JSONObject.class);
        return menu.toJSONString();
    }

    @Override
    public Boolean deleteMenu(String url) throws WxException {
        boolean result = false;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject menu = restTemplate.getForObject(url,JSONObject.class);
        if(!"0".equals(menu.getString("errcode"))){
            throw new WxException(menu.toJSONString());
        }
        return result;
    }
}
