//package com.my;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//
//import java.sql.Timestamp;
//import java.util.concurrent.Callable;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Created by Administrator on 2017/6/23.
// */
//public class ItemThread implements Callable {
//
//    public Rental call() throws Exception {
//        Rental rentalinfo = new Rental();
//        try {
////            Document doc = Jsoup.connect(url).get();
//
////            String rentalString = doc.getElementsByClass("f36").get(0).text();
//            Pattern pr=Pattern.compile("\\d+");
//////            Matcher mr = pr.matcher(rentalString);
////            while (mr.find()) {
////                rentalString = mr.group(0);
////                int rental = Integer.parseInt(rentalString);
////                rentalinfo.setRental(rental);
////            }
//
//
//            Element time = doc.getElementsByClass("house-update-info").get(0);
//            Pattern p=Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
//            Matcher m = p.matcher(time.text());
//            String timeString = null;
//            Timestamp create_time = null;
//            while (m.find()) {
//                timeString = m.group(0);
//                create_time = Timestamp.valueOf(timeString);
//            }
//
////            System.out.println(time.text());
//            String publisher = doc.getElementsByClass("c_000").get(0).text();
////            System.out.println(publisher);
//
//            Element baseinfo = doc.getElementsByClass("f14").get(0);
//            String[] typeString = baseinfo.child(1).child(1).text().split("  ");
////            System.out.println(typeString.toString());
//            String type = typeString[0];
//            int area = Integer.parseInt(typeString[1].replace(" 平", ""));
////            String deractor = typeString[2];
//
//            String hood = baseinfo.child(3).child(1).text();
//            if(hood.length()<25){
//                rentalinfo.setHood(hood);
//            }
//
//            String disString = baseinfo.child(4).child(1).text();
//            if(!disString.contains("暂无")) {
//                String[] district =disString.split("   ");
//                rentalinfo.setDistrict(district[0]);
//                if (district.length > 1) {
//                    rentalinfo.setStreet(district[1]);}
//            }
//
//            rentalinfo.setArea(area);
//            rentalinfo.setcreate_time(create_time);
////            rentalinfo.setDeractor(deractor);
//
//
//            rentalinfo.setHtml(url);
//            rentalinfo.setPublisher(publisher);
//
//
//            rentalinfo.setType(type);
//            rentalinfo.setWeb("58");
////            System.out.println(type);
////            System.out.println(area);
////            System.out.println(deractor);
////            System.out.println(rental);
////            System.out.println(hood);
////            System.out.println(district[1]);
//        } catch (Exception e) {
//            System.out.println("处理item异常" + e);
//            System.out.println(url);
//            e.printStackTrace();
//            return null;
//        } finally {
////            System.out.println("parse :");
//        }
//        return rentalinfo;
//    }
//
//
//
//}
