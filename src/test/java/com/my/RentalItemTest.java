package com.my;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.R;

/**
 * Created by Administrator on 2017/6/21.
 */


public class RentalItemTest {

    private RentalDao rentalDao;

    @Before
    public  void setUp() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        this.rentalDao = ctx.getBean("rentalDao", RentalDao.class);


    }

    @Test
    public void getRentalItem(){
        String url = "http://gz.58.com/zufang/28016037172043x.shtml";
        Rental r = RentalItem.parse(url);
        System.out.print(r.getArea());
        List<Rental> list = new ArrayList<Rental>();
        list.add(r);
        int i =rentalDao.addRentals(list);
        System.out.print(i);



    }
}
