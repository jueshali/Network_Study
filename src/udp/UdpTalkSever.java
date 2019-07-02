package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 项目名：Network_Study
 * 描述：接收端实现多次交流
 * 1、使用datagramSoclet指定端口，创建发送端
 * 2、准备容器，封装成datagramPacket
 * 3、阻塞式就受包裹
 * 4、分析数据 getData getLength
 * 5|释放资源
 *
 *
 * @author : Lpc
 * @date : 2019-06-24 19:06
 **/
public class UdpTalkSever {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方准备中");
//         * 1、使用datagramSoclet指定端口，创建发送端
        DatagramSocket sever = new DatagramSocket(9999);
        while (true){
            //2、准备容器，封装成datagramPacket
            byte[] datas = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length);
//                * 3、阻塞式就受包裹
            sever.receive(packet);
//                * 4、分析数据 getData getLength
            byte[] reveiveData = packet.getData();
            String data = new String(reveiveData);
            System.out.println(data);
            if ("bye".equals(data)){
                break;
            }
        }
//
//                * 5|释放资源
        sever.close();
//                *
    }
}
