package com.summer.demo.ss.summerstudy.java.inner;

/**
 * Created by xiayundong on 2018/6/29.
 */

public class Parce9 {


    public Destination getDestination(final String des) {
        return new Destination() {
            @Override
            public String readLable() {
                return des;
            }
        };
    }

    public static void main(String[] args) {
        Parce9 parce9 = new Parce9();
        parce9.getDestination("hello parce9");
    }


    interface Destination {
        String readLable();
    }
}
