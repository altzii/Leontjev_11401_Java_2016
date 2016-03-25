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
public class RefereeTest {
    private static Referee emptyReferee;
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();
    static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task010/spring-config-task010.xml");
        emptyReferee = (Referee) ac.getBean("emptyReferee");
    }

    @Test
    public void constructorShouldSaveAllParamsCorrectly() {
        Player player = (Player) ac.getBean("playerDefender");
        Referee referee = (Referee) ac.getBean("referee");

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

        Referee anotherReferee = (Referee) ac.getBean("emptyReferee");
        anotherReferee.setName("Пьер Луиджи Калина");

        emptyReferee.getAdviceFromAnotherReferee(anotherReferee);

        Assert.assertEquals("НУЖНА ПОМОЩЬ!!! Выручай, Пьер Луиджи Калина\n", OUTPUT.toString());
    }

    @Test
    public void givingFirstYellowCardToPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        Player player = (Player) ac.getBean("playerDefender");
        Card card = (Card) ac.getBean("card");

        emptyReferee.giveACardToPlayer(card, player);

        Assert.assertTrue(player.getYellowCardsCount() == 1 && "ЕЩЕ ОДНА КАРТОЧКА, И ТЫ УЙДЕШЬ С ПОЛЯ!\n".equals(OUTPUT.toString()));
    }

    @Test
    public void givingSecondYellowCardToPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));
        Player player = (Player) ac.getBean("playerDefender");
        Card card = (Card) ac.getBean("card");

        emptyReferee.giveACardToPlayer(card, player);

        Assert.assertTrue(player.getYellowCardsCount() == 2 && "ДВЕ ЖЕЛТЫЕ КАРТОЧКИ! ВОН!1\n".equals(OUTPUT.toString()));
    }

    @Test
    public void givingRedCardToPlayerShouldWorkCorrectly() {
        System.setOut(new PrintStream(OUTPUT));

        Player player = (Player) ac.getBean("playerDefender");
        Card card = (Card) ac.getBean("redCard");

        emptyReferee.giveACardToPlayer(card, player);

        Assert.assertEquals("УХОДИ С ПОЛЯ!1!\n", OUTPUT.toString());
    }
}
