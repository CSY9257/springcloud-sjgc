package com.sjgc.service;

import com.sjgc.idleaf.IdLeafService;
import com.sjgc.idleaf.IdLeafServiceFactory;
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
     * 根据表字段  獲取唯一id
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


}
