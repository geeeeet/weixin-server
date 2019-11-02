package pers.lrf.weixinserver.common.constant;

/**
 * 微信事件类型，该类所有所属消息类型是event
 * @author lirufeng
 * @date 2019/10/16 13:08
 **/
public class EventType {

    /**
     * 关注事件
     */
    public static final String SUBSCRIBE = "subscribe";
    /**
     * 取消关注事件
     */
    public static final String UNSUBSCRIBE = "unsubscribe";
    /**
     * 扫描带参数二维码事件（注意这里与关注事件一样，
     * 二维码还有EventKey辅助判断，EventKey事件KEY值，qrscene_为前缀，
     * 后面为二维码的参数值）
     */
    public static final String QRCODE = "subscribe";
    /**
     * 用户已关注时的事件推送，还需要EventKey事件KEY值，
     * 是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    public static final String SCAN = "SCAN";

    /**
     * 上报地理位置事件
     */
    public static final String LOCATION = "LOCATION";
    /**
     * 点击菜单拉取消息时的事件推送
     */
    public static final String CLICK = "CLICK";
    /**
     * 点击菜单跳转链接时的事件推送
     */
    public static final String VIEW = "VIEW";
    /**
     * scancode_push：扫码推事件的事件推送
     */
    public static final String SCANCODE_PUSH = "scancode_push";
    /**
     * scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件推送
     */
    public static final String SCANCODE_WAITMSG = "scancode_waitmsg";
    /**
     * pic_sysphoto：弹出系统拍照发图的事件推送
     */
    public static final String PIC_SYSPHOTO = "pic_sysphoto";
    /**
     * pic_photo_or_album：弹出拍照或者相册发图的事件推送
     */
    public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    /**
     * pic_weixin：弹出微信相册发图器的事件推送
     */
    public static final String PIC_WEIXIN = "pic_weixin";
    /**
     * location_select：弹出地理位置选择器的事件推送
     */
    public static final String LOCATION_SELECT = "location_select";
    /**
     * 点击菜单跳转小程序的事件推送
     */
    public static final String VIEW_MINIPROGRAM = "view_miniprogram";

}
