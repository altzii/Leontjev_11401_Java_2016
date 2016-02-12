import java.util.Date;

/**
 * Created by Alexander on 12/02/2016.
 */
public class Card implements Inventory {
    String color;       //цвет
    Player player;      //игрок, которому больше всего она показывалась
    double size;
    Date data;          //дата выпуска

    @Override
    public void toBreak() {
        System.out.println("я погнулась и меня уронили в грязь, я больше не пригодна :(");
    }

    @Override
    public void toLose() {
        System.out.println("судья уронил меня, и я потерялась");
    }
}
