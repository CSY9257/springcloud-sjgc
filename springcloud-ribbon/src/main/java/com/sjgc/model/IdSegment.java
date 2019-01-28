package com.sjgc.model;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class IdSegment implements Serializable {


    private static final long serialVersionUID = 207054728908262466L;

    private String bizTag;
    private Integer maxId;
    private Integer pStep;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date currentUpdateTime;


    public String getBizTag() {
        return bizTag;
    }

    public void setBizTag(String bizTag) {
        this.bizTag = bizTag;
    }

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }

    public Integer getpStep() {
        return pStep;
    }

    public void setpStep(Integer pStep) {
        this.pStep = pStep;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getCurrentUpdateTime() {
        return currentUpdateTime;
    }

    public void setCurrentUpdateTime(Date currentUpdateTime) {
        this.currentUpdateTime = currentUpdateTime;
    }
}
