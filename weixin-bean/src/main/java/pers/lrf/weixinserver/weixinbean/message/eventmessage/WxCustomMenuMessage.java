package pers.lrf.weixinserver.weixinbean.message.eventmessage;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义菜单事件,
 * @author lirufeng
 * @date 2019/11/02 上午 11:35
 */
@Data
public class WxCustomMenuMessage extends EventBaseMessage implements Serializable {

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    private String EventKey;
}
