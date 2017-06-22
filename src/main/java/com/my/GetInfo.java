package com.my;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public class GetInfo {

    public static void main(String[] args) {
        String url = "http://gz.58.com/chuzu/pn1/";

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        RentalDao rentalDao = ctx.getBean("rentalDao", RentalDao.class);
//        process(url,rentalDao,"com.my.RentalItem58");
        process(url,rentalDao,"com.my.RentalItem58");


        }

    public static void process(String url,RentalDao rentalDao,String className)  {

        List<String> links = new ArrayList<String>();
        int page = 1;

        try {
            Class<?> threadClazz = Class.forName(className);
            Method mparse = threadClazz.getMethod("parse", String.class);
            Method mlinks = threadClazz.getMethod("getlinks", String.class);
            Method murls = threadClazz.getMethod("geturls", String.class);


            links =  (List<String>)mlinks.invoke(null,url);
            System.out.println(links.size());
            for (String link : links) {
                System.out.println("start page: " + page );

//                List<String> urls = RentalItem58.geturls(link);
                List<String> urls = (List<String>)murls.invoke(null, link);

                List<Rental> rentals = new ArrayList<Rental>();
                for (String u : urls) {
                    Rental rental =  (Rental) mparse.invoke(null, u);
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

