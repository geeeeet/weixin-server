package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.normal.BaseMessage;
import pers.lrf.weixinserver.weixinbean.message.normal.submessage.VideoMessage;

import java.io.Serializable;

/**
 * 视频消息
 * @author lirufeng
 * @date 2019/10/27 下午 6:09
 */
@Data
public class WxVideoMessage extends BaseMessage implements Serializable {

    private String MediaId;

    private String ThumbMediaId;

    private VideoMessage Video;


}
