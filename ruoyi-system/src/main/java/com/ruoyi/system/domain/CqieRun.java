package com.ruoyi.system.domain;

import java.util.Date;

import com.ruoyi.common.annotation.Excels;
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
    //@Excel(name = "学期ID")
    private Long runTermId;

    /** 学生ID */
   // @Excel(name = "学生ID")
    private Long runStuId;

    @Excel(name = "学期", targetAttr = "termName", type = Excel.Type.EXPORT)
    private CqieTerm cqieTerm;

    @Excel(name = "班级", targetAttr = "claName", type = Excel.Type.EXPORT)
    private CqieCla cqieCla;

    /**学生信息*/
    @Excels({
            @Excel(name="学号",targetAttr = "stuNo",type = Excel.Type.EXPORT),
            @Excel(name="姓名",targetAttr = "stuName",type = Excel.Type.EXPORT)
    })
    private  CqieStudent student;

    /** 经纬度 */
    @Excel(name = "经纬度")
    private String runStar;

    /** 开跑时间 */
    @Excel(name = "开跑时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date runStarTime;

    /** 平均配速（公里/分钟） */
    @Excel(name = "平均配速")
    private double runDistribution;

    /** 最高配速（公里/分钟） */
    @Excel(name = "最高配速")
    private double runMaxdistribution;

    /** 运动距离 */
    @Excel(name = "运动距离")
    private double runDistance;

    /** 运动轨迹 */
    @Excel(name = "运动轨迹")
    private String runPathline;

    /** 运动时长 */
    @Excel(name = "运动时长")
    private double runDuration;

    /** 消耗卡路里 */
    @Excel(name = "消耗卡路里")
    private double runCalorie;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date runEndTime;

    /** 跑步路径 */
    @Excel(name = "跑步路径")
    private String runImg;

    /** 添加时间 */
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date runAddtime;

    /** 备注 */
    @Excel(name = "备注")
    private String runRemark;

    /** 是否完成 */
    @Excel(name = "是否完成", readConverterExp = "0=未完成,1=完成")
    private int runIscomplete;



    private CqieClassStudent cqieClassStudent;
    private SysUser sysUser;


    public Long getRunId() {
        return runId;
    }

    public void setRunId(Long runId) {
        this.runId = runId;
    }

    public Long getRunTermId() {
        return runTermId;
    }

    public void setRunTermId(Long runTermId) {
        this.runTermId = runTermId;
    }

    public Long getRunStuId() {
        return runStuId;
    }

    public void setRunStuId(Long runStuId) {
        this.runStuId = runStuId;
    }

    public String getRunStar() {
        return runStar;
    }

    public void setRunStar(String runStar) {
        this.runStar = runStar;
    }

    public Date getRunStarTime() {
        return runStarTime;
    }

    public void setRunStarTime(Date runStarTime) {
        this.runStarTime = runStarTime;
    }

    public String getRunPathline() {
        return runPathline;
    }

    public void setRunPathline(String runPathline) {
        this.runPathline = runPathline;
    }

    public double getRunDistribution() {
        return runDistribution;
    }

    public void setRunDistribution(double runDistribution) {
        this.runDistribution = runDistribution;
    }

    public double getRunMaxdistribution() {
        return runMaxdistribution;
    }

    public void setRunMaxdistribution(double runMaxdistribution) {
        this.runMaxdistribution = runMaxdistribution;
    }

    public double getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(double runDistance) {
        this.runDistance = runDistance;
    }

    public double getRunDuration() {
        return runDuration;
    }

    public void setRunDuration(double runDuration) {
        this.runDuration = runDuration;
    }

    public double getRunCalorie() {
        return runCalorie;
    }

    public void setRunCalorie(double runCalorie) {
        this.runCalorie = runCalorie;
    }

    public Date getRunEndTime() {
        return runEndTime;
    }

    public void setRunEndTime(Date runEndTime) {
        this.runEndTime = runEndTime;
    }

    public String getRunImg() {
        return runImg;
    }

    public void setRunImg(String runImg) {
        this.runImg = runImg;
    }

    public Date getRunAddtime() {
        return runAddtime;
    }

    public void setRunAddtime(Date runAddtime) {
        this.runAddtime = runAddtime;
    }

    public String getRunRemark() {
        return runRemark;
    }

    public void setRunRemark(String runRemark) {
        this.runRemark = runRemark;
    }

    public int getRunIscomplete() {
        return runIscomplete;
    }

    public void setRunIscomplete(int runIscomplete) {
        this.runIscomplete = runIscomplete;
    }

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

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("runId", getRunId())
                .append("runTermId", getRunTermId())
                .append("runStuId", getRunStuId())
                .append("runStar",getRunStar())
                .append("runStarTime", getRunStarTime())
                .append("runDistribution", getRunDistribution())
                .append("runMaxdistribution", getRunMaxdistribution())
                .append("runDistance",getRunDistance())
                .append("runPathline", getRunPathline())
                .append("runDuration", getRunDuration())
                .append("runCalorie", getRunCalorie())
                .append("runEndTime", getRunEndTime())
                .append("runImg", getRunImg())
                .append("runAddtime", getRunAddtime())
                .append("runRemark", getRunRemark())
                .append("student",getStudent())
                .append("cqieCla",getCqieCla())
                .append("cqieClassStudent",getCqieClassStudent())
                .append("cqieTerm",getCqieTerm())
                .append("runIsComplete",getRunIscomplete())
                .append("sysUser",getSysUser())
                .toString();
    }
}