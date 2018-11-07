package com.summer.demo.ss.summerstudy.java.reflect;

/**
 * Created by xiayundong on 2018/9/4.
 */

public class Preson extends Parent {

    public String name;

    public String sex;

    public int age;

    private String addr;

    public Preson() {

    }

    public Preson(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setData(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public String getData(String name, String addr, int age) {
        return name + " 今年：" + age + " 住在" + addr;
    }

    private String testPrivate() {
        return "";
    }


}
