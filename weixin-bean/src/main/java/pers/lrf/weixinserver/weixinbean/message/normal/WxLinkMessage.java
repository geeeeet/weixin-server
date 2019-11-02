package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;

import java.io.Serializable;

/**
 * 连接消息
 * @author lirufeng
 * @date 2019/11/01 下午 11:23
 */
@Data
public class WxLinkMessage extends BaseMessage implements Serializable {

    private String Title;

    private String Description;

    private String Url;
}
