package pers.lrf.weixinserver.service.textmessage.image.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.lrf.weixinserver.common.constant.MsgType;
import pers.lrf.weixinserver.common.constant.SafeXml;
import pers.lrf.weixinserver.common.utils.MessageUtils;
import pers.lrf.weixinserver.service.interfaces.IImageMeassage;
import pers.lrf.weixinserver.weixinbean.message.normal.WxImageMessage;
import pers.lrf.weixinserver.weixinbean.message.normal.submessage.ImageMessage;

import java.util.Map;

/**
 * 图片消息处理类
 *
 * @author lirufeng
 * @date 2019/10/27 下午 12:15
 */

@Slf4j
@Service("imageMeassage")
public class ImageMeassageService implements IImageMeassage {
    @Override
    public String imageHandl(Map<String,String> map) {
        System.out.println("请求到了："+map);
        WxImageMessage returnImage = new WxImageMessage();
        ImageMessage image = new ImageMessage();
        returnImage.setFromUserName(map.get("ToUserName"));
        returnImage.setToUserName(map.get("FromUserName"));
        returnImage.setCreateTime(System.currentTimeMillis());
        returnImage.setMsgType(MsgType.IMAGE);
        image.setMediaId(SafeXml.PRE_XML+map.get("MediaId")+SafeXml.SUFF_XML);
        returnImage.setImage(image);

        String result = MessageUtils.objectToXml(returnImage);
        System.out.println(result);
        return result;
    }
}