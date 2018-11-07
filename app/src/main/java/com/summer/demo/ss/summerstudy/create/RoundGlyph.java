package com.summer.demo.ss.summerstudy.create;

/**
 * Created by xiayundong on 2018/6/12.
 */

public class RoundGlyph extends Glyph {

    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(),radius =" + radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw(),radius =" + radius);
    }
}
