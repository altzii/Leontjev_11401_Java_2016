/**
 * Created by Alexander on 23/02/2016.
 */
public class FootballGoal implements Inventory {
    double size;
    NetOnGoal net;
    int age;

    @Override
    public void toBreak(Player player) {
        System.out.println("в меня влетели бутсами, сетка порвалась");
    }

    @Override
    public void toLose() {
        System.out.println("забыли закрыть ворота на стадионе, футбольные ворота украли");
    }

    @Override
    public void removeFromField() {
        System.out.println("матч закончился, убираем ворота с поля");
    }
}
