package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.normal.submessage.NewsMessage;

import java.io.Serializable;

/**
 * 图文消息
 * @author lirufeng
 * @date 2019/11/01 下午 11:33
 */
@Data
public class WxNewsMessage extends BaseMessage implements Serializable {

    private String ToUserName;

    private String FromUserName;

    private Long CreateTime;

    private String MsgType;

    private Integer ArticleCount;

    private NewsMessage Articles;
}
