package Task008;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

/**
 * Created by Alexander on 19/12/2015.
 */
public class Connection implements Runnable, Serializable {
    Socket socket1;
    Socket socket2;
    Thread thread;
    Server server;
    DataInputStream in1;
    DataOutputStream out1;
    DataInputStream in2;
    DataOutputStream out2;


    public static void changeStep(DataOutputStream dataOutputStream1, DataOutputStream dataOutputStream2, boolean flag, boolean flag2, int inputId) throws IOException {
        dataOutputStream1.flush();
        dataOutputStream1.writeBoolean(flag);
        dataOutputStream2.writeBoolean(flag2);
        dataOutputStream2.writeInt(inputId);
    }

    public Connection(Server server, Socket socket1, Socket socket2) {
        this.socket1 = socket1;
        this.socket2 = socket2;
        this.server = server;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            out1 = new DataOutputStream(socket1.getOutputStream());
            in1 = new DataInputStream(socket1.getInputStream());
            out2 = new DataOutputStream(socket2.getOutputStream());
            in2 = new DataInputStream(socket2.getInputStream());

            boolean flag = true;
            boolean flag2 = !flag;
            out1.writeBoolean(flag);
            out2.writeBoolean(flag2);

            while (true) {
                //ходит первый
                if (flag) {
                    boolean bool = in1.readBoolean();
                    int inputId = in1.readInt();
                    if (bool) {
                        flag = !flag;
                        flag2 = !flag2;
                    }
                    changeStep(out1, out2, flag, flag2, inputId);
                }

                //ходит второй
                if (flag2) {
                    boolean bool = in2.readBoolean();
                    int inputId2 = in2.readInt();
                    if (bool) {
                        flag = !flag;
                        flag2 = !flag2;
                    }
                    changeStep(out2, out1, flag2, flag, inputId2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
