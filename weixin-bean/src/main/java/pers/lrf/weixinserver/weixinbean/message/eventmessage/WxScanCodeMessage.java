package pers.lrf.weixinserver.weixinbean.message.eventmessage;

import lombok.Data;
import pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage.ScanCodeMessage;

import java.io.Serializable;

/**
 * 扫描带参数二维码事件
 * @author lirufeng
 * @date 2019/11/02 上午 11:23
 */
@Data
public class WxScanCodeMessage extends EventBaseMessage implements Serializable {

    /**
     * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     */
    private String EventKey;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String Ticket;

    /**
     * 子节点，扫描信息
     */
    private ScanCodeMessage ScanCodeInfo;
}
