package com.summer.demo.ss.summerstudy.java.inner;

/**
 * Created by xiayundong on 2018/11/3.
 */


class D {

}

abstract class E {

}


class Z extends D {
    E makeE() {
        return new E() {

        };
    }
}

public class MultiImplemention {

    static void taskD(D d) {

    }

    static void taskE(E e) {

    }

    public static void main(String[] args) {
        Z z = new Z();
        taskD(z);
        taskE(z.makeE());
    }
}


