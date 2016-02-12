/**
 * Created by Alexander on 12/02/2016.
 */
public class Ball implements Inventory {
    int size;
    String name;
    Player owner;
    double weight;

    public Ball(int size, String name, Player owner, double weight) {
        this.size = size;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    @Override
    public void toBreak() {
        System.out.println("я порвался ;(");
    }

    @Override
    public void toLose() {
        System.out.println("меня украл какой-то злодей на трибунах");
    }

}
