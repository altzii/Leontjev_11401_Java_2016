/**
 * Created by Alexander on 12/02/2016.
 */
public class Forward implements Player, Attacking {
    int bestForwardWonCount;        //количество побед в номинации лучший форвард


    @Override
    public void performATrick(Ball ball, Player player) {

    }

    @Override
    public void kick(Ball ball) {
        System.out.println("Я ударил по мячу, используя навыки нападающего");
    }

    @Override
    public void say(Player player, String string) {

    }

    @Override
    public void simulate() {
    }

    @Override
    public void passTheBall(Player player, int speed) {

    }
}
