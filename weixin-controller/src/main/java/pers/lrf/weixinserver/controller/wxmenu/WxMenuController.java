package pers.lrf.weixinserver.controller.wxmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lrf.weixinserver.controller.BaseController;
import pers.lrf.weixinserver.service.smenu.interfaces.IMenuService;

/**
 * @author lirufeng
 * @date 2019/10/16 11:34
 **/
@RestController
@CrossOrigin
@RequestMapping("weixin/menu")
public class WxMenuController extends BaseController {

    @Autowired
    private IMenuService iMenuService;

    @RequestMapping("create")
    public void createMenu() {
        iMenuService.crateMenu();
    }
}
