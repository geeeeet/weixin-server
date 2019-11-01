package pers.lrf.weixinserver.weixinbean.message.normal.submessage;

import lombok.Data;

/**
 * 视频消息子节点
 * @author lirufeng
 * @date 2019/10/27 下午 6:10
 */
@Data
public class VideoMessage {
    private String MediaId;

    private String Title;

    private String Description;
}
