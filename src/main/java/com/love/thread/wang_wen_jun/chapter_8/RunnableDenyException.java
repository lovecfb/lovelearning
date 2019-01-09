package com.love.thread.wang_wen_jun.chapter_8;

/**
 * user define exception
 * <p>
 * Created by ls on 2018/11/29.
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}
