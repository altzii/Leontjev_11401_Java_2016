package Task012;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alexander on 24/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Task012/spring-config-task012.xml");
        Test task013 = (Test) ac.getBean("task012");

        task013.execute("select * from users;");
    }
}
