package com.sjgc.service;

import com.sjgc.idleaf.IdLeafService;
import com.sjgc.idleaf.IdLeafServiceFactory;
import com.sjgc.idleaf.WithGeneIdLeafService;
import com.sjgc.idleaf.support.IgniteIdLeafServiceImpl;
import com.sjgc.mapper.QueryTableMapper;
import com.sjgc.model.IdSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class IdsLeafServiceImpl implements IdsLeafService {


    @Autowired
    private QueryTableMapper queryTableMapper;

    @Resource
    private IdLeafServiceFactory idLeafServiceFactory;

    @Autowired
    private IdLeafService idLeafService;


    /*
     * 根据表字段  获取唯一id
     * */
    @Override
    public Long getIdByBizTag(String bizTag) {
        Long idByBizTag = idLeafServiceFactory.getIdByBizTag(bizTag);
        return idByBizTag;
    }

    @Override
    public Long getLongId() {
        return idLeafService.getId();
    }

    /*
     * 查詢 表
     * */
    @Override
    public List<IdSegment> queryTable() {
        return queryTableMapper.queryTable();
    }





    /*
     * @Author ChengShuangYin
     * @Description //TODO  带有基因的id生成算法，即在分库分表中会使用   目前分库个数是给的死值
     * @Param   userId
     * @return   Long
     **/
    @Override
    public Long getId(Long userId) {

        if(userId != null && "".equals(userId)){
            userId = 1314L;
        }
        Long prefixOrderId = idLeafService.getId(); //生成全局唯一的id
        int leftMoveBit = leftMoveBit();
        Long lastOrderId = ((prefixOrderId << leftMoveBit) | (userId % 3)); //加入userId基因
        return lastOrderId;  //最终的订单id
    }

    private int leftMoveBit() {

        return Integer.toBinaryString(5).length() - 1;
    }
}
