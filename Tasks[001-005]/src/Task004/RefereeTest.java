package Task004;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Alexander on 26/02/2016.
 */
public class RefereeTest {
    private static Referee emptyReferee;
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    @BeforeClass
    public static void init() {
        emptyReferee = new Referee();
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        Player player = mock(Forward.class);
        Referee referee = new Referee(player, 24, 57);

        Assert.assertTrue((referee.getFavouritePlayer().equals(player) && referee.getRedCardCount() == 24 && referee.getYeallowCardCount() == 57));
    }

    @Test
    public void whistleShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));
        emptyReferee.whistle();

        Assert.assertEquals("*свистооок*\n", OUTPUT.toString());
    }

    @Test
    public void getAdviceFromAnotherRefereeShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        Referee anotherReferee = new Referee();
        anotherReferee.setName("Пьер Луиджи Калина");

        emptyReferee.getAdviceFromAnotherReferee(anotherReferee);

        Assert.assertEquals("НУЖНА ПОМОЩЬ!!! Выручай, Пьер Луиджи Калина\n", OUTPUT.toString());
    }

    @Test
    public void givingFirstYellowCardToPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        Player player = mock(Forward.class);
        when(player.getYellowCardsCount()).thenReturn(0, 1);

        Card card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.YELLOW);

        emptyReferee.giveACardToPlayer(card, player);

        Assert.assertTrue(player.getYellowCardsCount() == 1 && "ЕЩЕ ОДНА КАРТОЧКА, И ТЫ УЙДЕШЬ С ПОЛЯ!\n".equals(OUTPUT.toString()));
    }

    @Test
    public void givingSecondYellowCardToPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = mock(Forward.class);
        when(player.getYellowCardsCount()).thenReturn(2);

        Card card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.YELLOW);

        emptyReferee.giveACardToPlayer(card, player);

        Assert.assertTrue(player.getYellowCardsCount() == 2 && "ДВЕ ЖЕЛТЫЕ КАРТОЧКИ! ВОН!1\n".equals(OUTPUT.toString()));
    }

    @Test
    public void givingRedCardToPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        Player player = mock(Forward.class);
        Card card = mock(Card.class);
        when(card.getColor()).thenReturn(Color.RED);

        emptyReferee.giveACardToPlayer(card, player);

        Assert.assertEquals("УХОДИ С ПОЛЯ!1!\n", OUTPUT.toString());
    }
}