package com.sjgc.service;

import com.sjgc.service.UserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-config")
public interface UserService extends UserServiceApi {

}
