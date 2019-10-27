import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author lirufeng
 * @date 2019/10/7 15:20
 **/

@RunWith(JUnit4.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class BaseJunitTest {

    private long startTime ;
    @Before
    public void before(){
        startTime = System.currentTimeMillis();
    }
    @After
    public void after() {
        System.out.printf("该方法执行了[%d]毫秒!\n", System.currentTimeMillis() - this.startTime);
    }
}
