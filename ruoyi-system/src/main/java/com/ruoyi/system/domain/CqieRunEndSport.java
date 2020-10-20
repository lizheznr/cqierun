package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

public class CqieRunEndSport {

    private static final long serialVersionUID = 1L;

    /** ID */
    private Long runId;

    /** 学号 */
    @Excel(name = "学号")
    private String stuNo;

    /** 运动距离 */
    @Excel(name = "运动距离")
    private Long runDistance;

    /** 运动轨迹 */
    @Excel(name = "运动轨迹")
    private String runPathline;

    /** 运动时长 */
    @Excel(name = "运动时长")
    private Long runDuration;

    /** 消耗卡路里 */
    @Excel(name = "消耗卡路里")
    private Long runCalorie;

    /** 平均配速（分钟/公里） */
    @Excel(name = "平均配速", readConverterExp = "分钟/公里")
    private Long runDistribution;

    /** 最高配速（分钟/公里） */
    @Excel(name = "最高配速", readConverterExp = "分钟/公里")
    private Long runMaxdistribution;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRunId() {
        return runId;
    }

    public void setRunId(Long runId) {
        this.runId = runId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Long getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(Long runDistance) {
        this.runDistance = runDistance;
    }

    public String getRunPathline() {
        return runPathline;
    }

    public void setRunPathline(String runPathline) {
        this.runPathline = runPathline;
    }

    public Long getRunDuration() {
        return runDuration;
    }

    public void setRunDuration(Long runDuration) {
        this.runDuration = runDuration;
    }

    public Long getRunCalorie() {
        return runCalorie;
    }

    public void setRunCalorie(Long runCalorie) {
        this.runCalorie = runCalorie;
    }

    public Long getRunDistribution() {
        return runDistribution;
    }

    public void setRunDistribution(Long runDistribution) {
        this.runDistribution = runDistribution;
    }

    public Long getRunMaxdistribution() {
        return runMaxdistribution;
    }

    public void setRunMaxdistribution(Long runMaxdistribution) {
        this.runMaxdistribution = runMaxdistribution;
    }
}
