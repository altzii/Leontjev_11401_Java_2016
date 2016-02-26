package Task004;

/**
 * Created by Alexander on 12/02/2016.
 */
public interface Inventory {
    void toBreak(Player player);         //сломаться
    void toLose();          //потеряться
    void removeFromField();  //убрать в подтрибунное помещение
}
