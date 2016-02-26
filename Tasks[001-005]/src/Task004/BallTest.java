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
public class BallTest {
    private static final double EPS = 1e-9;
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static Ball emptyBall;

    @BeforeClass
    public static void init() {
        emptyBall = new Ball();
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        Player player = mock(Defender.class);
        String name = "Nike";
        int size = 8;
        double weight = 23.4;

        Ball ball = new Ball(size, name, player, weight);

        Assert.assertTrue(ball.getSize() == size && ball.getName().equals(name) && ball.getWeight() == weight && ball.getOwner().equals(player));
    }

    @Test
    public void toBreakShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = mock(Defender.class);

        emptyBall.toBreak(player);

        Assert.assertEquals("я порвался ;(\n", OUTPUT.toString());
    }

    @Test
    public void removeFromFieldShouldWorkShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyBall.removeFromField();

        Assert.assertEquals("меня убрали в подтрибунное помещение, пора отдохнуть\n", OUTPUT.toString());
    }

    @Test
    public void toLoseShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyBall.toLose();

        Assert.assertEquals("меня украл какой-то злодей на трибунах\n", OUTPUT.toString());
    }

    @Test
    public void trickShouldWorkCorrect() {
        Ball ball = new Ball();
        ball.setTricksCount(3);
        ball.trick();

        Assert.assertEquals(ball.getTricksCount(), 4, EPS);
    }
}
