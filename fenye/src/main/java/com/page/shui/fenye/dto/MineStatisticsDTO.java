package com.page.shui.fenye.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public class MineStatisticsDTO {

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") //时间格式化
    private Date mineData;

    private long userId;

    private String amount;

    public Date getMineData() {
        return mineData;
    }

    public void setMineData(Date mineData) {
        this.mineData = mineData;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
