package com.my;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface RentalItem {

    public  Rental parse(String url);
    public List<String> geturls(String url) throws IOException;
    public  List<String> getlinks(String url) throws IOException;


}
