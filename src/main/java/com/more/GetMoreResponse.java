package com.more;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/23.
 */
public class GetMoreResponse {
    public static void main(String[] args) {
        String  url = "https://www.baidu.com";
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        try {
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
            long start=System.currentTimeMillis();
            System.out.println("开始 "+start);


            for(int i =0; i<2000000; i++) {
                fixedThreadPool.execute(new MyThread(url, i));

            }
//            for(int i = 0; i < 100; i++){
//                Document doc = Jsoup.connect(url).get();
//            }

            long end=System.currentTimeMillis();
            System.out.println("总耗时为："+(end-start)+"毫秒");
        }catch(Exception e){
            System.out.println("Other Exception:");
            System.out.println(e);
        }finally {
            System.out.println("结束");


        }



    }


}
