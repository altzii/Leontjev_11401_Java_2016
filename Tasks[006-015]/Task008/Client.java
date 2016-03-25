package Task008;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Alexander on 19/12/2015.
 */
public class Client {
    public static DataOutputStream os;
    public static DataInputStream is;
    public static Socket socket;
    public static DotsAndSquares dotsAndSquares;
    public static boolean flag;
    static ApplicationContext ac;

    public static void paintSquare(Square square, Color color) {
        if (square != null) {
            ++square.counter;
            if (square.counter == 4) {
                square.setBackground(color);
                Client.dotsAndSquares.enemySquaresCount++;
                Client.dotsAndSquares.squaresCount--;
            }
        }
    }

    public static void paintSquaresAroundTheStick(Stick stick, Color color) {
        paintSquare(stick.getLeft(), color);
        paintSquare(stick.getRight(), color);
        stick.setEnabled(false);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ac = new ClassPathXmlApplicationContext("Task008/spring-config-task008.xml");
        boolean inputIp = false;

        while (!inputIp) {
            String input = JOptionPane.showInputDialog(null, "Введите ip адрес сервера", null, JOptionPane.CLOSED_OPTION);
            if (input.length() > 0) {
                try {
                    socket = new Socket(input, 3456);
                    inputIp = true;
                } catch (SocketException | UnknownHostException s) {
                    inputIp = false;
                }
            }
        }

        dotsAndSquares = (DotsAndSquares) ac.getBean("dotsAndSquares");
        os = new DataOutputStream(socket.getOutputStream());
        is = new DataInputStream(socket.getInputStream());
        flag = is.readBoolean();

        while (true) {
            if (flag) {
                dotsAndSquares.stepInfo.setForeground(Color.GREEN);
                dotsAndSquares.stepInfo.setText("Ваш ход");
                dotsAndSquares.oldSquaresCount = dotsAndSquares.squaresCount;
            } else {
                dotsAndSquares.stepInfo.setForeground(Color.RED);
                dotsAndSquares.stepInfo.setText("Ход противника");
            }
            dotsAndSquares.setEnabled(flag);

            if (!flag) {                            //ходит противник
                flag = is.readBoolean();
                int inputId = is.readInt();
                Stick stick = dotsAndSquares.sticks[inputId];
                stick.setBackground(Color.BLUE);
                stick.setEnabled(false);
                paintSquaresAroundTheStick(stick, Color.BLUE);

                if (Client.dotsAndSquares.squaresCount == 0) {
                    dotsAndSquares.setEnabled(true);
                    dotsAndSquares.isWin();
                }
            } else {
                flag = is.readBoolean();            //ходит клиент
            }
        }
    }
}
