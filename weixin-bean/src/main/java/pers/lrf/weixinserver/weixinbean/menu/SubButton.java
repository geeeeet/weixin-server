package pers.lrf.weixinserver.weixinbean.menu;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lirufeng
 * @date 2019/10/17 15:15
 **/
@Data
public class SubButton {
    private List<SubButton> sub_button = new ArrayList<>();
    @NonNull
    private String type;
    @NonNull
    private String name;
    private String key;
    private String url;
    private String media_id;
    private String appid;
    private String pagepath;

    public SubButton(){}
}
