package pers.lrf.weixinserver.service.smenu.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.common.constant.EventType;
import pers.lrf.weixinserver.common.constant.MenuAPI;
import pers.lrf.weixinserver.common.exception.WxException;
import pers.lrf.weixinserver.common.utils.AccessTokenUtil;
import pers.lrf.weixinserver.service.smenu.interfaces.IMenuService;
import pers.lrf.weixinserver.service_call.smenu.interfaces.IMenu;
import pers.lrf.weixinserver.weixinbean.menu.BaseButton;
import pers.lrf.weixinserver.weixinbean.menu.SubButton;

/**
 * @author lirufeng
 * @date 2019/10/18 13:50
 **/
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private IMenu iMenu;

    @Override
    public void crateMenu() {
        String token = AccessTokenUtil.accessToken;
        String url = MenuAPI.CREATE_MENU.replace("ACCESS_TOKEN",token);

        BaseButton baseButton = new BaseButton();
        SubButton subButton0 = new SubButton();
        subButton0.setName("菜单0");
        SubButton subButton01 = new SubButton();
        subButton01.setType(EventType.CLICK);
        subButton01.setKey("10");
        subButton01.setName("问候");
        SubButton subButton02 = new SubButton();
        subButton02.setType(EventType.VIEW);
        subButton02.setKey("11");
        subButton02.setName("图片");
        subButton02.setUrl("E:\\IWorkSpace\\IdeaWorkSpace\\weixin-server\\image\\test.PNG");
        SubButton subButton03 = new SubButton();
        subButton03.setType(EventType.SCAN);
        subButton03.setKey("12");
        subButton03.setName("扫描");
        subButton0.getSub_button().add(subButton01);
        subButton0.getSub_button().add(subButton02);
        subButton0.getSub_button().add(subButton03);

        SubButton subButton1 = new SubButton();
        subButton1.setKey("2");
        subButton1.setName("菜单1");
        subButton1.setType("click");

        SubButton subButton2 = new SubButton();
        subButton2.setKey("3");
        subButton2.setName("菜单2");
        subButton2.setType("click");

        baseButton.getButton().add(subButton0);
        baseButton.getButton().add(subButton1);
        baseButton.getButton().add(subButton2);
        JSONObject o = (JSONObject) JSONObject.toJSON(baseButton);
        System.out.println(o);

        try {
            iMenu.crateMenu(url,o.toJSONString());
        } catch (WxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMenu() throws WxException {
        return null;
    }

    @Override
    public void deleteMenu() throws WxException {

    }
}
