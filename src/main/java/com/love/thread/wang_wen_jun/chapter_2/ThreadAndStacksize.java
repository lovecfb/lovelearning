package com.love.thread.wang_wen_jun.chapter_2;

/**
 * Created by ls on 2018/11/5.
 */
public class ThreadAndStacksize {

    /**
     *
     * 相对比较精准的线程计算公式：
     *  ReservedOsMemory：系统保留内存，一般在136M左右
     *  线程数量 = (最大地址空间（MaxProcessMemory） - JVM堆内存 - ReservedOsMemory) / ThreadStackSize(XSS)
     *
     *  另外和操作系统的内核配置也有关，比如在Linux下：
     *     /proc/sys/kernel/threads-max
     *     /proc/sys/kernel/pid-max
     *     /proc/sys/vm/max_map_count
     *
     *
     */
}
