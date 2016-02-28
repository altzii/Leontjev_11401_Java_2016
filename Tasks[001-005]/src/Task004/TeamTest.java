package Task004;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

/**
 * Created by Alexander on 28/02/2016.
 */
public class TeamTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static Team team;
    private static ArrayList<Player> players;

    @BeforeClass
    public static void init() {
        players = new ArrayList<Player>();
        Forward forward = mock(Forward.class);
        doCallRealMethod().when(forward).kick(anyObject());
        players.add(forward);
        players.add(forward);
        team = new Team("FC Shumerlya", "Shumerlya", 50, players);
    }


    @Test
    public void constructorOnPlayersShouldWorkCorrect() {
        Team team1 = new Team(players);

        Assert.assertEquals(team1.getPlayers(), players);
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
                "Я ударил по мячу, используя навыки нападающего\n", OUTPUT.toString());
    }
}
