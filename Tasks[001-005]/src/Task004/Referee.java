package Task004;

/**
 * Created by Alexander on 23/02/2016.
 */
public class Referee implements Judging {
    String name;
    int yeallowCardCount;
    int redCardCount;
    Player favouritePlayer;    //игрок, которому чаще всего показывал красную карточку

    public Referee(Player favouritePlayer, int redCardCount, int yeallowCardCount) {
        this.favouritePlayer = favouritePlayer;
        this.redCardCount = redCardCount;
        this.yeallowCardCount = yeallowCardCount;
    }

    public Referee() {
    }

    public int getYeallowCardCount() {
        return yeallowCardCount;
    }

    public int getRedCardCount() {
        return redCardCount;
    }

    public Player getFavouritePlayer() {
        return favouritePlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void giveACardToPlayer(Card card, Player player) {
        if (card.getColor() == Color.RED) {
            System.out.println("УХОДИ С ПОЛЯ!1!");
        } else {
            player.getYellowCard();
            if (player.getYellowCardsCount() == 2) {
                System.out.println("ДВЕ ЖЕЛТЫЕ КАРТОЧКИ! ВОН!1");
            } else {
                System.out.println("ЕЩЕ ОДНА КАРТОЧКА, И ТЫ УЙДЕШЬ С ПОЛЯ!");
            }
        }
    }


    @Override
    public void whistle() {
        System.out.println("*свистооок*");
    }

    @Override
    public void getAdviceFromAnotherReferee(Judging referee) {
        System.out.println("НУЖНА ПОМОЩЬ!!! Выручай, " + referee);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
