package com.love.thread.wang_wen_jun.chapter_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 如果强制杀死进程，那么进程将不会收到任何中断信号
 * <p>
 * <p>
 * Created by ls on 2018/11/28.
 */
public class PreventDuplicated {

    private final static String LOCK_PATH = "D:/demo";
    private final static String LOCK_FILE = ".lock";
    private final static String PERMISSIONS = "rw------";

    public static void main(String[] args) throws IOException {

        // ① 注入hook函数，在程序退出时删除.lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program received kill SIGNAL ... ");
            getLockFile().toFile().delete();
        }));

        // ② 检查是否存在.lock文件
        checkRunning();

        // ③ 简单模拟当前程序正在运行
        for (; ; ) {
            try {
                System.out.println(" The program is running ... ");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists())
            throw new RuntimeException("The program already running ....");

//        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
//        Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));


    }


    private static Path getLockFile() {
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }


}
