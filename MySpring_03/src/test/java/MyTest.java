import com.gemini.pojo.Address;
import com.gemini.pojo.Human;
import com.gemini.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gemini
 * Created in  2021/5/4 11:03
 */
public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Address address = context.getBean("address", Address.class);
        System.out.println(address);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beansConstr.xml");
        Address address = context.getBean("address1", Address.class);
        Address address1 = context.getBean("address1", Address.class);
        System.out.println(address.hashCode());
        System.out.println(address1.hashCode());
        System.out.println(address==address1);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Human human = context.getBean("human", Human.class);
        human.getDog().shout();
        human.getCat().shout();
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beansAnno.xml");
        Human human = context.getBean("human", Human.class);
        human.getDog().shout();
        human.getCat().shout();
    }

}
