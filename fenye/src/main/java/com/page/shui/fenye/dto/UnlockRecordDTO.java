package com.page.shui.fenye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//@ApiModel("解锁记录")
public class UnlockRecordDTO {
    //@ApiModelProperty("申请日期")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date applicationDate;

    private String unlockAmount;

    private Integer lockedDay;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date unlockDate;


    private String loyaltyPoints;

    private String lockPoints;

    private String storeNum;

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getUnlockAmount() {
        return unlockAmount;
    }

    public void setUnlockAmount(String unlockAmount) {
        this.unlockAmount = unlockAmount;
    }

    public Integer getLockedDay() {
        return lockedDay;
    }

    public void setLockedDay(Integer lockedDay) {
        this.lockedDay = lockedDay;
    }

    public Date getUnlockDate() {
        return unlockDate;
    }

    public void setUnlockDate(Date unlockDate) {
        this.unlockDate = unlockDate;
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
}