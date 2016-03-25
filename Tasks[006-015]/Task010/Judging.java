package Task010;

/**
 * Created by Alexander on 23/02/2016.
 */
public interface Judging {
    public void giveACardToPlayer(Card card, Player player);           //показать карточку игроку
    public void whistle();          //свистнуть
    public void getAdviceFromAnotherReferee(Judging referee);
}
