package Task006;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Alexander on 12/02/2016.
 */
@Qualifier("card")
@Component
public class Card implements Inventory {
    @Value("RED")
    Color color;       //цвет
    @Autowired
    @Qualifier("midfielder")
    Player player;      //игрок, которому больше всего она показывалась
    @Value("15.2")
    double size;        //размер
    Date data;          //дата выпуска

    public Card() {
    }

    public Card(Color color, Player player, double size) {
        this.color = color;
        this.player = player;
        this.size = size;
    }

    @Override
    public void toBreak(Player player) {
        System.out.println("я погнулась и меня уронили в грязь, я больше не пригодна :(");
    }

    @Override
    public void toLose() {
        System.out.println("судья уронил меня, и я потерялась");
    }

    @Override
    public void removeFromField() {
        System.out.println("судья убрал меня в подтрибунное помещение, жду следующего матча ;) ");
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", player=" + player +
                ", size=" + size +
                ", data=" + data +
                '}';
    }
}
