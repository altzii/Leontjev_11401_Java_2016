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
public class CardTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    private static Card emptyCard;

    @BeforeClass
    public static void init() {
        emptyCard = new Card();
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        Player player = mock(Defender.class);

        Card card = new Card(Color.YELLOW, player, 4.2);

        Assert.assertTrue(card.getSize() == 4.2 && card.getColor() == Color.YELLOW && card.getPlayer().equals(player));
    }

    @Test
    public void toBreakShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = mock(Defender.class);

        emptyCard.toBreak(player);

        Assert.assertEquals("я погнулась и меня уронили в грязь, я больше не пригодна :(\n", OUTPUT.toString());
    }

    @Test
    public void removeFromFieldShouldWorkShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyCard.removeFromField();

        Assert.assertEquals("судья убрал меня в подтрибунное помещение, жду следующего матча ;) \n", OUTPUT.toString());
    }

    @Test
    public void toLoseShouldWorkCorrect() {
        System.setOut(new PrintStream(OUTPUT));
        emptyCard.toLose();

        Assert.assertEquals("судья уронил меня, и я потерялась\n", OUTPUT.toString());
    }
}
