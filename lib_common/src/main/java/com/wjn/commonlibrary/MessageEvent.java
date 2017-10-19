package com.wjn.commonlibrary;

/**
 * Created by wjn on 2017/7/3.
 */

public class MessageEvent {
    public String getMessage() {
        return message;
    }

    public final String message;

    public MessageEvent(String message) {
        this.message = message;
    }
}
