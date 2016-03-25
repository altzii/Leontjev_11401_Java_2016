package Task012;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alexander on 24/03/2016.
 */
@Aspect
public class CheckInput {
    @Around("execution(* *..Test.execute(String))")
    public Object checkEmail(ProceedingJoinPoint jp) throws Throwable {
        String input = (String) jp.getArgs()[0];
        Pattern pattern = Pattern.compile("(.*)(select|update|create|delete|alter|drop|commit|rollback|insert|grant|revoke|savepoint|deny)(.*);");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            return jp.proceed();
        }
        System.out.println("warning! sql-injection was found");
        return null;
    }
}
