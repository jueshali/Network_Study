package udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 项目名：Network_Study
 * 描述：发送端
 **1、使用datagramSoclet指定端口，创建发送端
 *  * 2、将基本数据类型转成数组准备数据（字节数组），
 *  3、封装成datagramPacket 指定目的地
 *  4\发送包裹
 *  * 5|释放资源
 *  *
 * @author : Lpc
 * @date : 2019-06-24 19:06
 **/
public class UdpTypeClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中");

//1、使用datagramSoclet指定端口，创建发送端
        DatagramSocket client = new DatagramSocket(8888);
// 2、准备数据（字节数组），
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
        dos.writeInt(8);
        dos.writeBoolean(true);
        dos.flush();
        byte[] datas = bos.toByteArray();
// 3、封装成datagramPacket 指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
// 4、发送包裹
        client.send(packet);
// 5、释放资源
        client.close();
    }
}
