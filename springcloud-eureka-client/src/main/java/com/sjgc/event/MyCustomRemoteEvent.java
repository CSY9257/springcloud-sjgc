package com.sjgc.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @ClassName: MyCustomRemoteEvent
 * @Date: 2019/2/19 16:20
 * @Author: ChengShuangYin
 * @Description:
 * @Phone: 13146789257
 */
public class MyCustomRemoteEvent extends RemoteApplicationEvent {

    private String message;


    //jackson序列化反序列化必须有无参构造函数
    public MyCustomRemoteEvent() {
    }

    public MyCustomRemoteEvent(Object source, String originService, String destinationService, String message) {
        // source is the object that is publishing the event
        // originService is the unique context ID of the publisher

        super(source, originService, destinationService);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
