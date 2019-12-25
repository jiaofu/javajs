package com.page.shui.fenye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class BonusRecordDTO {

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date bonusDate;


    private String reduceAmount;

    private String feeAmount;


    private String bonusPoints;

    private String lockPoints;

    private String loyaltyPoints;

    private String generalizePoints;

    private String destroyReduce;

    public Date getBonusDate() {
        return bonusDate;
    }

    public void setBonusDate(Date bonusDate) {
        this.bonusDate = bonusDate;
    }

    public String getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(String reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(String bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public String getLockPoints() {
        return lockPoints;
    }

    public void setLockPoints(String lockPoints) {
        this.lockPoints = lockPoints;
    }

    public String getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getGeneralizePoints() {
        return generalizePoints;
    }

    public void setGeneralizePoints(String generalizePoints) {
        this.generalizePoints = generalizePoints;
    }

    public String getDestroyReduce() {
        return destroyReduce;
    }

    public void setDestroyReduce(String destroyReduce) {
        this.destroyReduce = destroyReduce;
    }
}