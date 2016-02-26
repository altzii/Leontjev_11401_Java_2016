package Task004;

/**
 * Created by Alexander on 23/02/2016.
 */
public class NetOnGoal implements Inventory {
    FootballGoal footballGoal;

    public FootballGoal getFootballGoal() {
        return footballGoal;
    }

    public double getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    double size;
    String color;

    public NetOnGoal(FootballGoal footballGoal, double size, String color) {
        this.footballGoal = footballGoal;
        this.size = size;
        this.color = color;
    }

    public NetOnGoal() {
    }

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
        System.out.println("сетку сняли и убрали");
    }
}
