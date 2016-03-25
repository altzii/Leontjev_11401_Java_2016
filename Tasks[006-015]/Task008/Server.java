package Task008;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Alexander on 17/12/2015.
 */
public class Server extends JFrame {
    static ApplicationContext ac;
    ArrayList<Connection> connections;

    public Server() throws IOException {
        ac = new ClassPathXmlApplicationContext("Task008/spring-config-task008.xml");
        setVisible(true);
        setTitle("SERVER");
        setBounds(50, 50, 100, 40);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel(InetAddress.getLocalHost().toString().split("/")[1]);
        jLabel.setBounds(10, 10, 100, 20);
        jLabel.setVisible(true);
        add(jLabel);

        System.out.println("Сервер запущен");
        connections = (ArrayList<Connection>) ac.getBean("arrayList");
        go();
    }

    public void go() throws IOException {
        ServerSocket s = (ServerSocket) ac.getBean("serverSocket");
        while (true) {
            Socket client1 = s.accept();    // ждем посоединения первого игрока
            Socket client2 = s.accept();    // подсоединения второго игрока
            connections.add(new Connection(this, client1, client2));
            System.out.println("Соединение установлено");
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
