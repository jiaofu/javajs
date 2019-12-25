package com.page.shui.fenye.dto;


public class BonusMeDTO {

    private String bonusAmount;


    private String pointAmount;


    private String feeAsset;

    private String reduceAsset;


    private String feeAssetAmount;

    private String reduceAssetAmount;



    private String lockPoint;

    private String loyalPoint;

    private String extensionPoint;

    public BonusMeDTO init(){
        this.bonusAmount="0";
        this.pointAmount="0";
        this.feeAssetAmount="0";
        this.lockPoint="0";
        this.reduceAssetAmount="0";
        this.loyalPoint="0";
        this.extensionPoint="0";
        return this;
    }

    public String getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(String bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(String pointAmount) {
        this.pointAmount = pointAmount;
    }

    public String getFeeAsset() {
        return feeAsset;
    }

    public void setFeeAsset(String feeAsset) {
        this.feeAsset = feeAsset;
    }

    public String getReduceAsset() {
        return reduceAsset;
    }

    public void setReduceAsset(String reduceAsset) {
        this.reduceAsset = reduceAsset;
    }

    public String getFeeAssetAmount() {
        return feeAssetAmount;
    }

    public void setFeeAssetAmount(String feeAssetAmount) {
        this.feeAssetAmount = feeAssetAmount;
    }

    public String getReduceAssetAmount() {
        return reduceAssetAmount;
    }

    public void setReduceAssetAmount(String reduceAssetAmount) {
        this.reduceAssetAmount = reduceAssetAmount;
    }

    public String getLockPoint() {
        return lockPoint;
    }

    public void setLockPoint(String lockPoint) {
        this.lockPoint = lockPoint;
    }

    public String getLoyalPoint() {
        return loyalPoint;
    }

    public void setLoyalPoint(String loyalPoint) {
        this.loyalPoint = loyalPoint;
    }

    public String getExtensionPoint() {
        return extensionPoint;
    }

    public void setExtensionPoint(String extensionPoint) {
        this.extensionPoint = extensionPoint;
    }
}
