package pers.lrf.weixinserver.weixinbean.message.eventmessage;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage.PicMessage;

import java.io.Serializable;

/**
 * pic_sysphoto：弹出系统拍照发图的事件推送,Event为：pic_sysphoto
 * pic_photo_or_album：弹出拍照或者相册发图的事件推送,Event为：pic_photo_or_album
 * pic_weixin：弹出微信相册发图器的事件推送,Event为：pic_weixin
 *
 * @author lirufeng
 * @date 2019/11/02 上午 11:41
 */
@Data
public class WxPicMessage extends EventBaseMessage implements Serializable {

    private String EventKey;

    /**
     * 发送的图片信息
     */
    private PicMessage SendPicsInfo;


}
