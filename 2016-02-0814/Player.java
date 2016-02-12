/**
 * Created by Alexander on 12/02/2016.
 */
public interface Player {
    void kick(Ball ball);                //ударить по мячу

    void say(Player player, String string);      //подсказат что-то другому игроку

    void simulate();                        //симулировать

    void passTheBall(Player player, int speed);   //отдать пас другому игроку с определенной скоростью
}
