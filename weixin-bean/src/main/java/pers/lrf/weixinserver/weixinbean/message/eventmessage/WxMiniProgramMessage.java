package pers.lrf.weixinserver.weixinbean.message.eventmessage;

import lombok.Data;

import java.io.Serializable;

/**
 * 点击菜单跳转小程序的事件推送,Event值为：view_miniprogram
 * @author lirufeng
 * @date 2019/11/02 下午 12:02
 */
@Data
public class WxMiniProgramMessage extends EventBaseMessage implements Serializable {

    /**
     * 事件KEY值，跳转的小程序路径
     */
    private String EventKey;

    /**
     * 菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
     */
    private String MenuId;
}
