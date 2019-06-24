package Url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 项目名：Network_Study
 * 描述：资源同一定位符互联网三大基石之一
 *1、协议
 * 2、域名
 * 3、端口 http:/ 80
 * 4、请求资源
 * http://www.baidu.com:/80/index.html?uname:
 *
 * @author : Lpc
 * @date : 2019-06-24 17:45
 **/
public class UrlStudy {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com:/80/index.html?uname:");
            System.out.println(url.getHost());
            System.out.println(url.getProtocol());
            System.out.println(url.getFile());
            // 参数， 锚点
            System.out.println("参数"+ url.getQuery());
            System.out.println("锚点"+ url.getRef());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
