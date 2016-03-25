package Task011;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Alexander on 25/03/2016.
 */
@Aspect
public class StartingServer {
    //перед созданием (запуском) нового сервера выводим информацию об этом
    @Before("execution(Server.new(..))")
    public void startingServer(JoinPoint jp) {
        System.out.println("Запуск сервера");
    }
}
