package Task007;

import Task006.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

/**
 * Created by Alexander on 21/03/2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

        //полиморфизм
        ArrayList<Player> players = (ArrayList<Player>) ac.getBean("players");

        Forward forward = (Forward) ac.getBean("forward");
        Defender defender = (Defender) ac.getBean("defender");
        Ball ball = ac.getBean(Ball.class);

        for (Player player : players) {
            player.kick(ball);
        }

        ball.toBreak(forward);
        ball.toLose();
        ball.removeFromField();

        Card card = ac.getBean(Card.class);

        Referee referee = (Referee) ac.getBean("referee");
        Referee anotherReferee = (Referee) ac.getBean("referee");

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
