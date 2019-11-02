package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;

import java.io.Serializable;

/**
 * 文本消息
 * @author lirufeng
 * @date 2019/10/15 17:44
 **/
@Data
public class WxTextMessage extends BaseMessage implements Serializable {

    private String Content;

    private Long MsgId;
}
