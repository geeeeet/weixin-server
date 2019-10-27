package pers.lrf.weixinserver.service_call.smenu.interfaces;

import pers.lrf.weixinserver.common.exception.WxException;

/**
 * @author lirufeng
 * @date 2019/10/18 12:36
 **/
public interface IMenu {

    /**
     * 创建菜单
     * @param url            api地址
     * @param data           定义菜单数据
     * @throws WxException   抛出自定义异常
     */
    void crateMenu(String url,String data) throws WxException;

    /**
     * 获取菜单数据
     * @param url             api地址
     * @return                菜单数据字符串
     * @throws WxException    抛出自定义菜单
     */
    String getMenu(String url) throws WxException;

    /**
     * 删除菜单
     * @param url              api地址
     * @throws WxException     抛出自定义菜单
     */
    void deleteMenu(String url) throws WxException;
}
