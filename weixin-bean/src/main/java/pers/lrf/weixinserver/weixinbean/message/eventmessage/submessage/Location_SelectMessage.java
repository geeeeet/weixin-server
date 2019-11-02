package pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage;

import lombok.Data;

/**
 * location_select：弹出地理位置选择器的事件推送子节点
 *
 * @author lirufeng
 * @date 2019/11/02 上午 11:59
 */
@Data
public class Location_SelectMessage {

    private Double Location_X;

    private Double Location_Y;

    private Integer Scale;

    private String Label;

    private String Poiname;

}
