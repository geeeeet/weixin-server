package pers.lrf.weixinserver.weixinbean.message.eventmessage;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lirufeng
 * @date 2019/11/02 上午 11:30
 */
@Data
public class WxLocationMessage extends EventBaseMessage implements Serializable {

    /**
     * 地理位置纬度
     */
    private Double Latitude;

    /**
     * 地理位置经度
     */
    private Double Longitude;

    /**
     * 地理位置精度
     */
    private Double Precision;
}
