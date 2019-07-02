package local;

import java.io.*;
import java.net.Socket;

/**
 * 项目名：Network_Study
 * 描述：模拟登录双向
 *
 * @author : Lpc
 * @date : 2019-06-29 22:06
 **/
public class Loginclient {

    public static void main(String[] args)throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String uname = console.readLine();
        String upwd = console.readLine();
        Socket client = new Socket("localhost",9876);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(uname + "&"+upwd);
        dos.flush();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        String result = dis.readUTF();
        System.out.println(result);
        dos.close();
    }
}
