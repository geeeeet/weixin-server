package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;

import java.io.Serializable;

/**
 * 短视频消息
 * @author lirufeng
 * @date 2019/11/01 下午 11:12
 */
@Data
public class WxShortVideoMessage extends BaseMessage implements Serializable {

    private String MediaId;

    private String ThumbMediaId;

}
