package com.yaver.fcm.service;

import java.util.HashMap;
import java.util.Map;

import com.yaver.fcm.model.PNRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PNService {

    @Value("#{${app.notifications.defaults}}")
    private Map<String, String> defaults;

    private Logger logger = LoggerFactory.getLogger(PNService.class);
    private FCMService fcmService;

    public PNService(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    

    public void sendPushNotification(PNRequest request) {
        try {
            fcmService.sendMessage(getSamplePayloadData(), request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(PNRequest request) {
        try {
            fcmService.sendMessageWithoutData(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    public void sendPushNotificationToToken(PNRequest request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    private Map<String, String> getSamplePayloadData() {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("messageId", "yaver");
        pushData.put("text", "Hello Yaver!");
        pushData.put("user", "userYaver");
        return pushData;
    }


//    private PushNotificationRequest getSamplePushNotificationRequest() {
//        PushNotificationRequest request = new PushNotificationRequest(defaults.get("title"),
//                defaults.get("message"),
//                defaults.get("topic"));
//        return request;
//    }


}