package pers.lrf.weixinserver.weixinbean.message.eventmessage;

import lombok.Data;

import java.io.Serializable;

/**
 * 事件公共父类
 * @author lirufeng
 * @date 2019/11/02 上午 11:11
 */
@Data
public class EventBaseMessage {

    /**
     * 开发者微信号
     */
    private String ToUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    private Long CreateTime;

    /**
     * 消息类型，event
     */
    private String MsgType;

    /**
     * 事件类型
     */
    private String Event;
}
