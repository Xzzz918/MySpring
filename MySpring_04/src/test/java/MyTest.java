import com.gemini.config.MyConfig;
import com.gemini.pojo.Dog;
import com.gemini.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gemini
 * Created in  2021/5/4 15:03
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user.name);
    }

    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Dog dog = context.getBean("dog", Dog.class);
        Dog getDog = context.getBean("getDog", Dog.class);
        System.out.println(dog.hashCode());
        System.out.println(getDog.hashCode());
        System.out.println(dog == getDog);
    }
}
