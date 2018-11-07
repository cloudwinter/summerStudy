package com.summer.demo.ss.summerstudy.create;

/**
 * Created by xiayundong on 2018/6/11.
 */

public class ReferenceCounting {

    public static void main(String args[]) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared), new Composing(shared), new Composing(shared), new Composing(shared)};
        for (Composing c : composings) {
            c.dispose();
        }
    }
}
