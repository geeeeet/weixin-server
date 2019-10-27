package pers.lrf.weixinserver.controller.weixinbase;

import org.springframework.web.bind.annotation.*;
import pers.lrf.weixinserver.common.interceptor.CheckUtil;
import pers.lrf.weixinserver.controller.BaseController;

/**
 * @author lirufeng
 * @date 2019/10/7 12:17
 **/
@RestController
@CrossOrigin
@RequestMapping("weixin")
public class WxBaseController extends BaseController {

    @RequestMapping()
    public String authorization(@RequestParam(value = "signature") String signature,
                       @RequestParam(value = "timestamp") String timestamp,
                       @RequestParam(value = "nonce") String nonce,
                       @RequestParam(value = "echostr") String echostr) {
        boolean b = CheckUtil.checkSignature(signature,timestamp,nonce);
        if(b) return echostr;
        return null;
    }

}
