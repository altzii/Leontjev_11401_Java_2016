package Task007;

import Task006.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;

/**
 * Created by Alexander on 21/03/2016.
 */
@Configuration
@ComponentScan(basePackages = {"Task006"})
public class JavaConfig {
    @Qualifier("referee")
    @Bean
    @Scope("prototype")
    public Referee referee() {
        return new Referee();
    }

    @Qualifier("defender")
    @Bean
    public Defender defender() {
        return new Defender();
    }

    @Qualifier("forward")
    @Bean
    public Forward forward() {
        return new Forward();
    }

    @Qualifier("midfielder")
    @Bean
    public Midfielder midfielder() {
        return new Midfielder();
    }

    @Qualifier("players")
    @Bean
    public ArrayList<Player> players() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(forward());
        players.add(defender());
        players.add(midfielder());

        return players;
    }

    @Qualifier
    @Bean
    public Team team() {
        return new Team(players());
    }
}
