import com.gemini.pojo.Hello;
import com.gemini.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gemini
 * Created in  2021/5/3 20:38
 */
public class MyTest {
    @Test
    public void test() {
//        获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("helloBeans.xml");
//        对象现在都在Spring容器中，如果要使用，直接去容器中取出来即可
        Hello hello = (Hello) context.getBean("hello");
        hello.show();
    }

    @Test
    public void test1() {
//        获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("helloBeans.xml");
//        对象现在都在Spring容器中，如果要使用，直接去容器中取出来即可
        User user = (User) context.getBean("user4");
        user.show();
    }
}
