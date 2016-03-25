package Task006;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Alexander on 12/02/2016.
 */
@Component
public class Ball implements Inventory {
    @Value("4")
    int size;
    @Value("Nike")
    String name;
    @Autowired
    @Qualifier("defender")
    Player owner;
    @Value("23.4")
    double weight;
    int tricksCount;   //сколько раз с этим мячом выполняли финт

    public Ball(int size, String name, Player owner, double weight) {
        this.size = size;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    public Ball() {
    }

    @Override
    public void toBreak(Player player) {
        System.out.println("я порвался ;(");
    }

    @Override
    public void toLose() {
        System.out.println("меня украл какой-то злодей на трибунах");
    }

    @Override
    public void removeFromField() {
        System.out.println("меня убрали в подтрибунное помещение, пора отдохнуть");
    }

    public void trick() {
        this.tricksCount++;
    }


}
