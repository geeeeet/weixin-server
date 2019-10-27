package pers.lrf.weixinserver.service.textmessage.shortvideo.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.service.textmessage.shortvideo.interfaces.IShortVideoMessage;

/**
 * @author lirufeng
 * @date 2019/10/27 下午 1:51
 */
@Slf4j
@Service("shortVideoMessage")
public class ShortVideoMessageService implements IShortVideoMessage {
    @Override
    public String shortVideoHandle() {
        return null;
    }
}
