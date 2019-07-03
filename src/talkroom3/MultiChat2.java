package talkroom3;

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
public class MultiChat2 {
    public static void main(String[] args) throws IOException {
        System.out.println("创建一个服务端");
        ServerSocket sever = new ServerSocket(9876);
        while (true){
            Socket client = sever.accept();
            System.out.println("一个客户端连接");
            new Thread(new Channel(client)).start();
        }

        //接收消息

    }

}

class Channel implements Runnable{
    private Socket client;
    private DataInputStream dis;
    private DataOutputStream dos;
    boolean flag;


    public Channel(Socket client){
        this.client = client;
        try {
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
       this.flag = true;
    }



    @Override
    public void run() {
        while (flag) {
            try {
                dos.flush();
                String msg = dis.readUTF();
                if ("e".equals(msg)){
                    flag = false;
                }
                dos.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if (dis != null){
                dis.close();
            }
            if (dos != null){
                dos.close();
            }
            if (client != null){
                client.close();
            }



        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }

        //返回消息

    }
}