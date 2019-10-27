package pers.lrf.weixinserver.weixinbean.message;

import lombok.Data;

/**
 * 文本消息
 * @author lirufeng
 * @date 2019/10/15 17:44
 **/
@Data
public class WxTextMessage extends BaseMessage {

    private String Content;

    private Long MsgId;
}
