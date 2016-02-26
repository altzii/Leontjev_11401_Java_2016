package Task004;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;

/**
 * Created by Alexander on 26/02/2016.
 */
public class FootballGoalTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static FootballGoal emptyFootballGoal;

    @BeforeClass
    public static void init() {
        emptyFootballGoal = new FootballGoal();
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        NetOnGoal netOnGoal = mock(NetOnGoal.class);

        FootballGoal footballGoal = new FootballGoal(3, netOnGoal, 34.4);

        Assert.assertTrue(footballGoal.getSize() == 34.4 && footballGoal.getAge() == 3 && footballGoal.getNet().equals(netOnGoal));
    }

    @Test
    public void toBreakShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = mock(Defender.class);

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
