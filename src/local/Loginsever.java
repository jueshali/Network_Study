package local;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名：Network_Study
 * 描述：模拟登录
 *
 * @author : Lpc
 * @date : 2019-06-29 22:05
 **/
public class Loginsever {
    public static void main(String[] args) throws IOException {
        // 1、指定端口severSocket
        ServerSocket server = new ServerSocket(9876);
        while(true) {
            Socket client = server.accept();
            // * 2、阻塞式等待连接accept
            new Thread(new Channel(client)).start();
            System.out.println("一个客户端建立了连接");
            // * 3、操作
            //接收数据


        }
// *4、释放资源
    }

}
class Channel implements Runnable{
    private Socket client;
    private DataInputStream dis;
    private DataOutputStream dos;

    public Channel(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                client.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

        String[] dataArr = recive().split("&");
        String uname ="";
        String upwd = "";

        for (String info : dataArr) {
            System.out.println(info);
        }
        uname = dataArr[0];

        System.out.println("uname:"+uname);

        upwd = dataArr[1];
        System.out.println("upwd:"+upwd);
        if (uname.equals("a") && upwd.equals("123")) {
            sent("登录成功");
        }
    }

    public void sent(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String  recive(){
        String datas = "";
        try {
            datas = dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public void release(){

        try {
            dis.close();
            dos.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}