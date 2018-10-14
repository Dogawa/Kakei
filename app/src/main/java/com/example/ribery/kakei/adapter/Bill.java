package com.example.ribery.kakei.adapter;

/**
 * Created by Ribery on 2018/2/12.
 */

public class Bill {
    String date, genre, about, money;
    public Bill(String date, String genre, String about, String money) {
        this.date = date;
        this.genre = genre;
        this.about = about;
        this.money = money;
    }
    public String toString() {
        return date + genre + money + about;
    }
}
