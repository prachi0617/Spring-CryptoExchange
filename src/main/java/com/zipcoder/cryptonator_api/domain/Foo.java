package com.zipcoder.cryptonator_api.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by leon on 1/22/18.
 */
@Entity
public class Foo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private String target;
    private String price;
    private String volume;
    private String changeValue;
    private LocalDateTime lastUpdated;

    public Foo() {
    }

    public Foo(String symbol, String target, String price, String volume, String changeValue,
            LocalDateTime lastUpdated) {
        this.symbol = symbol;
        this.target = target;
        this.price = price;
        this.volume = volume;
        this.changeValue = changeValue;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
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

    public String getChangeValue() {
        return changeValue;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public void setChangeValue(String changeValue) {
        this.changeValue = changeValue;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
