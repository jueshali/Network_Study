package udp;

/**
 * 项目名：Network_Study
 * 描述：加入多线程实现双向交流
 *
 * @author : Lpc
 * @date : 2019-06-24 20:37
 **/
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9876)).start();
        new Thread(new TalkRecive(9393)).start();

    }
}
