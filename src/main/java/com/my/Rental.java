package com.my;

import java.sql.Timestamp;

/**
 * createed by Administrator on 2017/6/14.
 */
public class Rental {

    private Integer id;
    private String hood;
    private Integer rental;
    private String type;
    private Integer area;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    private String mode;
    private String district;
    private String street;
    private Timestamp create_time;
    private String publisher;
    private String html;
    private String web;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHood() {
        return hood;
    }

    public void setHood(String hood) {
        this.hood = hood;
    }

    public Integer getRental() {
        return rental;
    }

    public void setRental(Integer rental) {
        this.rental = rental;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Timestamp getcreate_time() {
        return create_time;
    }

    public void setcreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
