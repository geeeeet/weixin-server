package pers.lrf.weixinserver.controller.wxmenu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lrf.weixinserver.common.exception.WxException;
import pers.lrf.weixinserver.controller.BaseController;
import pers.lrf.weixinserver.service.smenu.interfaces.IMenuService;

/**
 * @author lirufeng
 * @date 2019/10/16 11:34
 **/
@RestController
@CrossOrigin
@RequestMapping("weixin/menu")
@Slf4j
public class WxMenuController extends BaseController {

    @Autowired
    private IMenuService iMenuService;

    @RequestMapping("create")
    public void createMenu() {
        iMenuService.crateMenu();
    }

    @RequestMapping("getMenu")
    public String getMenu() {
        String result = null;
        try {
            result = iMenuService.getMenu();
        } catch (WxException e) {
            e.printStackTrace();
            log.error("");
        }
        return result;
    }

    @RequestMapping("deleteMenu")
    public Boolean deleteMenu(){
        Boolean result = false;
        try {
            result = iMenuService.deleteMenu();
        } catch (WxException e) {
            e.printStackTrace();
            log.error("");
        }
        return result;
    }

}
