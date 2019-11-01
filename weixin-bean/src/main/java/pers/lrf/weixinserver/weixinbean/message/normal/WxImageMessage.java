package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.normal.submessage.ImageMessage;

/**
 * 图片消息
 *
 * @author lirufeng
 * @date 2019/10/27 下午 3:47
 */
@Data
public class WxImageMessage extends BaseMessage {

    private String MediaId;

    private String PicUrl;

    private ImageMessage Image;

}
