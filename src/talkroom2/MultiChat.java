package talkroom2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名：Network_Study
 * 描述：在线聊天是客户端
 * 一个客户可以正常收发多条信息
 * @author : Lpc
 * @date : 2019-07-03 21:33
 **/
public class MultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("创建一个服务端");
        ServerSocket sever = new ServerSocket(9876);
        Socket client = sever.accept();
        System.out.println("一个客户端连接");
        //接收消息
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis  = new DataInputStream(client.getInputStream());
        boolean flag = true;
        while (flag){
            String msg =dis.readUTF();
            dos.writeUTF(msg);
            dos.flush();
        }


        //返回消息
        dis.close();
        dos.close();
        client.close();

    }
}
