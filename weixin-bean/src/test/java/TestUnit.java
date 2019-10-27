import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.junit.Test;
import pers.lrf.weixinserver.weixinbean.menu.BaseButton;
import pers.lrf.weixinserver.weixinbean.menu.SubButton;

/**
 * @author lirufeng
 * @date 2019/10/17 15:29
 **/

public class TestUnit {

    @Test
    public void test() {
        BaseButton baseButton = new BaseButton();
        SubButton subButton0 = new SubButton();
        subButton0.setKey("1");
        subButton0.setName("lrf");
        subButton0.setType("click");

        SubButton subButton1 = new SubButton();
        subButton1.setKey("2");
        subButton1.setName("lrf2");
        subButton1.setType("click");

        baseButton.getButton().add(subButton0);
        baseButton.getButton().add(subButton1);
        JSONObject o = (JSONObject) JSONObject.toJSON(baseButton);
        System.out.println(o);
    }
}
