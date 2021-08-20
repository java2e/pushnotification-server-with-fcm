package com.yaver.fcm.service;
public enum NotificationParameter {
    SOUND("default"), // sound url or name
    COLOR("#FFFF00");

    private String value;

    NotificationParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}