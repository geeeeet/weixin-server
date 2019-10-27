package pers.lrf.weixinserver.controller.weixinbase;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lrf.weixinserver.common.constant.WxConstant;
import pers.lrf.weixinserver.common.utils.AccessTokenUtil;
import pers.lrf.weixinserver.common.utils.PropertiesUtil;
import pers.lrf.weixinserver.controller.BaseController;

/**
 * @author lirufeng
 * @date 2019/10/16 11:36
 **/
@RestController
@CrossOrigin
@RequestMapping("weixin/token")
public class WxAccessTokenController extends BaseController {

    @RequestMapping()
    public void getAccessToken(){
        String fileName = "config.properties";
        String appid = PropertiesUtil.getValueByKey(fileName,"appid");
        String secret = PropertiesUtil.getValueByKey(fileName,"secret");
        String token = WxConstant.tokenUrl.replace("APPID",appid).replace("APPSECRET",secret);
        AccessTokenUtil.getAccessToken(token);
    }
}