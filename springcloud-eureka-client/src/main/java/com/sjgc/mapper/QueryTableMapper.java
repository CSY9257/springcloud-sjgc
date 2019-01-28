package com.sjgc.mapper;

import com.sjgc.model.IdSegment;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QueryTableMapper {
    @Select(" select t.biz_tag as bizTag ,t.max_id as maxId,t.p_step as pStep,t.last_update_time as lastUpdateTime,t.current_update_time as currentUpdateTime from  id_segment t ")
    List<IdSegment> queryTable();
}
