package Task010;

/**
 * Created by Alexander on 12/02/2016.
 */
public class Forward implements Player, Attacking {
    int bestForwardWonCount;        //количество побед в номинации лучший форвард
    int yellowCardCount;        //количество желтых карточек в матче
    Player favouriteTeammate;       //лучший друг  в команде

    public int getBestForwardWonCount() {
        return bestForwardWonCount;
    }

    public Player getFavouriteTeammate() {
        return favouriteTeammate;
    }

    public Forward(int bestForwardWonCount, int yellowCardCount, Player favouriteTeammate) {
        this.bestForwardWonCount = bestForwardWonCount;
        this.yellowCardCount = yellowCardCount;
        this.favouriteTeammate = favouriteTeammate;
    }

    public Forward() {
    }

    @Override
    public void performATrick(Ball ball, Player player) {
        System.out.println("сделал финт в атаке, выполняя обводку игрока");
        ball.trick();
    }

    @Override
    public void performATrick(Ball ball) {
        ball.trick();
    }

    @Override
    public void kick(Ball ball) {
        System.out.println("Я ударил по мячу, используя навыки нападающего");
    }

    @Override
    public void say(Player player, String string) {
        System.out.println("эй, " + player + ", " + string);

    }

    @Override
    public void passTheBall(Player player, int speed, Ball ball) {
        player.takePass(ball, player);
        System.out.println("я отдал передачу " + player);
    }

    @Override
    public void takePass(Ball ball, Player fromPlayer) {
        System.out.println("я принял мяч от " + fromPlayer);
    }

    @Override
    public int getYellowCardsCount() {
        return yellowCardCount;
    }

    @Override
    public String toString() {
        return "нападающий";
    }

    @Override
    public void getYellowCard() {
        yellowCardCount++;
    }
}
