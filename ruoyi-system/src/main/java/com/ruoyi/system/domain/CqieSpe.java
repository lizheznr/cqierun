package com.ruoyi.system.domain;

import java.util.Date;

import com.ruoyi.common.annotation.Excels;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 免跑申请对象 cqie_spe
 *
 * @author xhd
 * @date 2020-09-28
 */
public class CqieSpe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long speId;

    /** 学生ID */
    //@Excel(name = "学生ID")
    private Long speStuId;

    /** 学期ID */
    //@Excel(name = "学期ID")
    private Long speTermId;

    @Excel(name = "学期", targetAttr = "termName", type = Excel.Type.EXPORT)
    private CqieTerm cqieTerm;

    @Excel(name = "班级", targetAttr = "claName", type = Excel.Type.EXPORT)
    private CqieCla cqieCla;

    @Excels({
            @Excel(name="学号",targetAttr = "stuNo",type = Excel.Type.EXPORT),
            @Excel(name="姓名",targetAttr = "stuName",type = Excel.Type.EXPORT)
    })
    private CqieStudent cqieStudent;

    /** 申请时间 */
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date speApplytime;

    /** 证明材料 */
    @Excel(name = "证明材料")
    private String speApplymate;

    /** 备注 */
    @Excel(name = "备注")
    private String speRemark;

    /** 是否批准 */
    @Excel(name = "是否批准", readConverterExp = "1=未批准,0=批准")
    private int speIsAgree;


    private CqieClassStudent cqieClassStudent;

    private SysUser sysUser;

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

    public CqieStudent getCqieStudent() {
        return cqieStudent;
    }

    public void setCqieStudent(CqieStudent cqieStudent) {
        this.cqieStudent = cqieStudent;
    }

    public CqieClassStudent getCqieClassStudent() {
        return cqieClassStudent;
    }

    public void setCqieClassStudent(CqieClassStudent cqieClassStudent) {
        this.cqieClassStudent = cqieClassStudent;
    }

    public void setSpeId(Long speId)
    {
        this.speId = speId;
    }

    public Long getSpeId()
    {
        return speId;
    }
    public void setSpeStuId(Long speStuId)
    {
        this.speStuId = speStuId;
    }

    public Long getSpeStuId()
    {
        return speStuId;
    }
    public void setSpeTermId(Long speTermId)
    {
        this.speTermId = speTermId;
    }

    public Long getSpeTermId()
    {
        return speTermId;
    }
    public void setSpeApplytime(Date speApplytime)
    {
        this.speApplytime = speApplytime;
    }

    public Date getSpeApplytime()
    {
        return speApplytime;
    }
    public void setSpeApplymate(String speApplymate)
    {
        this.speApplymate = speApplymate;
    }

    public String getSpeApplymate()
    {
        return speApplymate;
    }
    public void setSpeRemark(String speRemark)
    {
        this.speRemark = speRemark;
    }

    public String getSpeRemark()
    {
        return speRemark;
    }

    public int getSpeIsAgree() {
        return speIsAgree;
    }

    public void setSpeIsAgree(int speIsAgree) {
        this.speIsAgree = speIsAgree;
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
                .append("speId", getSpeId())
                .append("speStuId", getSpeStuId())
                .append("speTermId", getSpeTermId())
                .append("speApplytime", getSpeApplytime())
                .append("speApplymate", getSpeApplymate())
                .append("speRemark", getSpeRemark())
                .append("cqieCla",getCqieCla())
                .append("cqieStudent",getCqieStudent())
                .append("cqieClassStudent",getCqieClassStudent())
                .append("cqieTerm",getCqieTerm())
                .append("speIsAgree",getSpeIsAgree())
                .append("sysUser",getSysUser())
                .toString();
    }
}