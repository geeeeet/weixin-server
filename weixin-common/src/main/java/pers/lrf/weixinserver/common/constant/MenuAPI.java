package pers.lrf.weixinserver.common.constant;

/**
 * 菜单操作的各种API，使用时只需将ACCESS_TOKEN替换成请求到的token即可
 * @author lirufeng
 * @date 2019/10/17 17:28
 **/
public class MenuAPI {

    /**
     * 菜单创建接口，http请求方式：POST（请使用https协议）
     */
    public static final String CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 菜单查询接口,http请求方式: GET（请使用https协议）
     */
    public static final String GET_MENU = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
    /**
     * 菜单删除接口,http请求方式: GET（请使用https协议），包括删除个性化菜单（一起删除）
     */
    public static final String DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    /**
     * 创建个性化菜单接口,http请求方式：POST（请使用https协议）
     */
    public static final String CREATE_INDIVIDUALIZATION_MENU = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
    /**
     * 删除个性化菜单,http请求方式：POST（请使用https协议）
     */
    public static final String DELETE_INDIVIDUALIZATION_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
    /**
     * 测试个性化菜单匹配结果,http请求方式：POST（请使用https协议）
     */
    public static final String RESULT_INDIVIDUALIZATION_MENU = "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";
    /**
     * 使用接口创建自定义菜单后，开发者还可使用接口查询自定义菜单的结构。
     * 另外请注意，在设置了个性化菜单后，使用本自定义菜单查询接口可以获取默认菜单和全部个性化菜单信息。
     * http请求方式：GET
     */
    public static final String GET_ALL_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
}
