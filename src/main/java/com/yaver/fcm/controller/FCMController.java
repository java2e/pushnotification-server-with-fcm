package com.yaver.fcm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yaver.fcm.model.PNRequest;
import com.yaver.fcm.model.PNResponse;
import com.yaver.fcm.service.PNService;

@RestController
public class FCMController {

    private PNService pnService;

    public FCMController(PNService pnService) {
        this.pnService = pnService;
    }

    @PostMapping("/notification/topic")
    public ResponseEntity sendNotification(@RequestBody PNRequest request) {
        pnService.sendPushNotificationWithoutData(request);
        return new ResponseEntity<>(new PNResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PNRequest request) {
        pnService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PNResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    /*
   Send Notification
     */
    @PostMapping("/notification/data")
    public ResponseEntity sendDataNotification(@RequestBody PNRequest request) {
        pnService.sendPushNotification(request);
        return new ResponseEntity<>(new PNResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    
}