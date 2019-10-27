package pers.lrf.weixinserver.weixinbean.message;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.submessage.VoiceMessage;

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
