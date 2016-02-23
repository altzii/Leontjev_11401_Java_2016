/**
 * Created by Alexander on 12/02/2016.
 */
public class Midfielder implements Player, Defending, Attacking {
    String position;        //крайний, центральный
    int passesCount;        //кол-во точных пассов в полузащите
    int yellowCardCount;        //количество желтых карточек в матче
    int bestMidfielderdWonCount;        //количество побед в номинации лучший полузащитник
    Player favouriteTeammate;       //лучший друг  в команде

    public Midfielder(String position, int passesCount, int yellowCardCount, int bestMidfielderdWonCount, Player favouriteTeammate) {
        this.position = position;
        this.passesCount = passesCount;
        this.yellowCardCount = yellowCardCount;
        this.bestMidfielderdWonCount = bestMidfielderdWonCount;
        this.favouriteTeammate = favouriteTeammate;
    }

    public Midfielder() {
    }


    @Override
    public void performATrick(Ball ball, Player player) {
        System.out.println("сделал финт, выполняю обводку игрока");
        ball.trick();
        player.say(this, "ты такой финт красивый сделал!1");
    }

    @Override
    public void performATrick(Ball ball) {
        ball.trick();
    }

    @Override
    public void defend(Player player) {
        System.out.println("отобрал мяч у " + player);
    }

    @Override
    public void sendASignalToTeam(String string) {
        System.out.println(string);
    }

    @Override
    public void sendTheBallToGoalkeeper(Ball ball) {

    }

    @Override
    public void kick(Ball ball) {
        System.out.println("Я ударил по мячу, используя навыки полузащитника");
    }

    @Override
    public void say(Player player, String string) {
        System.out.println("эй, + " + player + ", " + string);

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
    public void getYellowCard() {
        yellowCardCount++;
    }
}
