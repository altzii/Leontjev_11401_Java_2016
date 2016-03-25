package Task010;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Alexander on 26/02/2016.
 */
public class FootballGoalTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static FootballGoal emptyFootballGoal;
    static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task010/spring-config-task010.xml");
        emptyFootballGoal = (FootballGoal) ac.getBean("emptyFootballGoal");
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        NetOnGoal netOnGoal = (NetOnGoal) ac.getBean("emptyNetOnGoal");

        FootballGoal footballGoal = (FootballGoal) ac.getBean("footballGoal");

        Assert.assertTrue(footballGoal.getSize() == 34.4 && footballGoal.getAge() == 3 && footballGoal.getNet().equals(netOnGoal));
    }

    @Test
    public void toBreakShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = (Player) ac.getBean("playerDefender");

        emptyFootballGoal.toBreak(player);

        Assert.assertEquals("в меня влетели бутсами, сетка порвалась\n", OUTPUT.toString());
    }

    @Test
    public void removeFromFieldShouldWorkShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyFootballGoal.removeFromField();

        Assert.assertEquals("матч закончился, убираем ворота с поля\n", OUTPUT.toString());
    }

    @Test
    public void toLoseShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyFootballGoal.toLose();

        Assert.assertEquals("забыли закрыть ворота на стадионе, футбольные ворота украли\n", OUTPUT.toString());
    }
}
