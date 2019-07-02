package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 项目名：Network_Study
 * 描述：多线程发送接收
 *
 * @author : Lpc
 * @date : 2019-06-24 20:20
 **/
public class TalkSend implements Runnable {
    private DatagramSocket client;
    private BufferedReader reader;
    private String toIp;
    private int toPort;
    public TalkSend(int port,String toIp,int toPort) {
        this.toPort = toPort;
        this.toIp = toIp;
        try {
            this.client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

            String data;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
// 3、封装成datagramPacket 指定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(toIp, toPort));
// 4、发送包裹
                client.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        client.close();

    }
}
