package com.page.shui.fenye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class LockRecordDTO {


    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date applicationDate;

    private String lockAmount;

    private Integer minLockDay;

    private String storeNum;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化

    private Date lockDate;

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getLockAmount() {
        return lockAmount;
    }

    public void setLockAmount(String lockAmount) {
        this.lockAmount = lockAmount;
    }

    public Integer getMinLockDay() {
        return minLockDay;
    }

    public void setMinLockDay(Integer minLockDay) {
        this.minLockDay = minLockDay;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public Date getLockDate() {
        return lockDate;
    }

    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
    }
}