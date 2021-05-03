import com.gemini.dao.UserDaoMysqlImpl;
import com.gemini.dao.UserDaoOracleImpl;
import com.gemini.service.UserService;
import com.gemini.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gemini
 * Created in  2021/5/3 22:08
 */
public class MyTest {
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
