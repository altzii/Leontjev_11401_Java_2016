/**
 * Created by Alexander on 12/02/2016.
 */
public interface Defending {
    void defend(Player player);                 //отобрать мяч, используя навыки защитника
    void sendASignalToTeam(String string);                   //подать команду на выход из штрафной
    void sendTheBallToGoalkeeper(Ball ball);    //отдать пас "домой" на голкипера







}
