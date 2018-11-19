package com.love.thread.wang_wen_jun.chapter_4;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/7.
 */
public class Mutex {

    private final static Object MUTEX = new Object();

    public void accessResource() {
        synchronized (MUTEX) {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Mutex mutex = new Mutex();
        for (int i = 0; i < 5; i++) {
            new Thread(mutex::accessResource).start();
        }


    }


}
