package com.zipcoder.cryptonator_api.domain;

public class Ticker {

    private String base;
    private String target;
    private String price;
    private String volume;
    private String change;

    public Ticker() {
    }

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }

    public String getPrice() {
        return price;
    }

    public String getVolume() {
        return volume;
    }

    public String getChange() {
        return change;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setChange(String change) {
        this.change = change;
    }
}