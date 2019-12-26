package com.page.shui.fenye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class CurrentLockDTO {


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date lockDate;

    private String lockAmount;

    private Integer minLockDay;


    private Integer lockedDay;


    private String loyaltyPoints;


    private String lockPoints;

    private String storeNum;

    private long userId;



    public Date getLockDate() {
        return lockDate;
    }

    public void setLockDate(Date lockDate) {
        this.lockDate = lockDate;
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

    public Integer getLockedDay() {
        return lockedDay;
    }

    public void setLockedDay(Integer lockedDay) {
        this.lockedDay = lockedDay;
    }

    public String getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getLockPoints() {
        return lockPoints;
    }

    public void setLockPoints(String lockPoints) {
        this.lockPoints = lockPoints;
    }

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
