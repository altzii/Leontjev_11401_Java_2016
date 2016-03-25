package Task010;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Alexander on 28/02/2016.
 */
public class MidfielderTest {
    private static Midfielder emptyMidfielder;
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static Ball ball;
    static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task010/spring-config-task010.xml");
        emptyMidfielder = (Midfielder) ac.getBean("emptyMidfielder");
        ball = (Ball) ac.getBean("ball");
    }


    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        Defender defender = (Defender) ac.getBean("playerDefender");

        Midfielder midfielder = (Midfielder) ac.getBean("midfielder");

        Assert.assertTrue((midfielder.getFavouriteTeammate().equals(defender) &&
                midfielder.getYellowCardsCount() == 0 &&
                midfielder.getBestMidfielderdWonCount() == 2 &&
                midfielder.getPassesCount() == 23) &&
                midfielder.getPosition().equals("left"));
    }

    @Test
    public void performATrickWithPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = (Player) ac.getBean("playerDefender");

        emptyMidfielder.performATrick(ball, player);

        Assert.assertEquals("сделал финт, выполняя обводку игрока\nэй, полузащитник, ты такой финт красивый сделал!1\n", OUTPUT.toString());
    }

    @Test
    public void perfomATrickOnlyWithBallShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyMidfielder.performATrick(ball);

        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void kickShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyMidfielder.kick(ball);

        Assert.assertEquals("Я ударил по мячу, используя навыки полузащитника\n", OUTPUT.toString());
    }

    @Test
    public void sayShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));

        emptyMidfielder.say(emptyMidfielder, "давай сюда!");

        Assert.assertEquals("эй, полузащитник, давай сюда!\n", OUTPUT.toString());
    }

    @Test
    public void passTheBallShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyMidfielder.passTheBall(emptyMidfielder, 23, ball);

        Assert.assertEquals("я принял мяч от полузащитник\n" +
                "я отдал передачу полузащитник\n", OUTPUT.toString());

    }

    @Test
    public void getYellowCardShouldWorkCorrectly() {
        emptyMidfielder.getYellowCard();

        Assert.assertEquals(emptyMidfielder.getYellowCardsCount(), 1);
    }

    @Test
    public void sendASignalToTeam() {
        System.setOut(new PrintStream(OUTPUT));

        emptyMidfielder.sendASignalToTeam("ВЫШЛИИИИИИИИИ!1!");

        Assert.assertEquals("ВЫШЛИИИИИИИИИ!1!\n", OUTPUT.toString());
    }

    @Test
    public void sendTheBallToGoalkeeper() {
        System.setOut(new PrintStream(OUTPUT));

        emptyMidfielder.sendTheBallToGoalkeeper(ball);

        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void defendShouldWorkCorrectly() {
        Forward forward = (Forward) ac.getBean("forward");
        System.setOut(new PrintStream(OUTPUT));

        emptyMidfielder.defend(forward);

        Assert.assertEquals("отобрал мяч у нападающий\n", OUTPUT.toString());
    }
}
