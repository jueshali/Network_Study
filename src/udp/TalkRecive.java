package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 项目名：Network_Study
 * 描述：接收端:使用面向对象封装
 *
 * @author : Lpc
 * @date : 2019-06-24 20:21
 **/
public class TalkRecive implements Runnable {
    private DatagramSocket sever;


    public TalkRecive(int port) {
        try {
            this.sever = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            //2、准备容器，封装成datagramPacket
            byte[] datas = new byte[1024 * 60];
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length);
//                * 3、阻塞式就受包裹
            try {
                sever.receive(packet);
                byte[] reveiveData = packet.getData();
                String data = new String(reveiveData);
                System.out.println(data);
                if ("bye".equals(data)) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sever.close();
    }
}  