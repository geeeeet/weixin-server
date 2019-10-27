import org.junit.Test;
import pers.lrf.weixinserver.common.exception.CodeMeans;

/**
 * @author lirufeng
 * @date 2019/10/17 18:02
 **/
public class TestUnit {

    @Test
    public void test() {
        String s="65316";
        System.out.println(CodeMeans.getExceptionOfCode(s));
    }
}
