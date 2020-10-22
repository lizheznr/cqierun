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
    private Long distance;

    /** 运动轨迹 */
    @Excel(name = "运动轨迹")
    private String pathLine;

    /** 运动时长 */
    @Excel(name = "运动时长")
    private Long duration;

    /** 消耗卡路里 */
    @Excel(name = "消耗卡路里")
    private Long calorie;

    /** 平均配速（分钟/公里） */
    @Excel(name = "平均配速", readConverterExp = "分钟/公里")
    private Long distribution;

    /** 最高配速（分钟/公里） */
    @Excel(name = "最高配速", readConverterExp = "分钟/公里")
    private Long maxDistribution;

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

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public String getPathLine() {
        return pathLine;
    }

    public void setPathLine(String pathLine) {
        this.pathLine = pathLine;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getCalorie() {
        return calorie;
    }

    public void setCalorie(Long calorie) {
        this.calorie = calorie;
    }

    public Long getDistribution() {
        return distribution;
    }

    public void setDistribution(Long distribution) {
        this.distribution = distribution;
    }

    public Long getMaxDistribution() {
        return maxDistribution;
    }

    public void setMaxDistribution(Long maxDistribution) {
        this.maxDistribution = maxDistribution;
    }
}
