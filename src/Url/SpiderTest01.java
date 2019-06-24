package Url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 项目名：Network_Study
 * 描述：网络爬虫原理
 *
 * @author : Lpc
 * @date : 2019-06-24 17:55
 **/
public class SpiderTest01 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/");
            InputStream is = null;
            try {
                is = url.openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String msg = null;
                try {
                    while (null !=(msg=br.readLine())){
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }




    }
}
