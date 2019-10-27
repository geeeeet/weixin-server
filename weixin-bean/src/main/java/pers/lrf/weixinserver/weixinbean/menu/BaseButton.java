package pers.lrf.weixinserver.weixinbean.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lirufeng
 * @date 2019/10/16 12:29
 **/
@Data
public class BaseButton {
    private List<SubButton> button = new ArrayList<>();
}
