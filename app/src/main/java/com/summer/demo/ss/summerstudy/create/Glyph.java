package com.summer.demo.ss.summerstudy.create;

/**
 * Created by xiayundong on 2018/6/12.
 */

public class Glyph {

    void draw() {
        System.out.println("Glyph draw");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
