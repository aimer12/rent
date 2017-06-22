package com.my;

import org.jsoup.*;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public class GetInfo {

    public static void main(String[] args) {
        String url = "http://gz.58.com/chuzu/pn51/";

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        RentalDao rentalDao = ctx.getBean("rentalDao", RentalDao.class);

        List<String> links = new ArrayList<String>();
        int page = 51;

        try {
            links = RentalItem.getlinks(url);
            System.out.println(links.size());
            for (String link : links) {
                System.out.println("start page: " + page );
                List<String> urls = RentalItem.geturls(link);
                List<Rental> rentals = new ArrayList<Rental>();
                for (String u : urls) {
                    Rental rental = RentalItem.parse(u);
                    if(!(rental ==null)){
                        rentals.add(rental);}
                }
                int i = rentalDao.addRentals(rentals);
                System.out.println("page： " + page + " add : " + i + " records");
                page++;
            }
            }catch(Exception e){
                System.out.println("处理异常" + e);
                e.printStackTrace();
            }
            finally{
            }
            System.out.println("结束");
        }


}

