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
public class DefenderTest {
    private static Defender emptyDefender;
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static Ball ball;
    static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task010/spring-config-task010.xml");
        emptyDefender = (Defender) ac.getBean("playerDefender");
        ball = (Ball) ac.getBean("ball");
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        Defender defender = (Defender) ac.getBean("leftDefender");


        Assert.assertTrue(defender.getPosition().equals("left") && defender.getFavouriteBall().equals(ball));
    }

    @Test
    public void defendShouldWorkCorrectly() {
        Forward forward = (Forward) ac.getBean("forward");
        System.setOut(new PrintStream(OUTPUT));

        emptyDefender.defend(forward);

        Assert.assertTrue("Отобрал мяч как истинный защитник\n".equals(OUTPUT.toString()) && emptyDefender.getWonCombatsCount() == 1);
    }

    @Test
    public void sendASignalToTeam() {
        System.setOut(new PrintStream(OUTPUT));

        emptyDefender.sendASignalToTeam("ВЫШЛИИИИИИИИИ!1!");

        Assert.assertEquals("ВЫШЛИИИИИИИИИ!1!\n", OUTPUT.toString());
    }

    @Test
    public void sendTheBallToGoalkeeper() {
        System.setOut(new PrintStream(OUTPUT));

        emptyDefender.sendTheBallToGoalkeeper(ball);

        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void kickShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyDefender.kick(ball);

        Assert.assertEquals("Я ударил по мячу, используя навыки защитника\n", OUTPUT.toString());
    }

    @Test
    public void sayShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));

        emptyDefender.say(emptyDefender, "давай сюда!");

        Assert.assertEquals("эй, защитник, давай сюда!\n", OUTPUT.toString());
    }

    @Test
    public void passTheBallShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyDefender.passTheBall(emptyDefender, 23, ball);

        Assert.assertEquals("я принял мяч от защитник\n" +
                "я отдал передачу защитник\n", OUTPUT.toString());

    }

    @Test
    public void getYellowCardShouldWorkCorrectly() {
        emptyDefender.getYellowCard();

        Assert.assertEquals(emptyDefender.getYellowCardsCount(), 1);
    }

    @Test
    public void takePassShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        emptyDefender.takePass(ball, emptyDefender);

        Assert.assertEquals("я принял мяч от защитник\n", OUTPUT.toString());
    }
}
