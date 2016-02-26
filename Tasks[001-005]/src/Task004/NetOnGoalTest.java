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
public class NetOnGoalTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static NetOnGoal emptyNetOnGoal;

    @BeforeClass
    public static void init() {
        emptyNetOnGoal = new NetOnGoal();
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        FootballGoal footballGoal = mock(FootballGoal.class);

        NetOnGoal netOnGoal = new NetOnGoal(footballGoal, 23.2, "Orange");

        Assert.assertTrue(netOnGoal.getFootballGoal().equals(footballGoal) && netOnGoal.getColor().equals("Orange") && netOnGoal.getSize() == 23.2);
    }

    @Test
    public void toBreakShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = mock(Defender.class);

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
