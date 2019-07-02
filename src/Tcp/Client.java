package Tcp;

import javax.imageio.IIOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 项目名：Network_Study
 * 描述：创建客户端
 **1、建立连接，使用socket指定服务的地址合端口
 *
 *  *2、
 *  * 3、操作
 *  *4、释放资源
 * @author : Lpc
 * @date : 2019-06-24 21:34
 **/
public class Client {
    public static void main(String[] args)throws IOException {
        Socket client = new Socket("localhost",9876);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();

        dos.close();
    }
}
