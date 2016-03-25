package Task006;

/**
 * Created by Alexander on 23/02/2016.
 */
public class NetOnGoal implements Inventory {
    FootballGoal footballGoal;
    double size;
    String color;

    @Override
    public void toBreak(Player player) {
        System.out.println("я порвалась");

    }

    @Override
    public void toLose() {
        System.out.println("потеряли вместе с воротами ;(");
    }

    @Override
    public void removeFromField() {
    }
}
