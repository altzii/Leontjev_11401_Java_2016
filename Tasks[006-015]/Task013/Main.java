package Task013;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alexander on 23/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Task013/spring-config-task013.xml");
        Test task013 = (Test) ac.getBean("task013");

        task013.setEmail("te@st@mail.ru");
    }
}
