package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

/**
 * 跑步结束返回信息对象 cqie_run
 *
 * @author 王康
 * @date 2020-10-19
 */
public class CqieRunEndSport {

    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 学号 */
    @Excel(name = "学号")
    private String account;

    /** 运动距离 */
    @Excel(name = "运动距离")
    private Double distance;

    /** 运动轨迹 */
    @Excel(name = "运动轨迹")
    private String pathLine;

    /** 运动时长 */
    @Excel(name = "运动时长")
    private Double duration;

    /** 消耗卡路里 */
    @Excel(name = "消耗卡路里")
    private Double calorie;

    /** 平均配速（分钟/公里） */
    @Excel(name = "平均配速", readConverterExp = "分钟/公里")
    private Double distribution;

    /** 最高配速（分钟/公里） */
    @Excel(name = "最高配速", readConverterExp = "分钟/公里")
    private Double maxDistribution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getPathLine() {
        return pathLine;
    }

    public void setPathLine(String pathLine) {
        this.pathLine = pathLine;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    public Double getDistribution() {
        return distribution;
    }

    public void setDistribution(Double distribution) {
        this.distribution = distribution;
    }

    public Double getMaxDistribution() {
        return maxDistribution;
    }

    public void setMaxDistribution(Double maxDistribution) {
        this.maxDistribution = maxDistribution;
    }
}
