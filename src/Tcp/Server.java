package Tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名：Network_Study
 * 描述：熟悉流程
 *1、指定端口severSocket
 * 2、阻塞式等待连接accept
 * 3、操作
 *4、释放资源
 * @author : Lpc
 * @date : 2019-06-24 21:30
 **/
public class Server {
    public static void main(String[] args) throws IOException {
       // 1、指定端口severSocket
        ServerSocket server = new ServerSocket(9876);
        // * 2、阻塞式等待连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        // * 3、操作
        client.getInputStream();
        //接收数据
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        dis.close();
        client.close();
// *4、释放资源
    }
//
}
