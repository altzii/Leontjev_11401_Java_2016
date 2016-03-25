package Task010;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by Alexander on 28/02/2016.
 */
public class TeamTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static Team team;
    private static ArrayList<Player> players;
    static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task010/spring-config-task010.xml");
        players = (ArrayList<Player>) ac.getBean("players");
        team = (Team) ac.getBean("team");
    }


    @Test
    public void constructorOnPlayersShouldWorkCorrect() {
        Assert.assertEquals(team.getPlayers(), players);
    }

    @Test
    public void constructorShouldWorkCorrectly() {
        Assert.assertTrue(team.getCity().equals("Shumerlya") && team.getAge() == 50 && team.getName().equals("FC Shumerlya") && team.getPlayers().equals(players));
    }

    @Test
    public void enterTheFieldShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        team.enterTheField();

        Assert.assertEquals("команда вышла на поле\n", OUTPUT.toString());
    }

    @Test
    public void leaveTheFieldShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        team.leaveTheField();

        Assert.assertEquals("команда ушла с поля\n", OUTPUT.toString());
    }

    @Test
    public void startTrainingShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        team.startTraining();

        Assert.assertEquals("Я ударил по мячу, используя навыки нападающего\n" +
                "Я ударил по мячу, используя навыки защитника\n", OUTPUT.toString());
    }
}
