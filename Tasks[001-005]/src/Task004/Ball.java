package Task004;

/**
 * Created by Alexander on 12/02/2016.
 */
public class Ball implements Inventory {
    int size;
    String name;
    Player owner;
    double weight;
    int tricksCount;   //сколько раз с этим мячом выполняли финт

    public void setTricksCount(int tricksCount) {
        this.tricksCount = tricksCount;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public double getWeight() {
        return weight;
    }

    public double getTricksCount() {
        return tricksCount;
    }


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
