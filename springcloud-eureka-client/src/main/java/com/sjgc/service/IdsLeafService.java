package com.sjgc.service;

import com.sjgc.model.IdSegment;

import java.util.List;

public interface IdsLeafService {


    public Long getIdByBizTag(String bizTag);

    Long getLongId();

    List<IdSegment> queryTable();

    Long getId(Long userId);

    /*public Long getOrderId(long userId);*/

}
