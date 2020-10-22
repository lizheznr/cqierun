package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;

/**
 * 运动记录查询返回信息对象 cqie_run
 *
 * @author 王康
 * @date 2020-10-21
 */
public class CqieSportCalendar {

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

    /** 开跑时间 */
    @Excel(name = "开跑时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 数据状态 */
    private  Long status;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
