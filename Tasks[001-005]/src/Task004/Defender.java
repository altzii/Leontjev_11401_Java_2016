package Task004;

/**
 * Created by Alexander on 12/02/2016.
 */
public class Defender implements Player, Defending {
    int wonCombatsCount;            //количество выигранных единоборств
    Ball favouriteBall;             //любимый мяч
    String position;                //крайний, центральный
    int yellowCardCount;        //количество желтых карточек в матче

    public Defender(Ball favouriteBall, String position) {
        this.favouriteBall = favouriteBall;
        this.position = position;
    }

    public Defender() {
    }

    public int getWonCombatsCount() {
        return wonCombatsCount;
    }

    public Ball getFavouriteBall() {
        return favouriteBall;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "защитник";
    }

    @Override
    public void defend(Player player) {
        System.out.println("Отобрал мяч как истинный защитник");
        wonCombatsCount++;
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
        System.out.println("Я ударил по мячу, используя навыки защитника");
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
    public void getYellowCard() {
        yellowCardCount++;
    }
}
