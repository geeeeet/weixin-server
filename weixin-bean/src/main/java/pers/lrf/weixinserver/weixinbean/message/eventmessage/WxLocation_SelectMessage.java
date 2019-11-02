package pers.lrf.weixinserver.weixinbean.message.eventmessage;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage.Location_SelectMessage;

import java.io.Serializable;

/**
 * location_select：弹出地理位置选择器的事件推送，Event值为：location_select
 *
 * @author lirufeng
 * @date 2019/11/02 上午 11:57
 */
@Data
public class WxLocation_SelectMessage extends EventBaseMessage implements Serializable {

    private String EventKey;

    private Location_SelectMessage SendLocationInfo;
}
