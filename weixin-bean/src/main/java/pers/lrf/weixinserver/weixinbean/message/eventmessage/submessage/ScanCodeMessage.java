package pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage;

import lombok.Data;

/**
 * @author lirufeng
 * @date 2019/11/02 上午 11:25
 */
@Data
public class ScanCodeMessage {

    /**
     * 扫描信息
     */
    private String ScanType;

    /**
     * 扫描结果，即二维码对应的字符串信息
     */
    private String ScanResult;
}
