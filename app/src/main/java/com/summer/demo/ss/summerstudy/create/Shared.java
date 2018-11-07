package com.summer.demo.ss.summerstudy.create;

/**
 * Created by xiayundong on 2018/6/11.
 */

public class Shared {

    private int refcount = 0;

    private static long counter = 0;

    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    public void dispose() {
        if (--refcount == 0) {
            System.out.println("Disposing  " + this);
        }
    }

    public String toString() {
        return "Shared " + id;
    }
}
