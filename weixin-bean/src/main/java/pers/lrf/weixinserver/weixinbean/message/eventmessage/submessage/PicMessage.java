package pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage;

import lombok.Data;

/**
 * @author lirufeng
 * @date 2019/11/02 上午 11:42
 */
@Data
public class PicMessage {

    /**
     * 发送的图片数量
     */
    private Integer Count;

    /**
     * 图片列表
     */
    private PicMessageSub PicList;
}
