package talkroom2;

import java.io.*;
import java.net.Socket;

/**
 * 项目名：Network_Study
 * 描述：客户端
 *
 * @author : Lpc
 * @date : 2019-07-03 21:33
 **/
public class MultiClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",9876);
        System.out.println("创建客户端");
        //客户端发消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean flag = true;
        while (flag){
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            String receiveMsg = dis.readUTF();
            if ("e".equals(receiveMsg)){
                flag = false;
            }
            System.out.println(receiveMsg);
        }


        dis.close();
        dos.close();
        client.close();
    }
}
