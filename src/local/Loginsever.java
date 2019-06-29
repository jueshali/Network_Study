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
        // * 2、阻塞式等待连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        // * 3、操作
        client.getInputStream();
        //接收数据
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        String[] dataArr = data.split("&");
        String uname = "";
        String upwd = "";
        boolean flag = false;
        for (String info:dataArr){
            System.out.println(info);
        }
        if (uname == "a" && upwd =="123"){
            flag = true;
        }
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if (flag){
           dos.writeUTF("成功");
        }else {
            dos.writeUTF("失败");
        }
       dos.flush();

        dis.close();

// *4、释放资源
    }
}
