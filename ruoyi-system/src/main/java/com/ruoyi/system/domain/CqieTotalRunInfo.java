package com.ruoyi.system.domain;

public class CqieTotalRunInfo {

    private static final long serialVersionUID = 1L;

    /*跑步总距离*/
    private Long totalDistance;

    /*跑步总次数*/
    private Long totalFrequency;

    /*跑步总时长*/
    private Long totalDuration;

    public Long getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Long getTotalFrequency() {
        return totalFrequency;
    }

    public void setTotalFrequency(Long totalFrequency) {
        this.totalFrequency = totalFrequency;
    }

    public Long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Long totalDuration) {
        this.totalDuration = totalDuration;
    }
}
