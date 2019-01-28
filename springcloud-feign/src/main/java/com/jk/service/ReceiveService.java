package com.jk.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiveService {

    //绑定通道名
    @Input("myInput")
    SubscribableChannel myInput();
}
