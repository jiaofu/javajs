package com.page.shui.fenye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BonusStatisticsDTO {
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date bonusDate;


    private String reduceAmount;

    private String feeAmount;

    private long userId;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
