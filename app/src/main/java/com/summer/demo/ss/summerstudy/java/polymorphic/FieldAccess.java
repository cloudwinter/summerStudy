package com.summer.demo.ss.summerstudy.java.polymorphic;

/**
 * Created by xiayundong on 2018/6/7.
 */

public class FieldAccess {

    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup.field = " + sup.field + " , sup.getField() = " + sup.getField());

        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + " , sub.getField() = " + sub.getField() + " ,sub.getSuperField()" + sub.getSuperField());
    }
}
