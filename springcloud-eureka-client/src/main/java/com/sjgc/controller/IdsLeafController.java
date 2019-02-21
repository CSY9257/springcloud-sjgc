package com.sjgc.controller;

import com.sjgc.model.IdSegment;
import com.sjgc.service.IdsLeafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("idLeaf")
public class IdsLeafController {


    @Autowired
    private IdsLeafService idsLeafService;

    /**
     * @Author ChengShuangYin
     * @Description //查询表内容
     * @Date 9:40 2019/1/24
     * @Param []
     * @return java.util.List<com.sjgc.model.IdSegment>
     **/
    @RequestMapping(value = "queryTable")
    @ResponseBody
    public List<IdSegment> queryTable() {
        return idsLeafService.queryTable();
    }

    /**
     * @Author ChengShuangYin
     * @Description // TODO 根据数据库字段获取唯一id
     * @Date 9:41 2019/1/24
     * @Param [bizTag]
     * @return java.lang.Long
     **/
    @RequestMapping(value = "getIdByBizTag", method = RequestMethod.GET)
    @ResponseBody
    public Long getIdByBizTag(String bizTag) {
        return idsLeafService.getIdByBizTag(bizTag);
    }

    /**
     * @Author ChengShuangYin
     * @Description //TODO 弱依赖zookeeper  产生19位时间戳*10000 的数值
     * @Date 9:41 2019/1/24
     * @Param []
     * @return java.lang.Long
     **/
    @RequestMapping(value = "getLongId")
    @ResponseBody
    public Long getOrderId() {
        return idsLeafService.getLongId();
    }


    @RequestMapping(value="getOrderByUserId")
    @ResponseBody
    public Long getId(Long userId){
        return idsLeafService.getId(userId);
    };



    // 端口号
    @Value("${server.port}")
    String port;

    @GetMapping(value = "/queryUser2")
    @ResponseBody
    public String home(@RequestParam String name) {
        return "sjgc " + name + " ,i am from port:" + port;
    }

    @GetMapping(value = "/hi")
    @ResponseBody
    public String hi(@RequestParam String name) {
        return "hi " + name + " ,i am from port:" + port;
    }


    @RequestMapping(value="IndexJsp")
    public String IndexJsp(){
        return "/index/index";
    }

}
