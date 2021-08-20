package com.yaver.fcm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*

Push Notification Request Model

 */
@Setter
@Getter
@NoArgsConstructor
public class PNRequest {

    private String title;
    private String message;
    private String topic;
    private String token;

    
}