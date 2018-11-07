package com.summer.demo.ss.summerstudy.java.init;

/**
 * Created by xiayundong on 2018/6/5.
 */

public class Mugs {

    Mug mug1;
    Mug mug2;

    {
        mug1 = new Mug(1);
        mug2 = new Mug(2);
        System.out.println("mug1 & mug2 initialized");



    }

    Mugs() {
        System.out.println("Mugs()");

        int[] a1 = new int[2];
        System.out.println("a1"+a1[0]+"  "+a1[1]);
    }

    Mugs(int i) {
        System.out.println("Mugs(int)");
    }

    public static void main(String[] args) {
        System.out.println("Inside main()");
        new Mugs();
        System.out.println("new Mugs() completed");
        new Mugs(1);
        System.out.println("new Mugs(1) completed");
    }
}
