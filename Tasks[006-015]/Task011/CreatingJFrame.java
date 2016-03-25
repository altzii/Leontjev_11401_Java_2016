package Task011;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by Alexander on 25/03/2016.
 */
@Aspect
public class CreatingJFrame {
    //не позволяем пользователю создать игру с размером поля <2
    @Around("execution(DotsAndSquares.new(int))")
    public Object checkInput(ProceedingJoinPoint jp) throws Throwable {
        String input = (String) jp.getArgs()[0];
        if (Integer.parseInt(input) < 2) {
            System.out.println("Размер поля должен быть больше 1");
            return null;
        }
        return jp.proceed();
    }
}
