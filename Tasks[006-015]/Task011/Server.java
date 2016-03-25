package Task011;

import Task008.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Alexander on 17/12/2015.
 */

public class Server {
    final int PORT = 3456;
    ArrayList<Connection> connections;

    public Server() throws IOException {
        connections = new ArrayList<Connection>();
        go();
    }

    public void go() throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        while (true) {
            Socket client1 = s.accept();    // ждем посоединения первого игрока
            Socket client2 = s.accept();    // подсоединения второго игрока
        //    connections.add(new Connection(this, client1, client2));
            System.out.println("Соединение установлено");
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}
