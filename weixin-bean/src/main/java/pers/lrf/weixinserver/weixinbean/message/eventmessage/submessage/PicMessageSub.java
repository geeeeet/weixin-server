package pers.lrf.weixinserver.weixinbean.message.eventmessage.submessage;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lirufeng
 * @date 2019/11/02 上午 11:45
 */
@Data
public class PicMessageSub {

    private List<PicMessageSub1> item = new ArrayList<>();
}
