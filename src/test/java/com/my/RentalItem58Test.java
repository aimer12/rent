package com.my;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */


public class RentalItem58Test {

    private RentalDao rentalDao;

    @Before
    public  void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        this.rentalDao = ctx.getBean("rentalDao", RentalDao.class);


    }

    @Test
    public void getRentalItem(){
        String url = "http://gz.58.com/zufang/28016037172043x.shtml";
        Rental r = RentalItem58.parse(url);
        r.setPointX(new BigDecimal(113.36626434326171875000));
        r.setPointY(new BigDecimal(23.13913154602050781250));
        System.out.println(new BigDecimal(113.36626434326171875000));

        System.out.println(r.getArea());

        List<Rental> list = new ArrayList<Rental>();
        list.add(r);
        int i =rentalDao.addRentals(list);
        System.out.println(i);



    }
}
