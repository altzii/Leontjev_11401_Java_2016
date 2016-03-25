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
public class NetOnGoalTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static NetOnGoal emptyNetOnGoal;
    static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task010/spring-config-task010.xml");
        emptyNetOnGoal = (NetOnGoal) ac.getBean("emptyNetOnGoal");
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        FootballGoal footballGoal = (FootballGoal) ac.getBean("footballGoal");
        NetOnGoal netOnGoal = (NetOnGoal) ac.getBean("netOnGoal");
        Assert.assertTrue(netOnGoal.getFootballGoal().equals(footballGoal) && netOnGoal.getColor().equals("Orange") && netOnGoal.getSize() == 23.2);
    }

    @Test
    public void toBreakShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = (Player) ac.getBean("playerDefender");

        emptyNetOnGoal.toBreak(player);

        Assert.assertEquals("я порвалась\n", OUTPUT.toString());
    }

    @Test
    public void removeFromFieldShouldWorkShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyNetOnGoal.removeFromField();

        Assert.assertEquals("сетку сняли и убрали\n", OUTPUT.toString());
    }

    @Test
    public void toLoseShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyNetOnGoal.toLose();

        Assert.assertEquals("потеряли вместе с воротами ;(\n", OUTPUT.toString());
    }
}
