package pers.lrf.weixinserver.controller.responsetype;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.lrf.weixinserver.service.interfaces.IResponseMassage;

/**
 * @author lirufeng
 * @date 2019/10/15 14:06
 **/
@RestController
@CrossOrigin
@RequestMapping("weixin")
@Slf4j
public class ResponseMassageController {

    @Autowired
    private IResponseMassage iResponseMassage;

    @PostMapping()
    public String responseMessage(@RequestBody String message) {
        String rmessage = null;
        try {
            rmessage = iResponseMassage.handleMassage(message);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("微信服务器出错",e);
        }
        return rmessage;
    }
}
