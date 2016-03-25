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
public class ForwardTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static Forward emptyForward;
    private static Ball ball;
    static ApplicationContext ac;


    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task010/spring-config-task010.xml");
        emptyForward = (Forward) ac.getBean("emptyForward");
        ball = (Ball) ac.getBean("ball");
    }


    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        Defender defender = (Defender) ac.getBean("playerDefender");
        Forward forward = (Forward) ac.getBean("forward");

        Assert.assertTrue((forward.getFavouriteTeammate().equals(defender) && forward.getYellowCardsCount() == 0 && forward.getBestForwardWonCount() == 23));
    }

    @Test
    public void performATrickWithPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = (Player) ac.getBean("playerDefender");

        emptyForward.performATrick(ball, player);

        Assert.assertEquals("сделал финт в атаке, выполняя обводку игрока\n", OUTPUT.toString());
    }

    @Test
    public void perfomATrickOnlyWithBallShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyForward.performATrick(ball);

        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void kickShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyForward.kick(ball);

        Assert.assertEquals("Я ударил по мячу, используя навыки нападающего\n", OUTPUT.toString());
    }

    @Test
    public void sayShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));

        emptyForward.say(emptyForward, "давай сюда!");

        Assert.assertEquals("эй, нападающий, давай сюда!\n", OUTPUT.toString());
    }

    @Test
    public void passTheBallShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyForward.passTheBall(emptyForward, 23, ball);

        Assert.assertEquals("я принял мяч от нападающий\n" +
                "я отдал передачу нападающий\n", OUTPUT.toString());

    }

    @Test
    public void getYellowCardShouldWorkCorrectly() {
        emptyForward.getYellowCard();

        Assert.assertEquals(emptyForward.getYellowCardsCount(), 1);
    }
}