package com.pacemaker.usercenter.model;


public class ORCodeMessage {
    private String qrCode;
    private String orgCode;
    private String orgName;
    private String phone;
    private String regionCode;
    private String address;
    private String operatorId;
    private String operatorName;

    public ORCodeMessage() {
    }

    public ORCodeMessage(String qrCode, String orgCode, String orgName, String phone, String regionCode, String address, String operatorId, String operatorName) {
        this.qrCode = qrCode;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.phone = phone;
        this.regionCode = regionCode;
        this.address = address;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
    }

    /**
     * 获取
     * @return qrCode
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * 设置
     * @param qrCode
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    /**
     * 获取
     * @return orgCode
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 设置
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
     * 获取
     * @return orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return regionCode
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * 设置
     * @param regionCode
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return operatorId
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置
     * @param operatorId
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取
     * @return operatorName
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置
     * @param operatorName
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String toString() {
        return "ORCodeMessage{qrCode = " + qrCode + ", orgCode = " + orgCode + ", orgName = " + orgName + ", phone = " + phone + ", regionCode = " + regionCode + ", address = " + address + ", operatorId = " + operatorId + ", operatorName = " + operatorName + "}";
    }
}
