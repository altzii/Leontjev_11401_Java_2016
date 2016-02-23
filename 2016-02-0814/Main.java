import java.util.ArrayList;

/**
 * Created by Alexander on 12/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        //полиморфизм
        ArrayList<Player> players = new ArrayList<Player>();

        Forward forward = new Forward();
        Defender defender = new Defender();
        Midfielder midfielder = new Midfielder();

        Ball ball = new Ball(5, "Nike", forward, 23.3);

        players.add(forward);
        players.add(defender);
        players.add(midfielder);

        for (Player player : players) {
            player.kick(ball);
        }

        ball.toBreak(forward);
        ball.toLose();
        ball.removeFromField();

        Card card = new Card(Color.RED, midfielder, 23);

        Referee referee = new Referee();
        Referee anotherReferee = new Referee();
        referee.getAdviceFromAnotherReferee(anotherReferee);
        referee.giveACardToPlayer(card, forward);
        referee.whistle();

        Team team = new Team(players);
        team.enterTheField();
        team.startTraining();
        team.leaveTheField();

        /*  пример восходящего преобразования (ограничение функицонала потомка при объявлении родителем)
            создадим защитника с поведением простого игрока (например, он еще не научился навыкам защиты)
            методы, которые есть в интерфейс Defending, будут недоступны ему (например, метод defend)
        */

        Player defender1 = new Defender();
        defender1.say(forward, "ГОРИШЬ!1!!");
        // defender1.defend(forward)    -    не вызовется, т.к восходщее преобразование
    }
}
