package Task004;

import java.util.ArrayList;

/**
 * Created by Alexander on 23/02/2016.
 */
public class Team implements Command {
    String name;
    String city;
    int age;
    ArrayList<Player> players;

    public Team(String name, String city, int age, ArrayList<Player> players) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.players = players;
    }

    public Team() {
    }

    public Team(ArrayList<Player> players) {
    }

    @Override
    public void enterTheField() {
        System.out.println("команда вышла на поле");
    }

    @Override
    public void leaveTheField() {
        System.out.println("команда ушла с поля");
    }

    @Override
    public void startTraining() {
        Ball ball = new Ball();
        if (players != null) {
            for (Player player : players) {
                player.kick(ball);
            }
        }
    }
}
