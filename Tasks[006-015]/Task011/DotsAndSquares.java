package Task011;

import Task008.Square;
import Task008.Stick;

import javax.swing.*;

/**
 * Created by Alexander on 23/11/15.
 */
public class DotsAndSquares extends JFrame {
    private int size = 0;
    private int buttonWidth = 20;
    private int buttonHeight = 100;
    Square[][] squares;
    Stick[] sticks;


    public DotsAndSquares(int size) {
        int stickId = 0;

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        sticks = new Stick[2 * ((size + 1) * size)];
        squares = new Square[size][size];
        this.size = size;
        setBounds(50, 50, (buttonHeight + buttonWidth) * size + buttonWidth, (buttonHeight + buttonWidth) * size + buttonWidth + 22);
        setLayout(new GroupLayout(getContentPane()));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Square jp = new Square();
                jp.setBounds(i * (buttonHeight + buttonWidth) + buttonWidth, j * (buttonHeight + buttonWidth) + buttonWidth, buttonHeight, buttonHeight);
                squares[i][j] = jp;
                add(jp);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                Stick verticalStick = new Stick();
                verticalStick.setBounds(j * (buttonHeight + buttonWidth), i * (buttonHeight + buttonWidth) + buttonWidth, buttonWidth, buttonHeight); //vertical
                verticalStick.setId(stickId);
                sticks[stickId] = verticalStick;
                add(verticalStick);

                stickId++;

                Stick horizontalStick = new Stick();
                horizontalStick.setBounds(i * (buttonHeight + buttonWidth) + buttonWidth, j * (buttonHeight + buttonWidth), buttonHeight, buttonWidth);  //horizontal
                horizontalStick.setId(stickId);
                sticks[stickId] = horizontalStick;
                add(horizontalStick);

                stickId++;

                if (j > 0) {
                    verticalStick.setLeft(squares[j - 1][i]);
                    horizontalStick.setLeft(squares[i][j - 1]);
                } else {
                    verticalStick.setLeft(null);
                    horizontalStick.setLeft(null);
                }
                if (j < size) {
                    verticalStick.setRight(squares[j][i]);
                    horizontalStick.setRight(squares[i][j]);
                } else {
                    verticalStick.setRight(null);
                    horizontalStick.setRight(null);
                }
            }
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DotsAndSquares(3);
    }
}
