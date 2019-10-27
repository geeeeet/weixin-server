package pers.lrf.weixinserver.service.textmessage.video.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.service.textmessage.video.interfaces.IVideoMessage;

/**
 * @author lirufeng
 * @date 2019/10/27 下午 1:53
 */
@Slf4j
@Service("videoMessage")
public class VideoMessageService implements IVideoMessage {
    @Override
    public String videoHandle() {
        return null;
    }
}
