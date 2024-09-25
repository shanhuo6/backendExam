package com.pacemaker.usercenter.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class MySciCardInfo {
    private String aaz501;
    private String aaz507;
    private String aflag;
    private String sjs1;
    private String sjs2;
    private String sjs3;
    private String sjs4;
    private String aab301;
    private String terminal_num;
    private int responsecode;
    private String responsedesc;
    private String result1;
    private String result2;

    public MySciCardInfo() {
    }

    public MySciCardInfo(String aaz501, String aaz507, String aflag, String sjs1, String sjs2, String sjs3, String sjs4, String aab301, String terminal_num, int responsecode, String responsedesc, String result1, String result2) {
        this.aaz501 = aaz501;
        this.aaz507 = aaz507;
        this.aflag = aflag;
        this.sjs1 = sjs1;
        this.sjs2 = sjs2;
        this.sjs3 = sjs3;
        this.sjs4 = sjs4;
        this.aab301 = aab301;
        this.terminal_num = terminal_num;
        this.responsecode = responsecode;
        this.responsedesc = responsedesc;
        this.result1 = result1;
        this.result2 = result2;
    }

    /**
     * 获取
     * @return aaz501
     */
    public String getAaz501() {
        return aaz501;
    }

    /**
     * 设置
     * @param aaz501
     */
    public void setAaz501(String aaz501) {
        this.aaz501 = aaz501;
    }

    /**
     * 获取
     * @return aaz507
     */
    public String getAaz507() {
        return aaz507;
    }

    /**
     * 设置
     * @param aaz507
     */
    public void setAaz507(String aaz507) {
        this.aaz507 = aaz507;
    }

    /**
     * 获取
     * @return aflag
     */
    public String getAflag() {
        return aflag;
    }

    /**
     * 设置
     * @param aflag
     */
    public void setAflag(String aflag) {
        this.aflag = aflag;
    }

    /**
     * 获取
     * @return sjs1
     */
    public String getSjs1() {
        return sjs1;
    }

    /**
     * 设置
     * @param sjs1
     */
    public void setSjs1(String sjs1) {
        this.sjs1 = sjs1;
    }

    /**
     * 获取
     * @return sjs2
     */
    public String getSjs2() {
        return sjs2;
    }

    /**
     * 设置
     * @param sjs2
     */
    public void setSjs2(String sjs2) {
        this.sjs2 = sjs2;
    }

    /**
     * 获取
     * @return sjs3
     */
    public String getSjs3() {
        return sjs3;
    }

    /**
     * 设置
     * @param sjs3
     */
    public void setSjs3(String sjs3) {
        this.sjs3 = sjs3;
    }

    /**
     * 获取
     * @return sjs4
     */
    public String getSjs4() {
        return sjs4;
    }

    /**
     * 设置
     * @param sjs4
     */
    public void setSjs4(String sjs4) {
        this.sjs4 = sjs4;
    }

    /**
     * 获取
     * @return aab301
     */
    public String getAab301() {
        return aab301;
    }

    /**
     * 设置
     * @param aab301
     */
    public void setAab301(String aab301) {
        this.aab301 = aab301;
    }

    /**
     * 获取
     * @return terminal_num
     */
    public String getTerminal_num() {
        return terminal_num;
    }

    /**
     * 设置
     * @param terminal_num
     */
    public void setTerminal_num(String terminal_num) {
        this.terminal_num = terminal_num;
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
        return "MySciCardInfo{aaz501 = " + aaz501 + ", aaz507 = " + aaz507 + ", aflag = " + aflag + ", sjs1 = " + sjs1 + ", sjs2 = " + sjs2 + ", sjs3 = " + sjs3 + ", sjs4 = " + sjs4 + ", aab301 = " + aab301 + ", terminal_num = " + terminal_num + ", responsecode = " + responsecode + ", responsedesc = " + responsedesc + ", result1 = " + result1 + ", result2 = " + result2 + "}";
    }
}