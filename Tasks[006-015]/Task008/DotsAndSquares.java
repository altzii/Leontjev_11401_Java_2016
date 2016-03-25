package Task008;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexander on 23/11/15.
 */
public class DotsAndSquares extends JFrame {
    Square[][] squares;
    Stick[] sticks;
    JLabel stepInfo;
    int squaresCount;
    int oldSquaresCount;
    int mySquaresCount;
    int enemySquaresCount;

    public int isWin() {
        int bool = (int) Math.signum(mySquaresCount - enemySquaresCount);

        String result;
        if (bool == 1) {
            result = "YOU WIN!";
        } else if (bool == -1) {
            result = "YOU LOSE!";
        } else {
            result = "DRAW!";
        }

        this.setEnabled(true);
        JOptionPane.showMessageDialog(null, result);
        return bool;
    }


    public DotsAndSquares(int size) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        int buttonHeight = 100;
        int buttonWidth = 20;
        int stickId = 0;

        sticks = new Stick[2 * ((size + 1) * size)];
        squaresCount = size * size;
        oldSquaresCount = squaresCount;
        squares = new Square[size][size];


        setBounds(50, 50, (buttonHeight + buttonWidth) * size + buttonWidth, (buttonHeight + buttonWidth) * size + buttonWidth + 150);
        setLayout(new GroupLayout(getContentPane()));

        stepInfo = new JLabel();
        stepInfo.setHorizontalAlignment(SwingConstants.CENTER);
        stepInfo.setFont(new Font("Arial", Font.PLAIN, 24));
        stepInfo.setBounds(0, (buttonHeight + buttonWidth) * size + buttonWidth + 22, (buttonHeight + buttonWidth) * size + buttonWidth + 5, 80);
        add(stepInfo);

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

}
