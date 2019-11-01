package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.normal.BaseMessage;
import pers.lrf.weixinserver.weixinbean.message.normal.submessage.VoiceMessage;

/**
 * 语音消息
 *
 * @author lirufeng
 * @date 2019/10/27 下午 6:03
 */
@Data
public class WxVoiceMessage extends BaseMessage {

    private String MediaId;

    private String Format;

    private String Recognition;

    private VoiceMessage Voice;
}
