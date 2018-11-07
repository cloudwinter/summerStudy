package com.summer.demo.ss.summerstudy.create;

/**
 * Created by xiayundong on 2018/6/11.
 */

public class Composing {

    private Shared shared;

    private static long counter = 0;

    private  long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("Disposing " + this);
        shared.dispose();
    }

    public String toString() {
        return "Composing " + id;
    }
}
