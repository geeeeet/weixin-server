package pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage;

import lombok.Data;

/**
 * @author lirufeng
 * @date 2019/11/02 上午 11:46
 */
@Data
public class PicMessageSub1 {

    /**
     * 图片的MD5值，开发者若需要，可用于验证接收到图片
     */
    private String PicMd5Sum;
}
