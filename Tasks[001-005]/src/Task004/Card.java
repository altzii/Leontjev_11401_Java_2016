package Task004;

import java.util.Date;

/**
 * Created by Alexander on 12/02/2016.
 */
public class Card implements Inventory {
    Color color;       //цвет
    Player player;      //игрок, которому больше всего она показывалась
    double size;        //размер
    Date data;          //дата выпуска

    public Card(Color color, Player player, double size) {
        this.color = color;
        this.player = player;
        this.size = size;
    }

    public Card() {
    }

    public Color getColor() {
        return color;
    }

    public Player getPlayer() {
        return player;
    }

    public double getSize() {
        return size;
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
}
