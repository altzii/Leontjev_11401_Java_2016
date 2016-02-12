/**
 * Created by Alexander on 12/02/2016.
 */
public class Midfielder implements Player, Defending, Attacking {
    String position;        //крайний, центральный
    int passesCount;        //кол-во точных пассов в полузащите
    int bestMidfielderdWonCount;        //количество побед в номинации лучший полузащитник
    Player favouriteTeammate;       //лучший друг  в команде

    @Override
    public void performATrick(Ball ball, Player player) {

    }

    @Override
    public void defend(Player player) {

    }

    @Override
    public void sendASignalToTeam(String string) {

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

    }

    @Override
    public void simulate() {

    }

    @Override
    public void passTheBall(Player player, int speed) {

    }
}
