package com.sjgc.controller;

import com.sjgc.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: kafkaController
 * @Date: 2019/1/24 15:15
 * @Author: ChengShuangYin
 * @Description:
 * @Phone: 13146789257
 */
@RestController
public class kafkaController {

    @Autowired
    private ReceiveService receiveService;




}
