package com.pacemaker.usercenter.model;

public class s {
    private int responsecode;
    private String responsedesc;
    private String result1;
    private String result2;

    public s() {
    }

    public s(int responsecode, String responsedesc, String result1, String result2) {
        this.responsecode = responsecode;
        this.responsedesc = responsedesc;
        this.result1 = result1;
        this.result2 = result2;
    }

    /**
     * 获取
     * @return responsecode
     */
    public int getResponsecode() {
        return responsecode;
    }

    /**
     * 设置
     * @param responsecode
     */
    public void setResponsecode(int responsecode) {
        this.responsecode = responsecode;
    }

    /**
     * 获取
     * @return responsedesc
     */
    public String getResponsedesc() {
        return responsedesc;
    }

    /**
     * 设置
     * @param responsedesc
     */
    public void setResponsedesc(String responsedesc) {
        this.responsedesc = responsedesc;
    }

    /**
     * 获取
     * @return result1
     */
    public String getResult1() {
        return result1;
    }

    /**
     * 设置
     * @param result1
     */
    public void setResult1(String result1) {
        this.result1 = result1;
    }

    /**
     * 获取
     * @return result2
     */
    public String getResult2() {
        return result2;
    }

    /**
     * 设置
     * @param result2
     */
    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public String toString() {
        return "s{responsecode = " + responsecode + ", responsedesc = " + responsedesc + ", result1 = " + result1 + ", result2 = " + result2 + "}";
    }
}
