package Task006;

/**
 * Created by Alexander on 12/02/2016.
 */
public interface Player {
    void kick(Ball ball);                //ударить по мячу
    void say(Player player, String string);      //подсказат что-то другому игроку
    void passTheBall(Player player, int speed, Ball ball);   //отдать пас другому игроку с определенной скоростью
    void takePass(Ball ball, Player fromPlayer);   //принять пас
    int getYellowCardsCount();
    void getYellowCard();
}
