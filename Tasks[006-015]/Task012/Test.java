package Task012;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alexander on 24/03/2016.
 */
public class Test {
    public void execute(String string) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Task012/spring-config-task012.xml");

        Test task012 = (Test) ac.getBean("task012");

        task012.execute("");


    }
}
