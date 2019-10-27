package pers.lrf.weixinserver.service.textmessage.voice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.service.textmessage.voice.interfaces.IVoiceMessage;

/**
 * @author lirufeng
 * @date 2019/10/27 下午 1:55
 */
@Slf4j
@Service("voiceMessage")
public class VoiceMessageService implements IVoiceMessage {
    @Override
    public String voiceHandle() {
        return null;
    }
}
