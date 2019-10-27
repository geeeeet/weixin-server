package pers.lrf.weixinserver.controller.weixintest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lrf.weixinserver.controller.BaseController;
import pers.lrf.weixinserver.service.interfaces.IExample;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lirufeng
 * @date 2019/10/16 9:26
 **/
@RestController
@CrossOrigin
@RequestMapping("example")
public class ExampleController extends BaseController {

    @Autowired
    private IExample iExample;

    @RequestMapping("test")
    public Object test() {
        ResultJson resultJson = new ResultJson<>();
        resultJson.setMsg("查询成功！");
        Map<String,String> map = new HashMap<>();
        map.put("name",iExample.getAuthorName());

        resultJson.setRt(map);
        return resultJson;
    }
}