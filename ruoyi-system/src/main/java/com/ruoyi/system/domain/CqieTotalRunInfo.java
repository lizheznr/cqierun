package com.ruoyi.system.domain;


import java.util.Date;

/**
 * 运动统计返回信息对象 cqie_run
 *
 * @author 王康
 * @date 2020-10-21
 */
public class CqieTotalRunInfo {

    private static final long serialVersionUID = 1L;

    /*开炮时间*/
    private Date runStarTime;

    /*跑步总距离*/
    private Double totalDistance;

    /*跑步总次数*/
    private Long totalFrequency;

    /*跑步总时长*/
    private Double totalDuration;

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Long getTotalFrequency() {
        return totalFrequency;
    }

    public void setTotalFrequency(Long totalFrequency) {
        this.totalFrequency = totalFrequency;
    }

    public Double getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Double totalDuration) {
        this.totalDuration = totalDuration;
    }

    public Date getRunStarTime() {
        return runStarTime;
    }

    public void setRunStarTime(Date runStarTime) {
        this.runStarTime = runStarTime;
    }
}
