package com.love.thread.wang_wen_jun.chapter_5;

/**
 * Created by ls on 2018/11/15.
 */

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

public class BooleanLockTest {

    private final ILock lock = new BooleanLock();

    public void syncMethod() {

        try {
            lock.lock();

            int randomInt = current().nextInt(10);
            System.out.println(Thread.currentThread() + " get the lock ");
            TimeUnit.SECONDS.sleep(randomInt);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        BooleanLockTest bt = new BooleanLockTest();
        IntStream.range(0, 10).mapToObj(i -> new Thread(bt::syncMethod)).forEach(Thread::start);

    }


}
