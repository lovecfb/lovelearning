package com.love.thread.wang_wen_jun.chapter_7;

import java.util.concurrent.TimeUnit;

/**
 * 多个Hook函数的执行和退出顺序是不确定的
 * Hook线程只有收到退出信号的时候会被执行，如果在kill的时候使用了参数-9，那么hook线程不会得到执行，进程将会立即退出
 * hook线程中也可以执行一些资源释放的工作，比如关闭文件句柄、socket连接、数据库connection
 * 尽量不要在Hook线程中执行一些耗时非常常的操作，因为其会导致程序迟迟不能退出
 * <p>
 * <p>
 * <p>
 * Created by ls on 2018/11/28.
 */
public class ThreadHook {

    public static void main(String[] args) {

        // 为应用程序注入钩子线程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println(" The hook thread 1 is running ... ");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The hook thread 1 will exit ... ");
        }));

        // 钩子线程可以注册多个
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                try {
                    System.out.println(" The hook thread 2 is running ... ");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The hook thread 2 will exit ... ");
            }
        });


        System.out.println(" The program will stop");

//        The program will be stop
//        The hook thread 2 is running ...
//        The hook thread 1 is running ...
//        The hook thread 1 will exit ...
//        The hook thread 2 will exit ...

    }


}
