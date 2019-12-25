package com.page.shui.fenye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class MineRecordDTO {

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date bonusDate;

    private String feeAmount;

    private String minePrice;


    private String mineAmount;

    private Integer status;


    public Date getBonusDate() {
        return bonusDate;
    }

    public void setBonusDate(Date bonusDate) {
        this.bonusDate = bonusDate;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getMinePrice() {
        return minePrice;
    }

    public void setMinePrice(String minePrice) {
        this.minePrice = minePrice;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMineAmount() {
        return mineAmount;
    }

    public void setMineAmount(String mineAmount) {
        this.mineAmount = mineAmount;
    }
}