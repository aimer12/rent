package com.my;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/14.
 */

@Configuration
public class RentalItem58 implements RentalItem {

     public  Rental parse(String url) {

        Rental rentalinfo = new Rental();
        try {
            Document doc = Jsoup.connect(url).get();

            String rentalString = doc.getElementsByClass("f36").get(0).text();
            Pattern pr=Pattern.compile("\\d+");
            Matcher mr = pr.matcher(rentalString);
            while (mr.find()) {
                rentalString = mr.group(0);
                int rental = Integer.parseInt(rentalString);
                rentalinfo.setRental(rental);
            }


            Element time = doc.getElementsByClass("house-update-info").get(0);
            Pattern p=Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
            Matcher m = p.matcher(time.text());
            String timeString = null;
            Timestamp create_time = null;
            while (m.find()) {
                timeString = m.group(0);
                create_time = Timestamp.valueOf(timeString);
            }

//            System.out.println(time.text());
            String publisher = doc.getElementsByClass("c_000").get(0).text();
//            System.out.println(publisher);

            Element baseinfo = doc.getElementsByClass("f14").get(0);
            String[] typeString = baseinfo.child(1).child(1).text().split("  ");
//            System.out.println(typeString.toString());
            String type = typeString[0];
            int area = Integer.parseInt(typeString[1].replace(" 平", ""));
//            String deractor = typeString[2];

            String hood = baseinfo.child(3).child(1).text();
            if(hood.length()<25){
                rentalinfo.setHood(hood);
            }

            String disString = baseinfo.child(4).child(1).text();
            if(!disString.contains("暂无")) {
                String[] district =disString.split("   ");
                rentalinfo.setDistrict(district[0]);
                if (district.length > 1) {
                rentalinfo.setStreet(district[1]);}
            }

            rentalinfo.setArea(area);
            rentalinfo.setcreate_time(create_time);
//            rentalinfo.setDeractor(deractor);


            rentalinfo.setHtml(url);
            rentalinfo.setPublisher(publisher);


            rentalinfo.setType(type);
            rentalinfo.setWeb("58");
//            System.out.println(type);
//            System.out.println(area);
//            System.out.println(deractor);
//            System.out.println(rental);
//            System.out.println(hood);
//            System.out.println(district[1]);
        } catch (Exception e) {
            System.out.println("处理item异常" + e);
            System.out.println(url);
            e.printStackTrace();
            return null;
        } finally {
//            System.out.println("parse :");
        }
        return rentalinfo;
    }

    public List<String> geturls(String url) throws IOException {
        List<String> urls = new ArrayList<String>();
        Document doc = Jsoup.connect(url).get();
        List<Element> elements = doc.getElementsByClass("des");
        for(Element element : elements){
            urls.add(element.child(0).child(0).attr("href"));
        }
        return urls;
    }

    public  List<String> getlinks(String url) throws IOException {
        List<String> links = new ArrayList<String>();
        String link = null;
        links.add(url);
        try {
        while(links.size()< 1){
            Document doc = Jsoup.connect(links.get(links.size()-1)).get();
            Element element = doc.getElementsByClass("next").get(0);
            link = element.attr("href");
            links.add(link);
        }
        } catch (Exception e) {
            System.out.println("处理link异常" + e);
            System.out.println(link);
            e.printStackTrace();
        } finally {
        }
        return links;
    }


}
