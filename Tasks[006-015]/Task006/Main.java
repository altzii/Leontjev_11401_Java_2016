package Task006;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * Created by Alexander on 12/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Task006/spring-config-task006.xml");

        //полиморфизм
        ArrayList<Player> players = (ArrayList<Player>) ac.getBean("players");
        System.out.println(players.size());

        Forward forward = (Forward) ac.getBean("forward");
        Defender defender = (Defender) ac.getBean("defender");
        Ball ball = (Ball) ac.getBean("ball");

        for (Player player : players) {
            player.kick(ball);
        }

        ball.toBreak(forward);
        ball.toLose();
        ball.removeFromField();

        Card card = (Card) ac.getBean("card");

        Referee referee = (Referee) ac.getBean("referee");
        Referee anotherReferee = (Referee) ac.getBean("anotherReferee");

        referee.getAdviceFromAnotherReferee(anotherReferee);
        referee.giveACardToPlayer(card, forward);
        referee.whistle();

        Team team = (Team) ac.getBean("team");
        team.enterTheField();
        team.startTraining();
        team.leaveTheField();

        /*  пример восходящего преобразования (ограничение функицонала потомка при объявлении родителем)
            создадим защитника с поведением простого игрока (например, он еще не научился навыкам защиты)
            методы, которые есть в интерфейс Defending, будут недоступны ему (например, метод defend)
        */

        defender.say(forward, "ГОРИШЬ!1!!");
        // defender1.defend(forward)    -    не вызовется, т.к восходщее преобразование
    }
}
