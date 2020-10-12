package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学期成绩对象 cqie_score
 * 
 * @author xhd
 * @date 2020-10-09
 */
public class CqieScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "ID")
    private Long scoreId;

    /** 学期ID */
    @Excel(name = "学期ID")
    private Long scoreTermId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long scoreStudentId;

    /** 跑步次数 */
    @Excel(name = "跑步次数")
    private Long scoreCounts;

    /** 成绩 */
    @Excel(name = "成绩")
    private String scoreResult;

    private  CqieStudent student;
    private CqieCla cqieCla;
    private CqieClassStudent cqieClassStudent;
    private CqieTerm cqieTerm ;
    private CqieRun cqieRun;

    public CqieStudent getStudent() {
        return student;
    }

    public void setStudent(CqieStudent student) {
        this.student = student;
    }

    public CqieCla getCqieCla() {
        return cqieCla;
    }

    public void setCqieCla(CqieCla cqieCla) {
        this.cqieCla = cqieCla;
    }

    public CqieClassStudent getCqieClassStudent() {
        return cqieClassStudent;
    }

    public void setCqieClassStudent(CqieClassStudent cqieClassStudent) {
        this.cqieClassStudent = cqieClassStudent;
    }

    public CqieTerm getCqieTerm() {
        return cqieTerm;
    }

    public void setCqieTerm(CqieTerm cqieTerm) {
        this.cqieTerm = cqieTerm;
    }

    public CqieRun getCqieRun() {
        return cqieRun;
    }

    public void setCqieRun(CqieRun cqieRun) {
        this.cqieRun = cqieRun;
    }

    public void setScoreId(Long scoreId)
    {
        this.scoreId = scoreId;
    }

    public Long getScoreId() 
    {
        return scoreId;
    }
    public void setScoreTermId(Long scoreTermId) 
    {
        this.scoreTermId = scoreTermId;
    }

    public Long getScoreTermId() 
    {
        return scoreTermId;
    }
    public void setScoreStudentId(Long scoreStudentId) 
    {
        this.scoreStudentId = scoreStudentId;
    }

    public Long getScoreStudentId() 
    {
        return scoreStudentId;
    }
    public void setScoreCounts(Long scoreCounts) 
    {
        this.scoreCounts = scoreCounts;
    }

    public Long getScoreCounts() 
    {
        return scoreCounts;
    }
    public void setScoreResult(String scoreResult) 
    {
        this.scoreResult = scoreResult;
    }

    public String getScoreResult() 
    {
        return scoreResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scoreId", getScoreId())
            .append("scoreTermId", getScoreTermId())
            .append("scoreStudentId", getScoreStudentId())
            .append("scoreCounts", getScoreCounts())
            .append("scoreResult", getScoreResult())
                .append("student",getStudent())
                .append("cqieCla",getCqieCla())
                .append("cqieClassStudent",getCqieClassStudent())
                .append("cqieTerm",getCqieTerm())
                .append("cqieRun",getCqieRun())
            .toString();
    }
}
