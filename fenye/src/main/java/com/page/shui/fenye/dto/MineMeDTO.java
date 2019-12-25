package com.page.shui.fenye.dto;

/**
 * 我的挖矿
 */
public class MineMeDTO {


    private String mineAmount;



    private String mineAsset;


    private String minePrice;


    private String feeAmount;


    private String feeAsset;


    private String lockMine;


    private String delayLockMine;


    private String variableAmount;


    private String delayIssueMine;

    private String delayReleaseMine;//待解锁数量

    public MineMeDTO init(){
        this.mineAmount="0";
        this.minePrice="0";
        this.feeAmount="0";
        this.lockMine="0";
        this.delayLockMine="0";
        this.variableAmount="0";
        this.delayIssueMine="0";
        return this;
    }

    public String getMineAmount() {
        return mineAmount;
    }

    public void setMineAmount(String mineAmount) {
        this.mineAmount = mineAmount;
    }

    public String getMineAsset() {
        return mineAsset;
    }

    public void setMineAsset(String mineAsset) {
        this.mineAsset = mineAsset;
    }

    public String getMinePrice() {
        return minePrice;
    }

    public void setMinePrice(String minePrice) {
        this.minePrice = minePrice;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getFeeAsset() {
        return feeAsset;
    }

    public void setFeeAsset(String feeAsset) {
        this.feeAsset = feeAsset;
    }

    public String getLockMine() {
        return lockMine;
    }

    public void setLockMine(String lockMine) {
        this.lockMine = lockMine;
    }

    public String getDelayLockMine() {
        return delayLockMine;
    }

    public void setDelayLockMine(String delayLockMine) {
        this.delayLockMine = delayLockMine;
    }

    public String getVariableAmount() {
        return variableAmount;
    }

    public void setVariableAmount(String variableAmount) {
        this.variableAmount = variableAmount;
    }

    public String getDelayIssueMine() {
        return delayIssueMine;
    }

    public void setDelayIssueMine(String delayIssueMine) {
        this.delayIssueMine = delayIssueMine;
    }

    public String getDelayReleaseMine() {
        return delayReleaseMine;
    }

    public void setDelayReleaseMine(String delayReleaseMine) {
        this.delayReleaseMine = delayReleaseMine;
    }
}
