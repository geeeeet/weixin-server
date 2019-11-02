package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.normal.submessage.MusicMessage;

import java.io.Serializable;

/**
 * 音乐消息
 * @author lirufeng
 * @date 2019/11/01 下午 11:26
 */
@Data
public class WxMusicMessage extends BaseMessage implements Serializable {

    private String ToUserName;

    private String FromUserName;

    private Long CreateTime;

    private String MsgType;

    private MusicMessage Music;


}
