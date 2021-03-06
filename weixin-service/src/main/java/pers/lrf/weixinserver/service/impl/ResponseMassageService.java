package pers.lrf.weixinserver.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.common.constant.EventType;
import pers.lrf.weixinserver.common.constant.MsgType;
import pers.lrf.weixinserver.common.utils.MessageUtils;
import pers.lrf.weixinserver.service.textmessage.image.interfaces.IImageMeassage;
import pers.lrf.weixinserver.service.interfaces.IResponseMassage;
import pers.lrf.weixinserver.service.textmessage.link.interfaces.ILinkMessage;
import pers.lrf.weixinserver.service.textmessage.location.interfaces.ILocationMessage;
import pers.lrf.weixinserver.service.textmessage.shortvideo.interfaces.IShortVideoMessage;
import pers.lrf.weixinserver.service.textmessage.text.interfaces.ITextMeassage;
import pers.lrf.weixinserver.service.textmessage.video.interfaces.IVideoMessage;
import pers.lrf.weixinserver.service.textmessage.voice.interfaces.IVoiceMessage;

import java.util.Map;

/**
 * @author lirufeng
 * @date 2019/10/15 18:09
 **/
@Service
@Slf4j
public class ResponseMassageService implements IResponseMassage {

    @Autowired
    private ITextMeassage textMeassage;
    @Autowired
    private IImageMeassage imageMeassage;
    @Autowired
    private ILinkMessage linkMessage;
    @Autowired
    private ILocationMessage locationMessage;
    @Autowired
    private IShortVideoMessage shortVideoMessage;
    @Autowired
    private IVideoMessage videoMessage;
    @Autowired
    private IVoiceMessage voiceMessage;

    @Override
    public String handleMassage(String message) {
        Map<String,String> map = null;
        String result = null;
        try {
            map = MessageUtils.xmlToMap(message);
            String msgType= map.get("MsgType");
            log.info("请求的消息类型是： "+msgType);
            // 普通文本消息
            if(msgType.equals(MsgType.TEXT)) result = textMeassage.textHandle(map);
            // 图片消息
            if(msgType.equals(MsgType.IMAGE)) result = imageMeassage.imageHandl(map);
            // 视频消息
            if(msgType.equals(MsgType.VIDEO)) result = videoMessage.videoHandle();
            // 短视频消息
            if (msgType.equals(MsgType.SHORT_VIDEO)) result = shortVideoMessage.shortVideoHandle();
            // 链接消息
            if (msgType.equals(MsgType.LINK)) result = linkMessage.linkHadle();
            // 地理位置消息
            if (msgType.equals(MsgType.LOCATION)) result = locationMessage.locationHandle();
            // 语音消息
            if (msgType.equals(MsgType.VOICE)) result = voiceMessage.voiceHandle();
            // 事件类型的消息
            if(msgType.equals(MsgType.EVENT)) {
                String event= map.get("Event");
                // 扫码关注
                if(event.equals(EventType.SUBSCRIBE)) result=null;
                // 取消关注
                if (event.equals(EventType.UNSUBSCRIBE)) result=null;
                // 上报地理位置
                if (event.equals(EventType.LOCATION)) result=null;
                // 点击菜单，消息推送
                if (event.equals(EventType.CLICK)) result=null;
                // 点击菜单，转链接
                if (event.equals(EventType.VIEW)) result=null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求报错",e);
        }
        return result;
    }
}
