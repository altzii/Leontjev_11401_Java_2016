/**
 * Created by Alexander on 12/02/2016.
 */
public class Defender implements Player, Defending {
    int wonCombatsCount;            //количество выигранных единоборств
    Ball favouriteBall;             //любимый мяч
    int endurance;                  //уровень выносливости
    String position;                //крайний, центральный


    @Override
    public void defend(Player player) {
        System.out.println("Отобрал мяч как истиный защитник");
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
        System.out.println(string);
    }

    @Override
    public void simulate() {

    }

    @Override
    public void passTheBall(Player player, int speed) {

    }
}
