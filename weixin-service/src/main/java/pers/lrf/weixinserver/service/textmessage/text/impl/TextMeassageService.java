package pers.lrf.weixinserver.service.textmessage.text.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.common.utils.MessageUtils;
import pers.lrf.weixinserver.service.textmessage.text.interfaces.ITextMeassage;
import pers.lrf.weixinserver.weixinbean.message.WxTextMessage;

import java.util.Map;

/**
 * 文本消息处理类
 *
 * @author lirufeng
 * @date 2019/10/27 下午 12:13
 */
@Slf4j
@Service("textMeassage")
public class TextMeassageService implements ITextMeassage {
    @Override
    public String textHandle(Map<String,String> map) {

        WxTextMessage massag = new WxTextMessage();
        massag.setCreateTime(System.currentTimeMillis());
        massag.setFromUserName(map.get("ToUserName"));
        massag.setToUserName(map.get("FromUserName"));
        massag.setContent("我收到内容了！！");
        massag.setMsgId(1111111L);
        massag.setMsgType("text");

        System.out.println(MessageUtils.objectToXml(massag));
//        return MessageUtils.generateXml(map.get("FromUserName"),map.get("ToUserName"),
//                String.valueOf(System.currentTimeMillis()),map.get("MsgType"),
//                map.get("Content"),map.get("MsgId"));
        return MessageUtils.objectToXml(massag);
    }
}
