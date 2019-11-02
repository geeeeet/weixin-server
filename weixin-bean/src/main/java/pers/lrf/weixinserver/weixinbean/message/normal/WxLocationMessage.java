package pers.lrf.weixinserver.weixinbean.message.normal;

import lombok.Data;

import java.io.Serializable;

/**
 * 地理位置消息
 * @author lirufeng
 * @date 2019/11/01 下午 11:19
 */
@Data
public class WxLocationMessage extends BaseMessage implements Serializable {

    /**
     * 地理位置维度
     */
    private Double Location_X;

    /**
     * 地理位置经度
     */
    private Double Location_Y;

    /**
     * 地图缩放大小
     */
    private Integer Scale;

    /**
     * 地理位置信息
     */
    private String Label;
}
