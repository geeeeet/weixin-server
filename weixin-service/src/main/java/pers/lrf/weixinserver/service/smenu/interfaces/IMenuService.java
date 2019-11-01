package pers.lrf.weixinserver.service.smenu.interfaces;

import pers.lrf.weixinserver.common.exception.WxException;

/**
 * @author lirufeng
 * @date 2019/10/18 13:49
 **/
public interface IMenuService {

    /**
     * 创建菜单
     */
    void crateMenu();

    /**
     * 获取菜单数据
     * @return                菜单数据字符串
     * @throws WxException    抛出自定义菜单
     */
    String getMenu() throws WxException;

    /**
     * 删除菜单
     * @throws WxException     抛出自定义菜单
     */
    Boolean deleteMenu() throws WxException;
}
