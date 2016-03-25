package Task008;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Stick extends JButton {
    private Square left;
    private Square right;
    private int id;

    public Stick() {
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                Stick jb = (Stick) e.getSource();
                if (jb.isEnabled()) {
                    jb.setBackground(Color.RED);
                    jb.setEnabled(false);

                    if (jb.getLeft() != null) {
                        ++jb.getLeft().counter;
                        jb.setEnabled(false);
                        if (jb.getLeft().counter == 4) {
                            jb.getLeft().setBackground(Color.RED);
                            Client.dotsAndSquares.mySquaresCount++;
                            Client.dotsAndSquares.squaresCount--;
                        }
                    }
                    if (jb.getRight() != null) {
                        ++jb.getRight().counter;
                        jb.setEnabled(false);
                        if (jb.getRight().counter == 4) {
                            jb.getRight().setBackground(Color.RED);
                            Client.dotsAndSquares.mySquaresCount++;
                            Client.dotsAndSquares.squaresCount--;
                        }
                    }

                    boolean flag = Client.dotsAndSquares.oldSquaresCount == Client.dotsAndSquares.squaresCount;

                    if (flag) {
                        Client.dotsAndSquares.setEnabled(false);
                    } else {
                        Client.dotsAndSquares.oldSquaresCount = Client.dotsAndSquares.squaresCount;
                    }

                    try {
                        Client.os.flush();
                        Client.os.writeBoolean(flag);
                        Client.os.writeInt(jb.getId());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    if (Client.dotsAndSquares.squaresCount == 0) {
                        Client.dotsAndSquares.setEnabled(true);
                        Client.dotsAndSquares.isWin();
                    }
                }
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public Square getRight() {
        return this.right;
    }

    public void setRight(Square right) {
        this.right = right;
    }

    public Square getLeft() {
        return this.left;
    }

    public void setLeft(Square left) {
        this.left = left;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
