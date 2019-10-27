package pers.lrf.weixinserver.weixinbean.message;

import lombok.Data;

/**
 * 公共xml节点
 * @author lirufeng
 * @date 2019/10/16 12:08
 **/
@Data
public class BaseMessage {

    private String FromUserName;

    private String ToUserName;

    private Long CreateTime;

    private String MsgType;

    private Long MsgId;

}
