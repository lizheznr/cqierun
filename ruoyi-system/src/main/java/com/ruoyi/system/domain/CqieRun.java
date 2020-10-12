package com.ruoyi.system.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 跑步信息对象 cqie_run
 *
 * @author xhd
 * @date 2020-09-28
 */
public class CqieRun extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long runId;

    /** 学期ID */
    @Excel(name = "学期ID")
    private Long runTermId;

    /** 学生ID */
    @Excel(name = "学生ID")
    private Long runStuId;

    /** 经度 */
    @Excel(name = "经度")
    private Long runStarLon;

    /** 纬度 */
    @Excel(name = "纬度")
    private Long runStarDim;

    /** 开跑时间 */
    @Excel(name = "开跑时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date runStarTime;

    /** 速度 */
    @Excel(name = "速度")
    private Long runStarSpeed;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date runEndTime;

    /** 跑步路径 */
    @Excel(name = "跑步路径")
    private String runImg;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date runAddtime;

    /** 备注 */
    @Excel(name = "备注")
    private String runRemark;


    /** 是否完成 */
    @Excel(name = "是否完成")
    private int runIsComplete;

    private  CqieStudent student;
    private CqieCla cqieCla;
    private CqieClassStudent cqieClassStudent;
    private CqieTerm cqieTerm ;

    public CqieTerm getCqieTerm() {
        return cqieTerm;
    }

    public void setCqieTerm(CqieTerm cqieTerm) {
        this.cqieTerm = cqieTerm;
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

    public CqieStudent getStudent() {
        return student;
    }

    public void setStudent(CqieStudent student) {
        this.student = student;
    }

    public void setRunId(Long runId)
    {
        this.runId = runId;
    }

    public Long getRunId()
    {
        return runId;
    }
    public void setRunTermId(Long runTermId)
    {
        this.runTermId = runTermId;
    }

    public Long getRunTermId()
    {
        return runTermId;
    }
    public void setRunStuId(Long runStuId)
    {
        this.runStuId = runStuId;
    }

    public Long getRunStuId()
    {
        return runStuId;
    }
    public void setRunStarLon(Long runStarLon)
    {
        this.runStarLon = runStarLon;
    }

    public Long getRunStarLon()
    {
        return runStarLon;
    }
    public void setRunStarDim(Long runStarDim)
    {
        this.runStarDim = runStarDim;
    }

    public Long getRunStarDim()
    {
        return runStarDim;
    }
    public void setRunStarTime(Date runStarTime)
    {
        this.runStarTime = runStarTime;
    }

    public Date getRunStarTime()
    {
        return runStarTime;
    }
    public void setRunStarSpeed(Long runStarSpeed)
    {
        this.runStarSpeed = runStarSpeed;
    }

    public Long getRunStarSpeed()
    {
        return runStarSpeed;
    }
    public void setRunEndTime(Date runEndTime)
    {
        this.runEndTime = runEndTime;
    }

    public Date getRunEndTime()
    {
        return runEndTime;
    }
    public void setRunImg(String runImg)
    {
        this.runImg = runImg;
    }

    public String getRunImg()
    {
        return runImg;
    }
    public void setRunAddtime(Date runAddtime)
    {
        this.runAddtime = runAddtime;
    }

    public Date getRunAddtime()
    {
        return runAddtime;
    }
    public void setRunRemark(String runRemark)
    {
        this.runRemark = runRemark;
    }

    public String getRunRemark()
    {
        return runRemark;
    }

    public int getRunIsComplete() {
        return runIsComplete;
    }

    public void setRunIsComplete(int runIsComplete) {
        this.runIsComplete = runIsComplete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("runId", getRunId())
                .append("runTermId", getRunTermId())
                .append("runStuId", getRunStuId())
                .append("runStarLon", getRunStarLon())
                .append("runStarDim", getRunStarDim())
                .append("runStarTime", getRunStarTime())
                .append("runStarSpeed", getRunStarSpeed())
                .append("runEndTime", getRunEndTime())
                .append("runImg", getRunImg())
                .append("runAddtime", getRunAddtime())
                .append("runRemark", getRunRemark())
                .append("student",getStudent())
                .append("cqieCla",getCqieCla())
                .append("cqieClassStudent",getCqieClassStudent())
                .append("cqieTerm",getCqieTerm())
                .append("runIsComplete",getRunIsComplete())
                .toString();
    }
}