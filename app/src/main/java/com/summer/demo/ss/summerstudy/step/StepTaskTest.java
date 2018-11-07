package com.summer.demo.ss.summerstudy.step;

/**
 * Created by xiayundong on 2018/5/17.
 */

public class StepTaskTest {

    public static void main(String[] args) {
        new StepTask() {
            @Override
            public void onStep1() {
                System.out.println("step1");
                executeNextStep();
            }

            @Override
            public void onStep2() {
                System.out.println("step2");
                executeNextStep();
            }

            @Override
            public void onStep3() {
                System.out.println("step3");
                executeNextStep();
            }

            @Override
            public void onFinish() {
                System.out.println("onFinish");
            }
        }.execute(2);
    }
}
