package Task013;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 23/03/2016.
 */
@Aspect
public class CheckEmail {
    @Around("execution(* *..*.setEmail(String))")
    public Object checkEmail(ProceedingJoinPoint jp) throws Throwable {
        String input = (String) jp.getArgs()[0];
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return jp.proceed();
        }
        System.out.println("error, please input your email");
        return null;

    }
}
