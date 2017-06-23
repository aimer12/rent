package com.more;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/23.
 */
public class MyThread implements Runnable {
    private String url;
    private int i;

    public MyThread(String url, int i){
        this.url = url;
        this.i = i;
    }

    public void run() {
        try {
            Document doc = Jsoup.connect(url).get();
//            System.out.println("T "+ Thread.currentThread().getName() + " : " + i);
//            System.out.print(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
