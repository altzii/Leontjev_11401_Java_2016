/**
 * Created by Alexander on 12/02/2016.
 */
public class Ball implements Inventory {
    int size;
    String name;
    Player owner;
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
