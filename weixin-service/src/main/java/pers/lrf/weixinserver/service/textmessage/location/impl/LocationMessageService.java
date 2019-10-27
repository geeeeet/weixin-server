package pers.lrf.weixinserver.service.textmessage.location.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.service.textmessage.location.interfaces.ILocationMessage;

/**
 * @author lirufeng
 * @date 2019/10/27 下午 1:48
 */
@Slf4j
@Service("locationMessage")
public class LocationMessageService implements ILocationMessage {
    @Override
    public String locationHandle() {
        return null;
    }
}
