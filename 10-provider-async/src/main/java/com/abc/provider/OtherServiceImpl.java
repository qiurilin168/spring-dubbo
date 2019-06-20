package com.abc.provider;

import com.abc.service.OtherService;

import java.util.concurrent.TimeUnit;

public class OtherServiceImpl implements OtherService {

    // 耗时操作
    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String doFirst() {
        sleep();
        return "doFirst()";
    }

    @Override
    public String doSecond() {
        sleep();
        return "doSecond()";
    }

    @Override
    public String doThird() {
        long startTime = System.currentTimeMillis();
        sleep();
        long endTime = System.currentTimeMillis();
        long useTime = endTime - startTime;
        System.out.println("doThird()方法执行用时：" + useTime);
        return "doThird()";
    }

    @Override
    public String doFourth() {
        long startTime = System.currentTimeMillis();
        sleep();
        long endTime = System.currentTimeMillis();
        long useTime = endTime - startTime;
        System.out.println("doFourth()方法执行用时：" + useTime);
        return "doFourth()";
    }
}
