package com.sjgc.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SendService {
    //绑定通道名
    @Output("myInput")
    SubscribableChannel sendOrder();

}
